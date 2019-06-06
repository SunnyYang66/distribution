package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCouponExample;

public interface MfoyouAgentStoreCouponMapper {
    int countByExample(MfoyouAgentStoreCouponExample example);

    int deleteByExample(MfoyouAgentStoreCouponExample example);

    int deleteByPrimaryKey(Integer couponId);

    int insert(MfoyouAgentStoreCoupon record);

    int insertSelective(MfoyouAgentStoreCoupon record);

    List<MfoyouAgentStoreCoupon> selectByExample(MfoyouAgentStoreCouponExample example);

    MfoyouAgentStoreCoupon selectByPrimaryKey(Integer couponId);

    int updateByExampleSelective(@Param("record") MfoyouAgentStoreCoupon record, @Param("example") MfoyouAgentStoreCouponExample example);

    int updateByExample(@Param("record") MfoyouAgentStoreCoupon record, @Param("example") MfoyouAgentStoreCouponExample example);

    int updateByPrimaryKeySelective(MfoyouAgentStoreCoupon record);

    int updateByPrimaryKey(MfoyouAgentStoreCoupon record);
    
    int checkCouponCount(@Param("couponId")Integer couponId, @Param("count")Integer count);

	List<MfoyouAgentStoreCoupon> selectByUserExample(@Param("userId")Integer userId, @Param("state")Integer state, @Param("type")Integer type);

	List<MfoyouAgentStoreCoupon> getUserCanUseAmount(@Param("userId")Integer userId, @Param("agentId")Integer agentId, @Param("amount")Integer amount);
}