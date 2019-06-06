package org.mfoyou.agent.center.dao.mfoyou.inf;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreActive;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreActiveExample;

public interface MfoyouStoreActiveMapper {
    int countByExample(MfoyouStoreActiveExample example);

    int deleteByExample(MfoyouStoreActiveExample example);

    int deleteByPrimaryKey(Integer storeId);

    int insert(MfoyouStoreActive record);

    int insertSelective(MfoyouStoreActive record);

    List<MfoyouStoreActive> selectByExample(MfoyouStoreActiveExample example);

    MfoyouStoreActive selectByPrimaryKey(Integer storeId);

    int updateByExampleSelective(@Param("record") MfoyouStoreActive record, @Param("example") MfoyouStoreActiveExample example);

    int updateByExample(@Param("record") MfoyouStoreActive record, @Param("example") MfoyouStoreActiveExample example);

    int updateByPrimaryKeySelective(MfoyouStoreActive record);

    int updateByPrimaryKey(MfoyouStoreActive record);
}