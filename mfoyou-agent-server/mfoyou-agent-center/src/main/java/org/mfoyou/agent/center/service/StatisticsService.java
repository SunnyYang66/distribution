package org.mfoyou.agent.center.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.center.dao.inf.HuawuStoreInfoMapper;
import org.mfoyou.agent.center.dao.inf.HuawuSystemMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsInfoMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouSystemMapper;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfoExample;
import org.mfoyou.agent.common.entity.GoodsInfo;
import org.mfoyou.agent.common.entity.MfoyouOrderStatic;
import org.mfoyou.agent.common.inf.IStatistics;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.sql.MybatisGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService implements IStatistics {
	@Autowired
	HuawuSystemMapper huawuSystemMapper;
	@Autowired
	MfoyouSystemMapper mfoyouSystemMapper;
	@Autowired
	HuawuStoreInfoMapper huawuStoreInfoMapper;
	@Autowired
	MfoyouGoodsInfoMapper mfoyouGoodsInfoMapper;

	@Override
	public String getPriceInfo(int agentId, int type) {
		String kind = null;
		switch (type) {
		case 1:
			kind = "service_take";
			break;
		case 2:
			kind = "service_give";
			break;
		case 3:
			kind = "service_buy";
			break;
		case 4:
			kind = "service_do";
			break;
		default:
			return null;
		}
		String sql = "SELECT " + kind + " priceInfo FROM huawu_service_price where agent_id = " + agentId;
		Map<String, Object> select_item = huawuSystemMapper.select_item(sql);
		if (select_item != null && select_item.get("priceInfo") != null) {
			return (String) select_item.get("priceInfo");
		}
		return null;
	}

	@Override
	public Map<String, Object> getRunerNoSettlement(Integer runerId) {
		String sql = "SELECT COUNT(*) as orderCount , sum(service_order_pay_amount - service_agent_amount-service_admin_amount) as amount FROM huawu_service_order where service_order_state >= 60 and service_order_state <= 600 and service_order_receive_user = "
				+ runerId;
		return huawuSystemMapper.select_item(sql);
	}

	@Override
	public Map<String, Object> getAgentNoSettlement(Integer agentId) {
		String sql = "SELECT COUNT(*) as orderCount , sum(service_agent_amount) as amount FROM `huawu_service_order` where service_order_state >= 60 and service_order_state <= 600 and agent_id = "
				+ agentId;
		return huawuSystemMapper.select_item(sql);
	}

	@Override
	public Map<String, Object> getOrderCountAll(Integer userId, int userType) {
		String sql = "select sum(case when service_order_state = 50 then 1 else 0 end )  waitingOrder,"
				+ "sum(case when service_order_state  in (50,60,70,80,90)  then 1 else 0 end )  goOrder,"
				+ "sum(case when service_order_state  in (500,600,610) and to_days(service_order_effect_time)  = to_days(now())"
				+ "then 1 else 0 end )  complet,"
				+ "sum(case when service_order_state = 700 and to_days(service_order_effect_time)  = to_days(now())"
				+ "then 1 else 0  end ) revokeOrder,"
				+ "sum(case when service_order_state =  1 then 1 else 0  end ) waitingPayOrder,"
				+ "sum(case when service_order_effect_time <  date_add(now(), interval -30 minute) "
				+ "and service_order_state between 60  and  90   then 1 else 0  end )  seviceException,"
				+ "sum(case when service_order_effect_time <  date_add(now(), interval -3 minute) "
				+ "and service_order_state between 40  and  50   then 1 else 0  end ) accept_exception "
				+ "from huawu_service_order where ";
		sql += userType == 0 ? "agent_id =  " + userId : "station_id = " + userId;
//		sql += " and service_order_source = 0 ";
		return huawuSystemMapper.select_item(sql);
	}

	@Override
	public GoodsInfo getGoodsInfo(Integer goodsid) {
		MfoyouGoodsInfoExample example = new MfoyouGoodsInfoExample();
		example.or().andGoodsIdEqualTo(goodsid);
		List<GoodsInfo> selectGoodsByExample = mfoyouSystemMapper.selectGoodsByExample(example);
		if (selectGoodsByExample != null && selectGoodsByExample.size() == 1) {
			GoodsInfo goodsInfo = selectGoodsByExample.get(0);
			HuawuStoreInfo selectByPrimaryKey = huawuStoreInfoMapper
					.selectByPrimaryKey(goodsInfo.getMfoyouGoodsInfo().getStoreId());
			goodsInfo.setPhoneNum(selectByPrimaryKey.getStorePhone());
			return goodsInfo;
		}
		return null;
	}

	@Override
	public ArrayListObject<GoodsInfo> listGoods(Integer pageSize, Integer pageId, MfoyouGoodsInfo info,
			Integer isStore) {
		MfoyouGoodsInfoExample example = new MfoyouGoodsInfoExample();
		MybatisGenerator.setLimit(example, pageId, pageSize);
		MfoyouGoodsInfoExample.Criteria criteria = example.or();
		if (isStore == 0) {
			criteria.andGoodsShelvesStateEqualTo(1);// 顾客查询 不返回未上架的
		} else if (info.getGoodsShelvesState() != null) {
			criteria.andGoodsShelvesStateEqualTo(info.getGoodsShelvesState());
		}
		if (info.getGoodsType() != null) {
			criteria.andGoodsTypeEqualTo(info.getGoodsType());
		}
		if (info.getStoreId() != null) {
			criteria.andStoreIdEqualTo(info.getStoreId());
		}
		if (info.getGoodsTitle() != null) {
			criteria.andGoodsTitleLike(info.getGoodsTitle());
		}
		int count = 0;
		if (isStore == 1) {
			Integer resut = mfoyouSystemMapper.selectSumGoods(info.getStoreId());
			count = resut == null ? 0 : resut.intValue();
		} else {
			count = mfoyouGoodsInfoMapper.countByExample(example);
		}
		example.setOrderByClause("goods_sort_top desc,goods_sort_leve desc,goods_gmt desc");
		List<GoodsInfo> goodsInfos = mfoyouSystemMapper.selectGoodsByExample(example);
		return ArrayListObject.bliudArrayList(goodsInfos, pageId, pageSize, count);
	}

	@Override
	public void dailyCount() {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		mfoyouSystemMapper.countGoods(dateFormat.format(date));
	}

	@Override
	public Integer realseStore() {
		// TODO Auto-generated method stub
		return mfoyouSystemMapper.relaseStore();
	}

	@Override
	public List<Map<String, Object>> getWxinfo(Integer agentId) {
		String sql = "select xcx_id ,xcx_type from huawu_agent_wx_info where agent_id = " + agentId;

		return huawuSystemMapper.select_list(sql);
	}

	@Override
	public List<MfoyouOrderStatic> getServiceAgentMoney(Integer agenid, Integer daynumber, int userType) {
		if (daynumber == null) {
			daynumber = 7;
		}
		return mfoyouSystemMapper.selectdate(agenid, daynumber, userType);
	}

	@Override
	public Map<String, Object> getTongji(Integer storeId) {
		// 交易额，付款单数
		String sql = "select count(*) ordercount,ifnull(sum(pay_amount),0)  sumAmount   from huawu_pay "
				+ "where to_days(pay_modify_time) = to_days(now()) and pay_store_id =" + storeId
				+ " and pay_state = 1 and pay_order_type < 9";
		// 外卖待结单，待发货
		String sql2 = "select  ifnull(sum(case when order_state = 50 then 1 else 0 end),0)  waitingRecept,"
				+ "ifnull(sum(case when order_state = 60 then 1 else 0 end),0)  recepted from mfoyou_goods_order where store_id  = "
				+ storeId + " and order_exception_state = 0";
		String sql4 = "select from_days(day_id) day_str, ifnull(allOrder,0) allOrder, ifnull(completOrder,0) completOder  from "
				+ "(select to_days(now()) day_id union all  select to_days(now())-1 day_id union all "
				+ "select to_days(now())-2 day_id union all select to_days(now())-3 day_id union all "
				+ "select to_days(now())-4 day_id union all select to_days(now())-5 day_id union all "
				+ "select to_days(now())-6 day_id union all select to_days(now())-7 day_id) a "
				+ "left join (select day_id ,count(order_id) allOrder,count(order_state) completOrder "
				+ "from (select order_id,case when order_state >= 40 then 1 else null end order_state,"
				+ "to_days(order_gct) day_id  from mfoyou_goods_order "
				+ "where order_gct > from_days(to_days(now())-7) and store_id= " + storeId
				+ ") k group by day_id) b using (day_id) ";
		Map<String, Object> select_item = mfoyouSystemMapper.select_item(sql);
		Map<String, Object> select_item2 = mfoyouSystemMapper.select_item(sql2);
		List<Map<String, Object>> select_list = mfoyouSystemMapper.select_list(sql4);
		select_item.putAll(select_item2);
		select_item.put("current7days", select_list);
		return select_item;
	}

	@Override
	public Map<String, Object> getTongjiV2(Integer storeId) {
		// 交易额，付款单数
		String sql = "select count(*) ordercount,ifnull(sum(pay_amount),0)  sumAmount   from huawu_pay "
				+ "where to_days(pay_modify_time) = to_days(now()) and pay_store_id =" + storeId
				+ " and pay_state = 1 ";
		String sql2 = "select count(*) yesordercount,ifnull(sum(pay_amount),0)  yessumAmount   from huawu_pay "
				+ "where to_days(pay_modify_time) = to_days(now())-1 and pay_store_id =" + storeId
				+ " and pay_state = 1 ";
		Map<String, Object> select_item = mfoyouSystemMapper.select_item(sql);
		Map<String, Object> select_item2 = mfoyouSystemMapper.select_item(sql2);
		select_item.putAll(select_item2);
		return select_item;
	}

	@Override
	public Map<String, Map<String, Object>> getTongjiV3(Integer storeId, Date date) {
		Map<String, Map<String, Object>> retMap = new HashMap<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String dayStr = simpleDateFormat.format(date);
		// 交易额，付款单数
		String sql = "select count(distinct(user_id)) userCount,count(1) orderCount,ifnull(sum(order_total_amount),0) totalMoney ,"
				+ "count(distinct(case when order_state between 40 and 610 then user_id else null end )) payUserCount,"
				+ "count(case when order_state between 40 and 610 then order_id else null end) payOrderCount,"
				+ "ifnull(sum(case when order_state between 40 and 610 then order_pay_amount  else 0 end),0) payMoney from "
				+ " (select order_state,order_id,order_pay_amount,user_id,"
				+ "order_total_amount from mfoyou_goods_order where date_format(order_gct,'%Y%m%d')=" + dayStr
				+ " and store_id = " + storeId + " )  b ";
		Map<String, Object> select_item = mfoyouSystemMapper.select_item(sql);
		retMap.put("the_day", select_item);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		String dayStr1 = simpleDateFormat.format(calendar.getTime());
		String sql2 = "select count(distinct(user_id)) userCount,count(1) orderCount,ifnull(sum(order_total_amount),0) totalMoney ,"
				+ "count(distinct(case when order_state between 40 and 610 then user_id else null end )) payUserCount,"
				+ "count(case when order_state between 40 and 610 then order_id else null end) payOrderCount,"
				+ "ifnull(sum(case when order_state between 40 and 610 then order_pay_amount  else 0 end),0) payMoney from "
				+ " (select order_state,order_id,order_pay_amount,user_id,"
				+ "order_total_amount from mfoyou_goods_order where date_format(order_gct,'%Y%m%d')=" + dayStr1
				+ " and store_id = " + storeId + " )  b ";
		Map<String, Object> select_item2 = mfoyouSystemMapper.select_item(sql2);
		retMap.put("yestheday", select_item2);
		return retMap;
	}

	@Override
	public Map<String, Object> getTongjiV3(Integer storeid, Long startDate, Long endDate) {
		String sql = "select count(distinct(user_id)) userCount,count(1) orderCount,ifnull(sum(order_total_amount),0) totalMoney ,"
				+ "count(distinct(case when order_state between 40 and 610 then user_id else null end )) payUserCount,"
				+ "count(case when order_state between 40 and 610 then order_id else null end) payOrderCount,"
				+ "ifnull(sum(case when order_state between 40 and 610 then order_pay_amount  else 0 end),0) payMoney from "
				+ " (select order_state,order_id,order_pay_amount,user_id,"
				+ "order_total_amount from mfoyou_goods_order where order_gct between FROM_UNIXTIME(" + startDate
				+ ") and FROM_UNIXTIME(" + endDate + ") and store_id = " + storeid + " )  b ";
		Map<String, Object> select_item = mfoyouSystemMapper.select_item(sql);
		return select_item;
	}
}
