package mapper;

import entity.Commit;
import entity.CommitExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CommitMapper {
    long countByExample(CommitExample example);

    int deleteByExample(CommitExample example);

    int deleteByPrimaryKey(Integer commitId);

    int insert(Commit record);

    int insertSelective(Commit record);

    List<Commit> selectByExampleWithBLOBsWithRowbounds(CommitExample example, RowBounds rowBounds);

    List<Commit> selectByExampleWithBLOBs(CommitExample example);

    List<Commit> selectByExampleWithRowbounds(CommitExample example, RowBounds rowBounds);

    List<Commit> selectByExample(CommitExample example);

    List<Commit> selectCommitsByExample(CommitExample example);

    Commit selectByPrimaryKey(Integer commitId);

    int updateByExampleSelective(@Param("record") Commit record, @Param("example") CommitExample example);

    int updateByExampleWithBLOBs(@Param("record") Commit record, @Param("example") CommitExample example);

    int updateByExample(@Param("record") Commit record, @Param("example") CommitExample example);

    int updateByPrimaryKeySelective(Commit record);

    int updateByPrimaryKeyWithBLOBs(Commit record);

    int updateByPrimaryKey(Commit record);
}