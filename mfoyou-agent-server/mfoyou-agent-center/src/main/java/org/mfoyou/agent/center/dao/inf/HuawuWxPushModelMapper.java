package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuWxPushModel;
import org.mfoyou.agent.common.dao.domain.HuawuWxPushModelExample;

public interface HuawuWxPushModelMapper {
    int countByExample(HuawuWxPushModelExample example);

    int deleteByExample(HuawuWxPushModelExample example);

    int insert(HuawuWxPushModel record);

    int insertSelective(HuawuWxPushModel record);

    List<HuawuWxPushModel> selectByExample(HuawuWxPushModelExample example);

    int updateByExampleSelective(@Param("record") HuawuWxPushModel record, @Param("example") HuawuWxPushModelExample example);

    int updateByExample(@Param("record") HuawuWxPushModel record, @Param("example") HuawuWxPushModelExample example);
}