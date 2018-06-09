package service;

import entity.*;

import java.util.List;

/**
 * @Author: Yupi Li
 * @Date: Created in 17:25 2018/5/15
 * @Description:
 * @Modified By:
 */

public interface TeamMemberService {
    int addTeamMember(TeamMember teamMember, String creatorId, String token);

    int deleteMember(TeamMemberKey teamMemberKey, String userId, String token);

    int updateTeamMember(TeamMember teamMember, String userId, String token);

    int userQuitTeam(TeamMemberKey teamMemberKey, String token);

    int userDealInvitation(TeamMember teamMember, String token);

    List<Team> getMemberTeamsByPage(TeamMember teamMember, String token, int page, int limit);

    List<UserJoinVo> getTeamMembersByPage(TeamMember teamMember, String token, int page, int limit);

}
