package entity;

import java.util.Date;

/**
 * @Author: Yupi Li
 * @Date: Created in 15:33 2018/5/17
 * @Description:
 * @Modified By:
 */
public class UserJoinVo extends User {
    private Date joinDate;
    private String position;
    private Date inviteDate;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getInviteDate() {
        return inviteDate;
    }

    public void setInviteDate(Date inviteDate) {
        this.inviteDate = inviteDate;
    }
}
