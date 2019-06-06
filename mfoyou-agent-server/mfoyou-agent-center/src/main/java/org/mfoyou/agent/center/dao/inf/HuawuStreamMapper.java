package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuStream;
import org.mfoyou.agent.common.dao.domain.HuawuStreamExample;

public interface HuawuStreamMapper {
    int countByExample(HuawuStreamExample example);

    int deleteByExample(HuawuStreamExample example);

    int deleteByPrimaryKey(Integer streamId);

    int insert(HuawuStream record);

    int insertSelective(HuawuStream record);

    List<HuawuStream> selectByExample(HuawuStreamExample example);

    HuawuStream selectByPrimaryKey(Integer streamId);

    int updateByExampleSelective(@Param("record") HuawuStream record, @Param("example") HuawuStreamExample example);

    int updateByExample(@Param("record") HuawuStream record, @Param("example") HuawuStreamExample example);

    int updateByPrimaryKeySelective(HuawuStream record);

    int updateByPrimaryKey(HuawuStream record);
}