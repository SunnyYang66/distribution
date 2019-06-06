package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreType;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreTypeExample;
import org.mfoyou.agent.common.entity.StoreType;
import org.mfoyou.agent.common.entity.StoreTypeV1;


public interface MfoyouStoreTypeMapper {
    int countByExample(MfoyouStoreTypeExample example);

    int deleteByExample(MfoyouStoreTypeExample example);

    int deleteByPrimaryKey(Integer storeTypeId);

    int insert(MfoyouStoreType record);

    int insertSelective(MfoyouStoreType record);

    List<MfoyouStoreType> selectByExample(MfoyouStoreTypeExample example);

    MfoyouStoreType selectByPrimaryKey(Integer storeTypeId);

    int updateByExampleSelective(@Param("record") MfoyouStoreType record, @Param("example") MfoyouStoreTypeExample example);

    int updateByExample(@Param("record") MfoyouStoreType record, @Param("example") MfoyouStoreTypeExample example);

    int updateByPrimaryKeySelective(MfoyouStoreType record);

    int updateByPrimaryKey(MfoyouStoreType record);

	List<StoreType> getTypeList(@Param("type") Integer type);
	
	StoreTypeV1 getTypeByid(Integer storeTypeId );

}