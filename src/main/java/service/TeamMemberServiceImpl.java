package service;

import com.github.pagehelper.PageHelper;
import entity.*;
import mapper.TeamMapper;
import mapper.TeamMemberMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: Yupi Li
 * @Date: Created in 19:52 2018/5/15
 * @Description:
 * @Modified By:
 */
@Service
public class TeamMemberServiceImpl implements TeamMemberService {
    @Resource
    private TeamMemberMapper teamMemberMapper;
    @Resource
    private TeamMapper teamMapper;
    @Resource
    private Jedis jedis;

    @Override
    public int addTeamMember(TeamMember teamMember, String creatorId, String token) {
        if (jedis.exists(token)) {
            if (jedis.hmget(token, "userId").get(0).equals(creatorId)) {
                teamMember.setInviteDate(new Date());
                teamMember.setStatus(0);
                teamMember.setPosition("成员");
                teamMemberMapper.insert(teamMember);
                return 0;
            } else {
                return 1;
            }
        } else {
            return 2;
        }
    }

    @Override
    public int deleteMember(TeamMemberKey teamMemberkey, String userId, String token) {
        if (jedis.exists(token)) {
            String creatorId = teamMapper.selectByPrimaryKey(teamMemberkey.getTeamId()).getCreatorId();
            if (jedis.hmget(token, "userId").get(0).equals(creatorId)) {
                teamMemberMapper.deleteByPrimaryKey(teamMemberkey);
                return 0;
            } else {
                return 1;
            }
        } else {
            return 2;
        }
    }

    @Override
    public int updateTeamMember(TeamMember teamMember, String userId, String token) {
        if (jedis.exists(token)) {
            String creatorId = teamMapper.selectByPrimaryKey(teamMember.getTeamId()).getCreatorId();
            if (jedis.hmget(token, "userId").get(0).equals(creatorId)) {
                teamMember.setJoinDate(new Date());
                teamMemberMapper.updateByPrimaryKeySelective(teamMember);
                return 0;
            } else {
                return 1;
            }
        } else {
            return 2;
        }
    }


    @Override
    public int userQuitTeam(TeamMemberKey teamMemberKey, String token) {
        if (jedis.exists(token)) {
            if (jedis.hmget(token, "userId").get(0).equals(teamMemberKey.getMemberId())) {
                teamMemberMapper.deleteByPrimaryKey(teamMemberKey);
                return 0;
            } else {
                return 1;
            }
        } else {
            return 2;
        }
    }

    @Override
    public int userDealInvitation(TeamMember teamMember, String token) {
        if (jedis.exists(token)) {
            if (jedis.hmget(token, "userId").get(0).equals(teamMember.getMemberId())) {
                teamMemberMapper.updateByPrimaryKeySelective(teamMember);
                return 0;
            } else {
                return 1;
            }
        } else {
            return 2;
        }
    }

    @Override
    public List<Team> getMemberTeamsByPage(TeamMember teamMember, String token, int page, int limit) {
        if (jedis.exists(token)) {
            TeamMemberExample teamMemberExample = new TeamMemberExample();
            teamMemberExample.setOrderByClause("joinDate desc");
            teamMemberExample.createCriteria()
                    .andStatusEqualTo(teamMember.getStatus())
                    .andMemberIdEqualTo(teamMember.getMemberId());
            PageHelper.startPage(page, limit);
            return teamMemberMapper.selectTeamsByExample(teamMemberExample);
        } else {
            return null;
        }
    }

    @Override
    public List<UserJoinVo> getTeamMembersByPage(TeamMember teamMember, String token, int page, int limit) {
        if (jedis.exists(token)) {
            TeamMemberExample teamMemberExample = new TeamMemberExample();
            teamMemberExample.setOrderByClause("joinDate desc");
            teamMemberExample.createCriteria()
                    .andStatusEqualTo(teamMember.getStatus())
                    .andTeamIdEqualTo(teamMember.getTeamId());
            PageHelper.startPage(page, limit);
            return teamMemberMapper.selectMembersByExample(teamMemberExample);
        } else {
            return null;
        }
    }

}
