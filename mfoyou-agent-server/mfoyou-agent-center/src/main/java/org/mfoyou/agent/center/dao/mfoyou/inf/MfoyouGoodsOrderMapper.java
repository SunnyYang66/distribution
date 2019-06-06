package org.mfoyou.agent.center.dao.mfoyou.inf;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderExample;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderWithPackage;

public interface MfoyouGoodsOrderMapper {
    int countByExample(MfoyouGoodsOrderExample example);

    int deleteByExample(MfoyouGoodsOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(MfoyouGoodsOrder record);

    int insertSelective(MfoyouGoodsOrder record);

    List<MfoyouGoodsOrder> selectByExample(MfoyouGoodsOrderExample example);

    MfoyouGoodsOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") MfoyouGoodsOrder record, @Param("example") MfoyouGoodsOrderExample example);

    int updateByExample(@Param("record") MfoyouGoodsOrder record, @Param("example") MfoyouGoodsOrderExample example);

    int updateByPrimaryKeySelective(MfoyouGoodsOrder record);

    int updateByPrimaryKey(MfoyouGoodsOrder record);
    
    List<MfoyouGoodsOrderWithPackage> selectByExampleWithPacket(MfoyouGoodsOrderExample example);

	MfoyouGoodsOrderWithPackage getGoodsOrderWith(@Param("orderid") Integer orderId);
	
	int selectsum(@Param("storeid")Integer storeid);
	
	List<MfoyouGoodsOrder> selectByDaysId(@Param("storeid")Integer storeid,@Param("dayid")String dayid);

	Integer countAll(@Param("storeid")Integer storeid, @Param("flag")Integer flag);

	int selectException(@Param("exceptionType")Integer exception);

	List<MfoyouGoodsOrderWithPackage> selectByExampleWithPacketV1(@Param("storeid")Integer storeId,
			@Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize);
}