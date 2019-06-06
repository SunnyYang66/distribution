package org.mfoyou.agent.center.dao.mfoyou.inf;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreFreight;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreFreightExample;

public interface MfoyouStoreFreightMapper {
    int countByExample(MfoyouStoreFreightExample example);

    int deleteByExample(MfoyouStoreFreightExample example);

    int deleteByPrimaryKey(Integer freightId);

    int insert(MfoyouStoreFreight record);

    int insertSelective(MfoyouStoreFreight record);

    List<MfoyouStoreFreight> selectByExample(MfoyouStoreFreightExample example);

    MfoyouStoreFreight selectByPrimaryKey(Integer freightId);

    int updateByExampleSelective(@Param("record") MfoyouStoreFreight record, @Param("example") MfoyouStoreFreightExample example);

    int updateByExample(@Param("record") MfoyouStoreFreight record, @Param("example") MfoyouStoreFreightExample example);

    int updateByPrimaryKeySelective(MfoyouStoreFreight record);

    int updateByPrimaryKey(MfoyouStoreFreight record);
}