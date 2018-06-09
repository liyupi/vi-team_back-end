package mapper;

import entity.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TeamMemberMapper {
    long countByExample(TeamMemberExample example);

    int deleteByExample(TeamMemberExample example);

    int deleteByPrimaryKey(TeamMemberKey key);

    int insert(TeamMember record);

    int insertSelective(TeamMember record);

    List<TeamMember> selectByExampleWithRowbounds(TeamMemberExample example, RowBounds rowBounds);

    List<TeamMember> selectByExample(TeamMemberExample example);

    TeamMember selectByPrimaryKey(TeamMemberKey key);

    int updateByExampleSelective(@Param("record") TeamMember record, @Param("example") TeamMemberExample example);

    int updateByExample(@Param("record") TeamMember record, @Param("example") TeamMemberExample example);

    int updateByPrimaryKeySelective(TeamMember record);

    int updateByPrimaryKey(TeamMember record);

    List<Team> selectTeamsByExampleWithRowbounds(TeamMemberExample example, RowBounds rowBounds);

    List<Team> selectTeamsByExample(TeamMemberExample teamMemberExample);

    List<UserJoinVo> selectMembersByExampleWithRowbounds(TeamMemberExample example, RowBounds rowBounds);

    List<UserJoinVo> selectMembersByExample(TeamMemberExample example);
}