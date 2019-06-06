package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuAddress;
import org.mfoyou.agent.common.dao.domain.HuawuAddressExample;

public interface HuawuAddressMapper {
    int countByExample(HuawuAddressExample example);

    int deleteByExample(HuawuAddressExample example);

    int deleteByPrimaryKey(Integer addressId);

    int insert(HuawuAddress record);

    int insertSelective(HuawuAddress record);

    List<HuawuAddress> selectByExample(HuawuAddressExample example);

    HuawuAddress selectByPrimaryKey(Integer addressId);

    int updateByExampleSelective(@Param("record") HuawuAddress record, @Param("example") HuawuAddressExample example);

    int updateByExample(@Param("record") HuawuAddress record, @Param("example") HuawuAddressExample example);

    int updateByPrimaryKeySelective(HuawuAddress record);

    int updateByPrimaryKey(HuawuAddress record);
}