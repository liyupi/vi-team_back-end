package mapper;

import entity.Lib;
import entity.LibExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LibMapper {
    long countByExample(LibExample example);

    int deleteByExample(LibExample example);

    int deleteByPrimaryKey(Integer libId);

    int insert(Lib record);

    int insertSelective(Lib record);

    List<Lib> selectByExampleWithRowbounds(LibExample example, RowBounds rowBounds);

    List<Lib> selectByExample(LibExample example);

    Lib selectByPrimaryKey(Integer libId);

    int updateByExampleSelective(@Param("record") Lib record, @Param("example") LibExample example);

    int updateByExample(@Param("record") Lib record, @Param("example") LibExample example);

    int updateByPrimaryKeySelective(Lib record);

    int updateByPrimaryKey(Lib record);
}