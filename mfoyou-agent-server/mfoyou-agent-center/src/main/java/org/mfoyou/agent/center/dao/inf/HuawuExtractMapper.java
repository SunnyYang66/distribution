package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuExtract;
import org.mfoyou.agent.common.dao.domain.HuawuExtractExample;

public interface HuawuExtractMapper {
    int countByExample(HuawuExtractExample example);

    int deleteByExample(HuawuExtractExample example);

    int deleteByPrimaryKey(Integer extractId);

    int insert(HuawuExtract record);

    int insertSelective(HuawuExtract record);

    List<HuawuExtract> selectByExampleWithBLOBs(HuawuExtractExample example);

    List<HuawuExtract> selectByExample(HuawuExtractExample example);

    HuawuExtract selectByPrimaryKey(Integer extractId);

    int updateByExampleSelective(@Param("record") HuawuExtract record, @Param("example") HuawuExtractExample example);

    int updateByExampleWithBLOBs(@Param("record") HuawuExtract record, @Param("example") HuawuExtractExample example);

    int updateByExample(@Param("record") HuawuExtract record, @Param("example") HuawuExtractExample example);

    int updateByPrimaryKeySelective(HuawuExtract record);

    int updateByPrimaryKeyWithBLOBs(HuawuExtract record);

    int updateByPrimaryKey(HuawuExtract record);
}