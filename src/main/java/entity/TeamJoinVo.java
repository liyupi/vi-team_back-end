package entity;

import java.util.Date;

/**
 * @Author: Yupi Li
 * @Date: Created in 15:33 2018/5/17
 * @Description:
 * @Modified By:
 */
public class TeamJoinVo extends Team {
    private Date joinDate;

    private Date inviteDate;

    public Date getInviteDate() {
        return inviteDate;
    }

    public void setInviteDate(Date inviteDate) {
        this.inviteDate = inviteDate;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
