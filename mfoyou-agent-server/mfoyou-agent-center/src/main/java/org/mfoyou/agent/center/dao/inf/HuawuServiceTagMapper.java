package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuServiceTag;
import org.mfoyou.agent.common.dao.domain.HuawuServiceTagExample;

public interface HuawuServiceTagMapper {
    int countByExample(HuawuServiceTagExample example);

    int deleteByExample(HuawuServiceTagExample example);

    int deleteByPrimaryKey(Integer serviceTagId);

    int insert(HuawuServiceTag record);

    int insertSelective(HuawuServiceTag record);

    List<HuawuServiceTag> selectByExample(HuawuServiceTagExample example);

    HuawuServiceTag selectByPrimaryKey(Integer serviceTagId);

    int updateByExampleSelective(@Param("record") HuawuServiceTag record, @Param("example") HuawuServiceTagExample example);

    int updateByExample(@Param("record") HuawuServiceTag record, @Param("example") HuawuServiceTagExample example);

    int updateByPrimaryKeySelective(HuawuServiceTag record);

    int updateByPrimaryKey(HuawuServiceTag record);
}