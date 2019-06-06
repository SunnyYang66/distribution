package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.MfoyouThirdPartAudit;
import org.mfoyou.agent.common.dao.domain.MfoyouThirdPartAuditExample;

public interface MfoyouThirdPartAuditMapper {
    int countByExample(MfoyouThirdPartAuditExample example);

    int deleteByExample(MfoyouThirdPartAuditExample example);

    int deleteByPrimaryKey(String appid);

    int insert(MfoyouThirdPartAudit record);

    int insertSelective(MfoyouThirdPartAudit record);

    List<MfoyouThirdPartAudit> selectByExample(MfoyouThirdPartAuditExample example);

    MfoyouThirdPartAudit selectByPrimaryKey(String appid);

    int updateByExampleSelective(@Param("record") MfoyouThirdPartAudit record, @Param("example") MfoyouThirdPartAuditExample example);

    int updateByExample(@Param("record") MfoyouThirdPartAudit record, @Param("example") MfoyouThirdPartAuditExample example);

    int updateByPrimaryKeySelective(MfoyouThirdPartAudit record);

    int updateByPrimaryKey(MfoyouThirdPartAudit record);
}