package service;

import com.github.pagehelper.PageHelper;
import entity.Work;
import entity.WorkExample;
import entity.WorkUserVo;
import mapper.WorkMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: Yupi Li
 * @Date: Created in 23:27 2018/5/14
 * @Description:
 * @Modified By:
 */
@Service
public class WorkServiceImpl implements WorkService {

    @Resource
    private WorkMapper workMapper;
    @Resource
    private Jedis jedis;

    @Override
    public boolean addWork(Work work, String token) {
        if (jedis.exists(token)) {
            work.setStatus(0);
            workMapper.insert(work);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<WorkUserVo> getWorksByTeamIdByPage(Integer teamId, String workerId, Integer status, String token, int page, int limit) {
        if (jedis.exists(token)) {
            WorkExample workExample = new WorkExample();
            WorkExample.Criteria criteria = workExample.createCriteria().andTeamIdEqualTo(teamId);
            if (workerId != null) {
                criteria.andWorkerIdEqualTo(workerId);
            }
            if (status == 0 || status == 2) {
                criteria.andStatusEqualTo(status);
            } else if (status == 1) {
                criteria.andStatusEqualTo(status).andEndDateGreaterThan(new Date());
            } else if (status == 3) {
                criteria.andStatusEqualTo(1).andEndDateLessThan(new Date());
            }
            PageHelper.startPage(page, limit);
            return workMapper.selectWorkUserByTeamId(workExample);
        } else {
            return null;
        }
    }


    @Override
    public boolean updateWork(Work work, String token) {
        if (jedis.exists(token)) {
            workMapper.updateByPrimaryKeySelective(work);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteWorkById(Integer workId, String token) {
        if (jedis.exists(token)) {
            workMapper.deleteByPrimaryKey(workId);
            return true;
        } else {
            return false;
        }
    }
}
