package org.mfoyou.agent.center.dao.inf;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuWalletLog;
import org.mfoyou.agent.common.dao.domain.HuawuWalletLogExample;

public interface HuawuWalletLogMapper {
    int countByExample(HuawuWalletLogExample example);

    int deleteByExample(HuawuWalletLogExample example);

    int deleteByPrimaryKey(Integer walletLogId);

    int insert(HuawuWalletLog record);

    int insertSelective(HuawuWalletLog record);

    List<HuawuWalletLog> selectByExample(HuawuWalletLogExample example);

    HuawuWalletLog selectByPrimaryKey(Integer walletLogId);

    int updateByExampleSelective(@Param("record") HuawuWalletLog record, @Param("example") HuawuWalletLogExample example);

    int updateByExample(@Param("record") HuawuWalletLog record, @Param("example") HuawuWalletLogExample example);

    int updateByPrimaryKeySelective(HuawuWalletLog record);

    int updateByPrimaryKey(HuawuWalletLog record);
    
    List<HuawuWalletLog> selectAgentByExample(@Param("agentid")Integer agentid,@Param("userType") int userType, @Param("sdate")Date sdate,@Param("edate")Date edate,
			@Param("limitStart")Integer limitStart,@Param("limitEnd")Integer limitEnd);
}