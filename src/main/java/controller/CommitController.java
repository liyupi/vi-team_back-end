package controller;

import com.github.pagehelper.Page;
import entity.Commit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommitService;

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
public class CommitController {

    @Resource
    private CommitService commitService;

    @RequestMapping("/commit/add")
    @ResponseBody
    public Map<String, Object> addCommit(Commit commit, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (commitService.addCommit(commit, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/commit/get")
    @ResponseBody
    public Map<String, Object> getLibCommitByPage(Commit commit, String token, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Commit> commitList = commitService.getCommitsByPage(commit, token, page, limit);
            if (commitList != null) {
                long total = ((Page) commitList).getTotal();
                map.put("total", total);
                if (commitList.size() > 0) {
                    map.put("commitList", commitList);
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

    @RequestMapping("/commit/get/id")
    @ResponseBody
    public Map<String, Object> getCommitById(Integer commitId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            Commit commit = commitService.getCommitById(commitId, token);
            if (commit != null) {
                map.put("commit", commit);
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/commit/update")
    @ResponseBody
    public Map<String, Object> updateCommit(Commit commit, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (commitService.updateCommit(commit, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/commit/delete")
    @ResponseBody
    public Map<String, Object> deleteCommit(Integer commitId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (commitService.deleteCommitById(commitId, token)) {
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
