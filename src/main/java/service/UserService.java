package service;

import entity.User;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @Author: Yupi Li
 * @Date: Created in 9:47 2018/5/10
 * @Description:
 * @Modified By:
 */

public interface UserService {
    User checkUser(String userId, String password);

    Map<String, Object> userLogin(String userId, String password) throws NoSuchAlgorithmException;

    boolean userRegister(User user);

    boolean changePassword(String userId, String oldPassword, String newPassword);

    boolean userLogout(String userId, String token);

    User getUserById(String userId, String token);

    Map<String,Object> searchUser(String userId,String token);

    boolean updateUser(User user,String token);
}
