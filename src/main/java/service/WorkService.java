package service;

import entity.Work;
import entity.WorkUserVo;

import java.util.List;

/**
 * @Author: Yupi Li
 * @Date: Created in 23:21 2018/5/14
 * @Description:
 * @Modified By:
 */

public interface WorkService {

    boolean addWork(Work work, String token);

    List<WorkUserVo> getWorksByTeamIdByPage(Integer teamId, String workerId, Integer status, String token, int page, int limit);

    boolean updateWork(Work work, String token);

    boolean deleteWorkById(Integer workId, String token);
}
