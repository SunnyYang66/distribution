package org.mfoyou.agent.center.dao.mfoyou.inf;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreOpen;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreOpenExample;

public interface MfoyouStoreOpenMapper {
    int countByExample(MfoyouStoreOpenExample example);

    int deleteByExample(MfoyouStoreOpenExample example);

    int deleteByPrimaryKey(Integer openId);

    int insert(MfoyouStoreOpen record);

    int insertSelective(MfoyouStoreOpen record);

    List<MfoyouStoreOpen> selectByExample(MfoyouStoreOpenExample example);

    MfoyouStoreOpen selectByPrimaryKey(Integer openId);

    int updateByExampleSelective(@Param("record") MfoyouStoreOpen record, @Param("example") MfoyouStoreOpenExample example);

    int updateByExample(@Param("record") MfoyouStoreOpen record, @Param("example") MfoyouStoreOpenExample example);

    int updateByPrimaryKeySelective(MfoyouStoreOpen record);

    int updateByPrimaryKey(MfoyouStoreOpen record);
}