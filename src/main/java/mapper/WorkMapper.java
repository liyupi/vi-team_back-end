package mapper;

import entity.Work;
import entity.WorkExample;
import java.util.List;

import entity.WorkUserVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(Integer workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExampleWithRowbounds(WorkExample example, RowBounds rowBounds);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(Integer workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<WorkUserVo> selectWorkUserByTeamId(WorkExample example);

}