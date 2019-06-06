package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuEvaluate;
import org.mfoyou.agent.common.dao.domain.HuawuEvaluateExample;

public interface HuawuEvaluateMapper {
    int countByExample(HuawuEvaluateExample example);

    int deleteByExample(HuawuEvaluateExample example);

    int deleteByPrimaryKey(Integer evaluateId);

    int insert(HuawuEvaluate record);

    int insertSelective(HuawuEvaluate record);

    List<HuawuEvaluate> selectByExample(HuawuEvaluateExample example);

    HuawuEvaluate selectByPrimaryKey(Integer evaluateId);

    int updateByExampleSelective(@Param("record") HuawuEvaluate record, @Param("example") HuawuEvaluateExample example);

    int updateByExample(@Param("record") HuawuEvaluate record, @Param("example") HuawuEvaluateExample example);

    int updateByPrimaryKeySelective(HuawuEvaluate record);

    int updateByPrimaryKey(HuawuEvaluate record);
}