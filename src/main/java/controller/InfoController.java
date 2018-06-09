package controller;

import com.github.pagehelper.Page;
import entity.Info;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.InfoService;

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
public class InfoController {

    @Resource
    private InfoService infoService;

    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> addInfo(Info info, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (infoService.addInfo(info, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/info/get/team")
    @ResponseBody
    public Map<String, Object> getTeamInfoByStatusByPage(Integer teamId, Integer status, String token, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Info> infoList = infoService.getInfosByTeamIdByStatusByPage(teamId, status, token, page, limit);
            if (infoList != null) {
                long total = ((Page) infoList).getTotal();
                map.put("total", total);
                if (infoList.size() > 0) {
                    map.put("infoList", infoList);
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

    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateInfo(Info info, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (infoService.updateInfo(info, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/info/delete")
    @ResponseBody
    public Map<String, Object> deleteInfo(Integer infoId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (infoService.deleteInfoById(infoId, token)) {
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
