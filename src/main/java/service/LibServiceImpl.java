package service;

import com.github.pagehelper.PageHelper;
import entity.Lib;
import entity.LibExample;
import mapper.LibMapper;
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
public class LibServiceImpl implements LibService {

    @Resource
    private LibMapper libMapper;
    @Resource
    private Jedis jedis;

    @Override
    public boolean addLib(Lib lib, String token) {
        if (jedis.exists(token)) {
            lib.setCreateDate(new Date());
            lib.setStatus(0);
            libMapper.insert(lib);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Lib> getLibsByTeamIdByPage(Integer teamId, String token, Integer status, int page, int limit) {
        if (jedis.exists(token)) {
            LibExample libExample = new LibExample();
            libExample.setOrderByClause("createDate desc");
            libExample.createCriteria().andTeamIdEqualTo(teamId).andStatusEqualTo(status);
            PageHelper.startPage(page, limit);
            return libMapper.selectByExample(libExample);
        } else {
            return null;
        }
    }

    @Override
    public Lib getLibById(Integer libId, String token) {
        if (jedis.exists(token)) {
            return libMapper.selectByPrimaryKey(libId);
        } else {
            return null;
        }
    }

    @Override
    public boolean updateLib(Lib lib, String token) {
        if (jedis.exists(token)) {
            libMapper.updateByPrimaryKeySelective(lib);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteLibById(Integer libId, String token) {
        if (jedis.exists(token)) {
            libMapper.deleteByPrimaryKey(libId);
            return true;
        } else {
            return false;
        }
    }
}
