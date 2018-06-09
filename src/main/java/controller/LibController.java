package controller;

import com.github.pagehelper.Page;
import entity.Lib;
import entity.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.LibService;
import service.TeamService;

import javax.annotation.Resource;
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
public class LibController {

    @Resource
    private LibService libService;

    @RequestMapping("/lib/add")
    @ResponseBody
    public Map<String, Object> addLib(Lib lib, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (libService.addLib(lib, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/lib/get/team")
    @ResponseBody
    public Map<String, Object> getTeamLibByPage(Integer teamId, String token, Integer status, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Lib> libList = libService.getLibsByTeamIdByPage(teamId, token, status, page, limit);
            if (libList != null) {
                long total = ((Page) libList).getTotal();
                map.put("total", total);
                if (libList.size() > 0) {
                    map.put("libList", libList);
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

    @RequestMapping("/lib/get/libId")
    @ResponseBody
    public Map<String, Object> getLibById(Integer libId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            Lib lib = libService.getLibById(libId, token);
            if (lib != null) {
                map.put("lib", lib);
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }


    @RequestMapping("/lib/update")
    @ResponseBody
    public Map<String, Object> updateLib(Lib lib, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (libService.updateLib(lib, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/lib/delete")
    @ResponseBody
    public Map<String, Object> deleteLib(Integer libId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (libService.deleteLibById(libId, token)) {
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
