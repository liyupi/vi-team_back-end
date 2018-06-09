package mapper;

import entity.Team;
import entity.TeamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TeamMapper {
    long countByExample(TeamExample example);

    int deleteByExample(TeamExample example);

    int deleteByPrimaryKey(Integer teamId);

    int insert(Team record);

    int insertSelective(Team record);

    List<Team> selectByExampleWithRowbounds(TeamExample example, RowBounds rowBounds);

    List<Team> selectByExample(TeamExample example);

    Team selectByPrimaryKey(Integer teamId);

    int updateByExampleSelective(@Param("record") Team record, @Param("example") TeamExample example);

    int updateByExample(@Param("record") Team record, @Param("example") TeamExample example);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);

    List<Team> getAllCreateTeam(String userId);

}