package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Yupi Li
 * @Date: Created in 9:48 2018/5/10
 * @Description:
 * @Modified By:
 */

@Controller
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/user/login")
    @ResponseBody
    public Map<String, Object> userLogin(String userId, String password) {
        Map<String, Object> map = new HashMap<>();
        try {
            Map<String, Object> loginInfo = userService.userLogin(userId, password);
            if (loginInfo != null) {
                map = loginInfo;
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/user/register")
    @ResponseBody
    public Map<String, Object> userRegister(User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (userService.userRegister(user)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/user/changePassword")
    @ResponseBody
    public Map<String, Object> changePassword(String userId, String oldPassword, String newPassword) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (userService.changePassword(userId, oldPassword, newPassword)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/user/logout")
    @ResponseBody
    public Map<String, Object> userLogout(String userId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (userService.userLogout(userId, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/user/getInfo")
    @ResponseBody
    public Map<String, Object> getUserInfo(String userId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            User user = userService.getUserById(userId, token);
            if (user != null) {
                user.setPassword("");//隐藏密码
                map.put("user", user);
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }


    @RequestMapping("/user/search")
    @ResponseBody
    public Map<String, Object> searchUser(String userId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = userService.searchUser(userId, token);
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/user/update")
    @ResponseBody
    public Map<String, Object> updateUser(User user, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            System.out.println(user.getUsername());
            if (userService.updateUser(user, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }
}
