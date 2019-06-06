package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuEvaluateTag;
import org.mfoyou.agent.common.dao.domain.HuawuEvaluateTagExample;

public interface HuawuEvaluateTagMapper {
    int countByExample(HuawuEvaluateTagExample example);

    int deleteByExample(HuawuEvaluateTagExample example);

    int deleteByPrimaryKey(Integer evaluateTagId);

    int insert(HuawuEvaluateTag record);

    int insertSelective(HuawuEvaluateTag record);

    List<HuawuEvaluateTag> selectByExample(HuawuEvaluateTagExample example);

    HuawuEvaluateTag selectByPrimaryKey(Integer evaluateTagId);

    int updateByExampleSelective(@Param("record") HuawuEvaluateTag record, @Param("example") HuawuEvaluateTagExample example);

    int updateByExample(@Param("record") HuawuEvaluateTag record, @Param("example") HuawuEvaluateTagExample example);

    int updateByPrimaryKeySelective(HuawuEvaluateTag record);

    int updateByPrimaryKey(HuawuEvaluateTag record);
}