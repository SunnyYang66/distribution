package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuAlipay;
import org.mfoyou.agent.common.dao.domain.HuawuAlipayExample;

public interface HuawuAlipayMapper {
    int countByExample(HuawuAlipayExample example);

    int deleteByExample(HuawuAlipayExample example);

    int deleteByPrimaryKey(Integer agentId);

    int insert(HuawuAlipay record);

    int insertSelective(HuawuAlipay record);

    List<HuawuAlipay> selectByExample(HuawuAlipayExample example);

    HuawuAlipay selectByPrimaryKey(Integer agentId);

    int updateByExampleSelective(@Param("record") HuawuAlipay record, @Param("example") HuawuAlipayExample example);

    int updateByExample(@Param("record") HuawuAlipay record, @Param("example") HuawuAlipayExample example);

    int updateByPrimaryKeySelective(HuawuAlipay record);

    int updateByPrimaryKey(HuawuAlipay record);
}