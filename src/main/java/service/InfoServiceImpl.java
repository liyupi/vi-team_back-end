package service;

import com.github.pagehelper.PageHelper;
import entity.Info;
import entity.InfoExample;
import mapper.InfoMapper;
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
public class InfoServiceImpl implements InfoService {

    @Resource
    private InfoMapper infoMapper;
    @Resource
    private Jedis jedis;

    @Override
    public boolean addInfo(Info info, String token) {
        if (jedis.exists(token)) {
            info.setPublishTime(new Date());
            info.setStatus(0);
            infoMapper.insert(info);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Info> getInfosByTeamIdByStatusByPage(Integer teamId, Integer status, String token, int page, int limit) {
        if (jedis.exists(token)) {
            InfoExample infoExample = new InfoExample();
            InfoExample.Criteria criteria = infoExample.createCriteria().andTeamIdEqualTo(teamId);
            if (status == 0) {
                criteria.andStatusEqualTo(0).andExpireTimeGreaterThan(new Date());
            } else if (status == 1) {
                criteria.andStatusEqualTo(1).andExpireTimeGreaterThan(new Date());
                infoExample.setOrderByClause("publishTime desc");
            } else if (status == 3) {
                criteria.andExpireTimeLessThan(new Date());
            }
            PageHelper.startPage(page,limit);
            return infoMapper.selectByExample(infoExample);
        } else {
            return null;
        }
    }

    @Override
    public boolean updateInfo(Info info, String token) {
        if (jedis.exists(token)) {
            infoMapper.updateByPrimaryKeySelective(info);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteInfoById(Integer infoId, String token) {
        if (jedis.exists(token)) {
            infoMapper.deleteByPrimaryKey(infoId);
            return true;
        } else {
            return false;
        }
    }
}
