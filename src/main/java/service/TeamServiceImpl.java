package service;

import com.github.pagehelper.PageHelper;
import entity.Team;
import entity.TeamExample;
import mapper.TeamMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author: Yupi Li
 * @Date: Created in 13:58 2018/5/13
 * @Description:
 * @Modified By:
 */
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamMapper teamMapper;
    @Resource
    private Jedis jedis;

    @Override
    public boolean createTeam(Team team, String token) {
        if (jedis.exists(token) && jedis.hmget(token, "userId").get(0).equals(team.getCreatorId())) {
            team.setCreateDate(new Date());
            teamMapper.insert(team);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Team> getCreateTeamByPage(String userId, String token, int page, int limit) {
        if (jedis.exists(token)) {
            TeamExample teamExample = new TeamExample();
            teamExample.setOrderByClause("createDate desc");
            teamExample.createCriteria().andCreatorIdEqualTo(userId);
            PageHelper.startPage(page, limit);
            return teamMapper.selectByExample(teamExample);
        } else {
            return null;
        }
    }

    @Override
    public int updateTeam(Team team, String token) {
        if (jedis.exists(token)) {
            if (jedis.hmget(token, "userId").get(0).equals(team.getCreatorId())) {
                teamMapper.updateByPrimaryKeySelective(team);
                return 0;
            } else {
                return 1;
            }
        } else {
            return 2;
        }
    }

    @Override
    public String uploadTeamPic(HttpServletRequest request, CommonsMultipartFile file, String token) throws IOException {
        if (jedis.exists(token)) {
            String path = "E:\\server\\Apache24\\htdocs\\teamPic\\" + file.getOriginalFilename();
            File newFile = new File(path);
            file.transferTo(newFile);
            String src = "http://localhost:5927/teamPic/" + file.getOriginalFilename();
            return src;
        } else {
            return null;
        }
    }

    @Override
    public List<Team> getCreateTeamAll(String userId, String token) {
        if (jedis.exists(token)) {
            return teamMapper.getAllCreateTeam(userId);
        } else {
            return null;
        }
    }
}
