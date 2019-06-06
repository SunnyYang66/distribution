package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentUserCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentUserCouponExample;

public interface MfoyouAgentUserCouponMapper {
    int countByExample(MfoyouAgentUserCouponExample example);

    int deleteByExample(MfoyouAgentUserCouponExample example);

    int deleteByPrimaryKey(Integer touchId);

    int insert(MfoyouAgentUserCoupon record);

    int insertSelective(MfoyouAgentUserCoupon record);

    List<MfoyouAgentUserCoupon> selectByExample(MfoyouAgentUserCouponExample example);

    MfoyouAgentUserCoupon selectByPrimaryKey(Integer touchId);

    int updateByExampleSelective(@Param("record") MfoyouAgentUserCoupon record, @Param("example") MfoyouAgentUserCouponExample example);

    int updateByExample(@Param("record") MfoyouAgentUserCoupon record, @Param("example") MfoyouAgentUserCouponExample example);

    int updateByPrimaryKeySelective(MfoyouAgentUserCoupon record);

    int updateByPrimaryKey(MfoyouAgentUserCoupon record);
}