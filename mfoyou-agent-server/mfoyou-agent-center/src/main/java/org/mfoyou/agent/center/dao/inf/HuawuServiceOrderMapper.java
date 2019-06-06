package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrderExample;

public interface HuawuServiceOrderMapper {
    int countByExample(HuawuServiceOrderExample example);

    int deleteByExample(HuawuServiceOrderExample example);

    int deleteByPrimaryKey(Integer serviceOrderId);

    int insert(HuawuServiceOrder record);

    int insertSelective(HuawuServiceOrder record);

    List<HuawuServiceOrder> selectByExample(HuawuServiceOrderExample example);

    HuawuServiceOrder selectByPrimaryKey(Integer serviceOrderId);

    int updateByExampleSelective(@Param("record") HuawuServiceOrder record, @Param("example") HuawuServiceOrderExample example);

    int updateByExample(@Param("record") HuawuServiceOrder record, @Param("example") HuawuServiceOrderExample example);

    int updateByPrimaryKeySelective(HuawuServiceOrder record);

    int updateByPrimaryKey(HuawuServiceOrder record);
    
    int countAll(@Param("lon") Double lon,@Param("lat") Double lat, @Param("isAgent")Integer isagent,@Param("runerid")Integer runnerid);
}