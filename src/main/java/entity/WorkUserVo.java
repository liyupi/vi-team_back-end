package entity;

import mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Yupi Li
 * @Date: Created in 23:19 2018/5/20
 * @Description:
 * @Modified By:
 */
public class WorkUserVo extends Work{
    private String userId;
    private String username;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
