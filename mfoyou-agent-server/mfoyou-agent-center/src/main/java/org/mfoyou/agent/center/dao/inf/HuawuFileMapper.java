package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuFile;
import org.mfoyou.agent.common.dao.domain.HuawuFileExample;

public interface HuawuFileMapper {
    int countByExample(HuawuFileExample example);

    int deleteByExample(HuawuFileExample example);

    int deleteByPrimaryKey(Integer fileId);

    int insert(HuawuFile record);

    int insertSelective(HuawuFile record);

    List<HuawuFile> selectByExample(HuawuFileExample example);

    HuawuFile selectByPrimaryKey(Integer fileId);

    int updateByExampleSelective(@Param("record") HuawuFile record, @Param("example") HuawuFileExample example);

    int updateByExample(@Param("record") HuawuFile record, @Param("example") HuawuFileExample example);

    int updateByPrimaryKeySelective(HuawuFile record);

    int updateByPrimaryKey(HuawuFile record);
}