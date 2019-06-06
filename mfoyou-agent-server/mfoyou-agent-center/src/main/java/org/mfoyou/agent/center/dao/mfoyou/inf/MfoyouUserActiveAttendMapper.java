package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserActiveAttend;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserActiveAttendExample;

public interface MfoyouUserActiveAttendMapper {
    int countByExample(MfoyouUserActiveAttendExample example);

    int deleteByExample(MfoyouUserActiveAttendExample example);

    int insert(MfoyouUserActiveAttend record);

    int insertSelective(MfoyouUserActiveAttend record);

    List<MfoyouUserActiveAttend> selectByExample(MfoyouUserActiveAttendExample example);

    int updateByExampleSelective(@Param("record") MfoyouUserActiveAttend record, @Param("example") MfoyouUserActiveAttendExample example);

    int updateByExample(@Param("record") MfoyouUserActiveAttend record, @Param("example") MfoyouUserActiveAttendExample example);
}