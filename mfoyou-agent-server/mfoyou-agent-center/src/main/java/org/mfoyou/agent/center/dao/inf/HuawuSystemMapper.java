package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface HuawuSystemMapper {
    Map<String, Object> select_item(String sql);

    List<Map<String, Object>> select_list(String sql);
    
    int update_item(String sql);
    
    List<Map<String, Object>> selectByExample(@Param("resultColumn") String resultColumn, @Param("tableName") String tableName, @Param("example") Object example);
    
    Integer selectCount();
    
    Integer getDayid();
}