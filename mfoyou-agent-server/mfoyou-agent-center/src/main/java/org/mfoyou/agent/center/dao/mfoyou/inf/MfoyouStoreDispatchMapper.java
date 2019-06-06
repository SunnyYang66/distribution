package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreDispatch;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreDispatchExample;

public interface MfoyouStoreDispatchMapper {
    int countByExample(MfoyouStoreDispatchExample example);

    int deleteByExample(MfoyouStoreDispatchExample example);

    int deleteByPrimaryKey(Integer storeId);

    int insert(MfoyouStoreDispatch record);

    int insertSelective(MfoyouStoreDispatch record);

    List<MfoyouStoreDispatch> selectByExample(MfoyouStoreDispatchExample example);

    MfoyouStoreDispatch selectByPrimaryKey(Integer storeId);

    int updateByExampleSelective(@Param("record") MfoyouStoreDispatch record, @Param("example") MfoyouStoreDispatchExample example);

    int updateByExample(@Param("record") MfoyouStoreDispatch record, @Param("example") MfoyouStoreDispatchExample example);

    int updateByPrimaryKeySelective(MfoyouStoreDispatch record);

    int updateByPrimaryKey(MfoyouStoreDispatch record);
}