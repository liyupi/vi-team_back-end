package controller;

import com.github.pagehelper.Page;
import entity.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.TeamService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Yupi Li
 * @Date: Created in 13:56 2018/5/13
 * @Description:
 * @Modified By:
 */
@Controller
@CrossOrigin
public class TeamController {

    @Resource
    private TeamService teamService;

    @RequestMapping("/team/create")
    @ResponseBody
    public Map<String, Object> createTeam(Team team, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (teamService.createTeam(team, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/team/get/create/detail")
    @ResponseBody
    public Map<String, Object> getCreateTeamByPage(String userId, String token, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Team> teamList = teamService.getCreateTeamByPage(userId, token, page, limit);
            if (teamList != null) {
                long total = ((Page)teamList).getTotal();
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

    @RequestMapping("/team/get/create/list")
    @ResponseBody
    public Map<String, Object> getCreateTeamAll(String userId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Team> teamList = teamService.getCreateTeamAll(userId, token);
            if (teamList != null) {
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

    @RequestMapping("/team/update")
    @ResponseBody
    public Map<String, Object> updateTeam(Team team, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            int code = teamService.updateTeam(team, token);
            map.put("code", code);
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/team/upload/pic")
    @ResponseBody
    public Map<String, Object> uploadTeamPic(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile file, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            String src = teamService.uploadTeamPic(request, file, token);
            if (src != null) {
                System.out.println(src);
                map.put("src", src);
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
