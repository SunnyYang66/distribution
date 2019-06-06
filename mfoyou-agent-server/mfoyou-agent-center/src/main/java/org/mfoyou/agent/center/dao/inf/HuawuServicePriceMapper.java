package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuServicePrice;
import org.mfoyou.agent.common.dao.domain.HuawuServicePriceExample;

public interface HuawuServicePriceMapper {
    int countByExample(HuawuServicePriceExample example);

    int deleteByExample(HuawuServicePriceExample example);

    int deleteByPrimaryKey(Integer agentId);

    int insert(HuawuServicePrice record);

    int insertSelective(HuawuServicePrice record);

    List<HuawuServicePrice> selectByExample(HuawuServicePriceExample example);

    HuawuServicePrice selectByPrimaryKey(Integer agentId);

    int updateByExampleSelective(@Param("record") HuawuServicePrice record, @Param("example") HuawuServicePriceExample example);

    int updateByExample(@Param("record") HuawuServicePrice record, @Param("example") HuawuServicePriceExample example);

    int updateByPrimaryKeySelective(HuawuServicePrice record);

    int updateByPrimaryKey(HuawuServicePrice record);
}