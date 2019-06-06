package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuPay;
import org.mfoyou.agent.common.dao.domain.HuawuPayExample;

public interface HuawuPayMapper {
    int countByExample(HuawuPayExample example);

    int deleteByExample(HuawuPayExample example);

    int deleteByPrimaryKey(Integer payId);

    int insert(HuawuPay record);

    int insertSelective(HuawuPay record);

    List<HuawuPay> selectByExample(HuawuPayExample example);

    HuawuPay selectByPrimaryKey(Integer payId);

    int updateByExampleSelective(@Param("record") HuawuPay record, @Param("example") HuawuPayExample example);

    int updateByExample(@Param("record") HuawuPay record, @Param("example") HuawuPayExample example);

    int updateByPrimaryKeySelective(HuawuPay record);

    int updateByPrimaryKey(HuawuPay record);
}