package controller;

import com.github.pagehelper.Page;
import entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TeamMemberService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Yupi Li
 * @Date: Created in 21:02 2018/5/15
 * @Description:
 * @Modified By:
 */

@Controller
@CrossOrigin
public class TeamMemberController {
    @Resource
    private TeamMemberService teamMemberService;

    @RequestMapping("/teamMember/add")
    @ResponseBody
    public Map<String, Object> addTeamMember(TeamMember teamMember, String creatorId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            int code = teamMemberService.addTeamMember(teamMember, creatorId, token);
            map.put("code", code);
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/teamMember/delete")
    @ResponseBody
    public Map<String, Object> deleteMember(TeamMemberKey teamMemberKey, String userId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            int code = teamMemberService.deleteMember(teamMemberKey, userId, token);
            map.put("code", code);
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/teamMember/update")
    @ResponseBody
    public Map<String, Object> updateTeamMember(TeamMember teamMember, String userId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            int code = teamMemberService.updateTeamMember(teamMember, userId, token);
            map.put("code", code);
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/teamMember/quit")
    @ResponseBody
    public Map<String, Object> userQuitTeam(TeamMemberKey teamMemberKey, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            int code = teamMemberService.userQuitTeam(teamMemberKey, token);
            map.put("code", code);
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/teamMember/deal/invitation")
    @ResponseBody
    public Map<String, Object> userDealInvitation(TeamMember teamMember, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            int code = teamMemberService.userDealInvitation(teamMember, token);
            map.put("code", code);
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/teamMember/get/teams")
    @ResponseBody
    public Map<String, Object> getMemberTeamsByPage(TeamMember teamMember, String token, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Team> teamList = teamMemberService.getMemberTeamsByPage(teamMember, token, page, limit);
            if (teamList != null) {
                long total = ((Page) teamList).getTotal();
                map.put("total", total);
                if (teamList.size() > 0) {
                    map.put("teamList", teamList);
                    map.put("code", 0);
                } else {
                    map.put("code", 4);
                }
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/teamMember/get/members")
    @ResponseBody
    public Map<String, Object> getTeamMembersByPage(TeamMember teamMember, String token, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<UserJoinVo> userList = teamMemberService.getTeamMembersByPage(teamMember, token, page, limit);
            if (userList != null) {
                long total = ((Page) userList).getTotal();
                map.put("total", total);
                if (userList.size() > 0) {
                    map.put("userList", userList);
                    map.put("code", 0);
                } else {
                    map.put("code", 4);
                }
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

}
