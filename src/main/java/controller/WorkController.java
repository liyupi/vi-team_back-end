package controller;

import com.github.pagehelper.Page;
import entity.Work;
import entity.WorkUserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.WorkService;

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
public class WorkController {

    @Resource
    private WorkService workService;

    @RequestMapping("/work/add")
    @ResponseBody
    public Map<String, Object> addWork(Work work, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (workService.addWork(work, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/work/get/team")
    @ResponseBody
    public Map<String, Object> getTeamWorkByPage(Integer teamId, String workerId, Integer status, String token, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<WorkUserVo> workList = workService.getWorksByTeamIdByPage(teamId, workerId, status, token, page, limit);
            if (workList != null) {
                long total = ((Page) workList).getTotal();
                map.put("total", total);
                if (workList.size() > 0) {
                    map.put("workList", workList);
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

    @RequestMapping("/work/update")
    @ResponseBody
    public Map<String, Object> updateWork(Work work, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (workService.updateWork(work, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/work/delete")
    @ResponseBody
    public Map<String, Object> deleteWork(Integer workId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (workService.deleteWorkById(workId, token)) {
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
