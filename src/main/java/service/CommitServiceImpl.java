package service;

import com.github.pagehelper.PageHelper;
import entity.Commit;
import entity.CommitExample;
import mapper.CommitMapper;
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
public class CommitServiceImpl implements CommitService {

    @Resource
    private CommitMapper commitMapper;
    @Resource
    private Jedis jedis;

    @Override
    public boolean addCommit(Commit commit, String token) {
        if (jedis.exists(token)) {
            commit.setCommitTime(new Date());
            commitMapper.insert(commit);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Commit> getCommitsByPage(Commit commit, String token, int page, int limit) {
        if (jedis.exists(token)) {
            CommitExample commitExample = new CommitExample();
            commitExample.setOrderByClause("commitTime desc");
            CommitExample.Criteria criteria = commitExample.createCriteria();
            if (commit.getLibId() != null) {
                criteria.andLibIdEqualTo(commit.getLibId());
            }
            if (commit.getCommitterId() != null) {
                criteria.andCommitterIdEqualTo(commit.getCommitterId());
            }
            PageHelper.startPage(page,limit);
            return commitMapper.selectCommitsByExample(commitExample);
        } else {
            return null;
        }
    }

    @Override
    public Commit getCommitById(Integer commitId, String token) {
        if (jedis.exists(token)) {
            return commitMapper.selectByPrimaryKey(commitId);
        } else {
            return null;
        }
    }

    @Override
    public boolean updateCommit(Commit commit, String token) {
        if (jedis.exists(token)) {
            commitMapper.updateByPrimaryKeySelective(commit);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCommitById(Integer commitId, String token) {
        if (jedis.exists(token)) {
            commitMapper.deleteByPrimaryKey(commitId);
            return true;
        } else {
            return false;
        }
    }
}
