package service;

import entity.User;
import entity.UserExample;
import mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Author: Yupi Li
 * @Date: Created in 9:51 2018/5/10
 * @Description:
 * @Modified By:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private Jedis jedis;

    /**
     * 核对用户名和密码
     **/
    @Override
    public User checkUser(String userId, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId).andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() > 0) {
            User user = userList.get(0);
            user.setPassword("");
            return user;
        } else {
            return null;
        }
    }

    /**
     * 用户登录，返回随机生成的Token
     **/
    @Override
    public Map<String, Object> userLogin(String userId, String password) {
        Map<String, Object> map = new HashMap<>();
        User user = this.checkUser(userId, password);
        if (user != null) {
            String s = UUID.randomUUID().toString().replace("-", "");
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("md5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            byte[] digest = messageDigest.digest((s + user.hashCode()).getBytes());
            String token = Base64.getEncoder().encodeToString(digest);
            //jedis存储userId及token
            Map<String, String> jedisMap = new HashMap<>();
            jedisMap.put("userId", userId);
            jedis.hmset(token, jedisMap);
            jedis.expire(token, 5400);
            map.put("token", token);
            map.put("user", user);
            return map;
        } else {
            return null;
        }
    }

    /**
     * 用户注册
     **/
    @Override
    public boolean userRegister(User user) {
        User user1 = userMapper.selectByPrimaryKey(user.getUserId());
        if (user1 != null) {
            return false;
        } else {
            user.setUsername("无名氏");
            user.setRegisterDate(new Date());
            userMapper.insert(user);
            return true;
        }
    }

    /**
     * 修改密码
     **/
    @Override
    public boolean changePassword(String userId, String oldPassword, String newPassword) {
        User user = this.checkUser(userId, oldPassword);
        if (user != null) {
            user.setPassword(newPassword);
            userMapper.updateByPrimaryKeySelective(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean userLogout(String userId, String token) {
        if (jedis.exists(token) && jedis.hmget(token, "userId").get(0).equals(userId)) {
            jedis.del(token);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getUserById(String userId, String token) {
        if (jedis.exists(token) && jedis.hmget(token, "userId").get(0).equals(userId)) {
            return userMapper.selectByPrimaryKey(userId);
        } else {
            return null;
        }
    }

    @Override
    public Map<String, Object> searchUser(String userId, String token) {
        Map<String, Object> map = new HashMap<>();
        if (jedis.exists(token)) {
            User user = userMapper.selectByPrimaryKey(userId);
            if (user == null) {
                map.put("code", 4);
            } else {
                map.put("user", user);
                map.put("code", 0);
            }
        } else {
            map.put("code", 2);
        }
        return map;
    }

    @Override
    public boolean updateUser(User user, String token) {
        if (jedis.exists(token)) {
            userMapper.updateByPrimaryKeySelective(user);
            return true;
        } else {
            return false;
        }
    }


}
