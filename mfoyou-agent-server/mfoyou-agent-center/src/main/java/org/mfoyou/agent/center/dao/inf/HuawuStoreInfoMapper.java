package org.mfoyou.agent.center.dao.inf;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfoExample;
import org.mfoyou.agent.common.entity.MfoyouAgentStoreInfo;


public interface HuawuStoreInfoMapper {
    int countByExample(HuawuStoreInfoExample example);

    int deleteByExample(HuawuStoreInfoExample example);

    int deleteByPrimaryKey(Integer storeId);

    int insert(HuawuStoreInfo record);

    int insertSelective(HuawuStoreInfo record);

    List<HuawuStoreInfo> selectByExample(HuawuStoreInfoExample example);
    
    List<HuawuStoreInfo> selectByExampleV2(HuawuStoreInfoExample example);
    
    HuawuStoreInfo selectByPrimaryKey(Integer storeId);

    int updateByExampleSelective(@Param("record") HuawuStoreInfo record, @Param("example") HuawuStoreInfoExample example);

    int updateByExample(@Param("record") HuawuStoreInfo record, @Param("example") HuawuStoreInfoExample example);

    int updateByPrimaryKeySelective(HuawuStoreInfo record);

    int updateByPrimaryKey(HuawuStoreInfo record);
    
    List<MfoyouAgentStoreInfo> getStoreInfoByAgent(@Param("storeInfo") HuawuStoreInfo storeInfo,
    	    @Param("sdate")Date sdate, @Param("edate")Date edate,@Param("pageStart")Integer pageStart,@Param("pagesize")Integer pagesize);

    MfoyouAgentStoreInfo getInfoByAgent(@Param("storePhone")String storePhone, @Param("agentId")Integer agentId);

    List<MfoyouAgentStoreInfo> getAdminStore(@Param("example")HuawuStoreInfo example);
}