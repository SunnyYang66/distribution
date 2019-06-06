package org.mfoyou.agent.task.utils;

import java.net.SocketTimeoutException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.conn.ConnectTimeoutException;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderItme;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderWithPackage;
import org.mfoyou.agent.utils.common.HttpsUtils;

import com.alibaba.fastjson.JSON;


public class WxPushUtil {
	public static String push(String type,String token, MfoyouGoodsOrderWithPackage goodsOrderWith,String toUser, String modelId) throws ConnectTimeoutException, SocketTimeoutException, Exception{
		String result = null;
		if(type.equals("1")){
			result = HttpsUtils.postJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token, 
					getDataPaySuccess(goodsOrderWith,toUser,modelId));
		}else if (type.equals("2")){
			result = HttpsUtils.postJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token, 
					getDataRevokeOrder(goodsOrderWith,toUser,modelId));
		}else if(type.equals("3")){
			result = HttpsUtils.postJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token, 
					getDataPushStore(goodsOrderWith,toUser,modelId));
		}else if(type.equals("4")){
			result = HttpsUtils.postJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token, 
					returnMoney(goodsOrderWith,toUser,modelId));
		}else if(type.equals("5")){
			result = HttpsUtils.postJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token, 
					notyfyReturnOrder(goodsOrderWith,toUser,modelId));
		}
		return result;
	}
	public static String pushtoRunner(String type,String token,HuawuServiceOrder orderNumber,String toUser,String modelId,String appid) throws ConnectTimeoutException, SocketTimeoutException, Exception{
		String result = null;
		if(type.equals("1")){
			result = HttpsUtils.postJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token, 
					notifyNewOrder(orderNumber,toUser,modelId,appid));
		}else if (type.equals("2")){
			result = HttpsUtils.postJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token, 
					lateOrder(orderNumber,toUser,modelId,appid));
		}else if (type.equals("3")){
			result = HttpsUtils.postJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token, 
					revokeOrder(orderNumber,toUser,modelId,appid));
		}
		return result;
	}
	/**
	 * type为7
	 * @param serviceOrder
	 * @param toUser
	 * @return
	 */
	public static  String  revokeOrder(HuawuServiceOrder serviceOrder,String toUser,String modelId,String appid){
		WxPushRevokeOrderData wxPushData = new WxPushRevokeOrderData();
		//start
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日   HH:mm");
		WxPushRevokeOrderData.Data data = wxPushData.new Data();
		WxPushRevokeOrderData.ValueData first = wxPushData.new ValueData();
		first.setColor("#173177");
		first.setValue("您有个订单已被撤销，详情请联系管理员。");
		data.setFirst(first);
		WxPushRevokeOrderData.ValueData keyword1 = wxPushData.new ValueData();
		keyword1.setColor("#173177");
		keyword1.setValue(serviceOrder.getServiceOrderNumber());
		data.setKeyword1(keyword1);
		WxPushRevokeOrderData.ValueData keyword2 = wxPushData.new ValueData();
		keyword2.setColor("#173177");
		keyword2.setValue("取消");
		data.setKeyword2(keyword2);
		WxPushRevokeOrderData.ValueData keyword3 = wxPushData.new ValueData();
		keyword3.setColor("#173177");
		keyword3.setValue(formatPrice(serviceOrder.getServiceOrderAmount())+"元");
		data.setKeyword3(keyword3);
		WxPushRevokeOrderData.ValueData keyword4 = wxPushData.new ValueData();
		keyword4.setColor("#173177");
		keyword4.setValue(simpleDateFormat.format(serviceOrder.getServiceOrderCreateTime()));
		data.setKeyword4(keyword4);
		WxPushRevokeOrderData.ValueData keyword5 = wxPushData.new ValueData();
		keyword5.setColor("#173177");
		data.setKeyword5(keyword5);
		Integer serviceOrderType = serviceOrder.getServiceOrderType();
		keyword5.setValue(serviceOrderType == 1 ? "帮我取," : serviceOrderType == 2 ? "帮我送 ," :
			serviceOrderType == 3 ? "帮我买," : "帮我做,"+serviceOrder.getServiceTagName());
		WxPushRevokeOrderData.ValueData remark = wxPushData.new ValueData();
		remark.setColor("#DE5B49");
		remark.setValue(" ");
		data.setRemark(remark);
		WxPushRevokeOrderData.Miniprogram miniprogram = wxPushData.new Miniprogram();
		miniprogram.setAppid(appid);
		miniprogram.setPagepath("/pages/index/index");
		wxPushData.setMiniprogram(miniprogram);
		wxPushData.setData(data);
		wxPushData.setTouser(toUser);
		wxPushData.setTemplate_id(modelId);
		return JSON.toJSONString(wxPushData);
	}
	/**
	 * type为1 
	 * @param serviceOrder
	 * @param toUser
	 * @return
	 */
	public static  String  notifyNewOrder(HuawuServiceOrder serviceOrder,String toUser,String modelId,String appid){
		WxPushStoreNotifyData wxPushData = new WxPushStoreNotifyData();
		WxPushStoreNotifyData.Data data = wxPushData.new Data();
		WxPushStoreNotifyData.ValueData first = wxPushData.new ValueData();
		first.setColor("#173177");
		first.setValue("师傅师傅，华悟快送又来新订单啦！请及时处理。其他华悟快送跑腿员都开始抢单啦！");
		data.setFirst(first);
		WxPushStoreNotifyData.ValueData keyword1 = wxPushData.new ValueData();
		keyword1.setColor("#173177");
		keyword1.setValue(serviceOrder.getServiceOrderDeliveryContactName());
		data.setKeyword1(keyword1);
		WxPushStoreNotifyData.ValueData keyword2 = wxPushData.new ValueData();
		keyword2.setColor("#173177");
		keyword2.setValue(serviceOrder.getServiceOrderDeliveryContactNumber());
		data.setKeyword2(keyword2);
		WxPushStoreNotifyData.ValueData keyword3 = wxPushData.new ValueData();
		keyword3.setColor("#173177");
		String content = "";
		int serviceOrderType = serviceOrder.getServiceOrderType().intValue();
		content += serviceOrderType == 1 ? "帮我取," : serviceOrderType == 2 ? "帮我送 ," :
			serviceOrderType == 3 ? "帮我买," : "帮我做," ;
		content += serviceOrder.getServiceTagName()+",";
		if(serviceOrderType == 1 || serviceOrderType == 2){
			content += serviceOrder.getServiceOrderWeight()/1000+"kg,";
		}else if(serviceOrderType == 3){
			content += formatPrice(serviceOrder.getServiceOrderGoodAmount())+"元";
		}
		if(serviceOrder.getServiceOrderSource()==null || serviceOrder.getServiceOrderSource()==0)
		content += serviceOrder.getServiceOrderContent();
		keyword3.setValue(content);	
		data.setKeyword3(keyword3);
		WxPushStoreNotifyData.ValueData keyword4 = wxPushData.new ValueData();
		keyword4.setColor("#173177");
		keyword4.setValue(formatPrice(serviceOrder.getServiceOrderAmount()));
		data.setKeyword4(keyword4);
		WxPushStoreNotifyData.ValueData remark = wxPushData.new ValueData();
		remark.setColor("#DE5B49");
		remark.setValue("～～点我一键抢单赚佣金");
		data.setRemark(remark);
		WxPushStoreNotifyData.Miniprogram miniprogram = wxPushData.new Miniprogram();
		miniprogram.setAppid(appid);
		miniprogram.setPagepath("/pages/index/index");
		wxPushData.setMiniprogram(miniprogram);
		wxPushData.setData(data);
		wxPushData.setTouser(toUser);
		wxPushData.setTemplate_id(modelId);
		return JSON.toJSONString(wxPushData);
	}
	/**
	 * type为2
	 * @param orderNumber
	 * @param toUser
	 * @param modelId 
	 * @param appid 
	 * @return
	 */
	public static  String  lateOrder(HuawuServiceOrder orderNumber,String toUser, String modelId, String appid){
		WxPushRunerData wxPushData = new WxPushRunerData();
		WxPushRunerData.Data data = wxPushData.new Data();
		WxPushRunerData.ValueData first = wxPushData.new ValueData();
		first.setColor("#173177");
		first.setValue("你有一个华悟快送订单已经服务超时，请抓紧时间完成服务。同时请致电顾客说明情况及剩余时间！");
		data.setFirst(first);
		WxPushRunerData.ValueData keyword1 = wxPushData.new ValueData();
		keyword1.setColor("#173177");
		keyword1.setValue(orderNumber.getServiceOrderId()+"");
		data.setKeyword1(keyword1);
		WxPushRunerData.ValueData keyword2 = wxPushData.new ValueData();
		keyword2.setColor("#173177");
		keyword2.setValue(orderNumber.getServiceOrderState() == 1 ? "待抢单":"待开始");
		data.setKeyword2(keyword2);
		WxPushRunerData.Miniprogram miniprogram = wxPushData.new Miniprogram();
		miniprogram.setAppid(appid);
		miniprogram.setPagepath("/pages/index/index");
		wxPushData.setMiniprogram(miniprogram);
		wxPushData.setData(data);
		wxPushData.setTouser(toUser);
		wxPushData.setTemplate_id(modelId);
		return JSON.toJSONString(wxPushData);
	}
	/**
	 * 模板为7
	 * @param goodsOrderWith
	 * @param toUser
	 * @param modelId 
	 * @return
	 */
	public static  String  getDataRevokeOrder(MfoyouGoodsOrderWithPackage goodsOrderWith,String toUser, String modelId){
		WxPushRevokeOrderData wxPushData = new WxPushRevokeOrderData();
		//start
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日   HH:mm");
		WxPushRevokeOrderData.Data data = wxPushData.new Data();
		WxPushRevokeOrderData.ValueData first = wxPushData.new ValueData();
		first.setColor("#173177");
		first.setValue("尊敬的华悟云购顾客***您好！");
		data.setFirst(first);
		WxPushRevokeOrderData.ValueData keyword1 = wxPushData.new ValueData();
		keyword1.setColor("#173177");
		keyword1.setValue(goodsOrderWith.getOrderNumber());
		data.setKeyword1(keyword1);
		WxPushRevokeOrderData.ValueData keyword2 = wxPushData.new ValueData();
		keyword2.setColor("#173177");
		keyword2.setValue("商家已取消");
		data.setKeyword2(keyword2);
		WxPushRevokeOrderData.ValueData keyword3 = wxPushData.new ValueData();
		keyword3.setColor("#173177");
		keyword3.setValue(formatPrice(goodsOrderWith.getOrderPayAmount())+"元");
		data.setKeyword3(keyword3);
		WxPushRevokeOrderData.ValueData keyword4 = wxPushData.new ValueData();
		keyword4.setColor("#173177");
		keyword4.setValue(simpleDateFormat.format(goodsOrderWith.getOrderPayTime()));
		data.setKeyword4(keyword4);
		WxPushRevokeOrderData.ValueData keyword5 = wxPushData.new ValueData();
		keyword5.setColor("#173177");
		keyword5.setValue(goodsOrderWith.getOrderUserPhone());
		data.setKeyword5(keyword5);
		WxPushRevokeOrderData.ValueData remark = wxPushData.new ValueData();
		remark.setColor("#DE5B49");
		remark.setValue("此单已于"+simpleDateFormat.format(goodsOrderWith.getOrderGmt())+"被商家取消，如有疑问，请联系我们。");
		data.setRemark(remark);
		wxPushData.setData(data);
		wxPushData.setTouser(toUser);
		wxPushData.setTemplate_id(modelId);
		wxPushData.setUrl("https://m.mfoyou.com/huawucloud/#!/orderInfo?orderId="+goodsOrderWith.getOrderId());
		return JSON.toJSONString(wxPushData);
	}
	/**
	 * id为7
	 * @param goodsOrderWith
	 * @param toUser
	 * @param modelId 
	 * @return
	 */
	public static  String  notyfyReturnOrder(MfoyouGoodsOrderWithPackage goodsOrderWith,String toUser, String modelId){
		WxPushRevokeOrderData wxPushData = new WxPushRevokeOrderData();
		//start
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日   HH:mm");
		WxPushRevokeOrderData.Data data = wxPushData.new Data();
		WxPushRevokeOrderData.ValueData first = wxPushData.new ValueData();
		first.setColor("#173177");
		first.setValue("尊敬的华悟云购顾客***您好！");
		data.setFirst(first);
		WxPushRevokeOrderData.ValueData keyword1 = wxPushData.new ValueData();
		keyword1.setColor("#173177");
		keyword1.setValue(goodsOrderWith.getOrderNumber());
		data.setKeyword1(keyword1);
		WxPushRevokeOrderData.ValueData keyword2 = wxPushData.new ValueData();
		keyword2.setColor("#173177");
		keyword2.setValue("商家已取消");
		data.setKeyword2(keyword2);
		WxPushRevokeOrderData.ValueData keyword3 = wxPushData.new ValueData();
		keyword3.setColor("#173177");
		keyword3.setValue(formatPrice(goodsOrderWith.getOrderPayAmount())+"元");
		data.setKeyword3(keyword3);
		WxPushRevokeOrderData.ValueData keyword4 = wxPushData.new ValueData();
		keyword4.setColor("#173177");
		keyword4.setValue(simpleDateFormat.format(goodsOrderWith.getOrderPayTime()));
		data.setKeyword4(keyword4);
		WxPushRevokeOrderData.ValueData keyword5 = wxPushData.new ValueData();
		keyword5.setColor("#173177");
		keyword5.setValue(goodsOrderWith.getOrderUserPhone());
		data.setKeyword5(keyword5);
		WxPushRevokeOrderData.ValueData remark = wxPushData.new ValueData();
		remark.setColor("#DE5B49");
		remark.setValue("#"+goodsOrderWith.getOrderNumber().substring(10,13)+"号 顾客申请退款，请查看订单。");
		data.setRemark(remark);
		wxPushData.setData(data);
		WxPushRevokeOrderData.Miniprogram miniprogram = wxPushData.new Miniprogram();
		miniprogram.setAppid("wx85d40dd074a5b18f");
		miniprogram.setPagepath("/pages/finance/manage/manage");
		wxPushData.setMiniprogram(miniprogram);
		wxPushData.setTouser(toUser);
		wxPushData.setTemplate_id(modelId);
		return JSON.toJSONString(wxPushData);
	}
	/**
	 * 退款  id为7
	 * @param goodsOrderWith
	 * @param toUser
	 * @param modelId 
	 * @return
	 */
	public static  String  returnMoney(MfoyouGoodsOrderWithPackage goodsOrderWith,String toUser, String modelId){
		WxPushRevokeOrderData wxPushData = new WxPushRevokeOrderData();
		//start
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日   HH:mm");
		WxPushRevokeOrderData.Data data = wxPushData.new Data();
		WxPushRevokeOrderData.ValueData first = wxPushData.new ValueData();
		first.setColor("#173177");
		first.setValue("尊敬的华悟云购顾客***您好！");
		data.setFirst(first);
		WxPushRevokeOrderData.ValueData keyword1 = wxPushData.new ValueData();
		keyword1.setColor("#173177");
		keyword1.setValue(goodsOrderWith.getOrderNumber());
		data.setKeyword1(keyword1);
		WxPushRevokeOrderData.ValueData keyword2 = wxPushData.new ValueData();
		keyword2.setColor("#173177");
		keyword2.setValue("申请退款成功。");
		data.setKeyword2(keyword2);
		WxPushRevokeOrderData.ValueData keyword3 = wxPushData.new ValueData();
		keyword3.setColor("#173177");
		keyword3.setValue(formatPrice(goodsOrderWith.getOrderPayAmount())+"元");
		data.setKeyword3(keyword3);
		WxPushRevokeOrderData.ValueData keyword4 = wxPushData.new ValueData();
		keyword4.setColor("#173177");
		keyword4.setValue(simpleDateFormat.format(new Date()));
		data.setKeyword4(keyword4);
		WxPushRevokeOrderData.ValueData keyword5 = wxPushData.new ValueData();
		keyword5.setColor("#173177");
		keyword5.setValue(goodsOrderWith.getOrderUserPhone());
		data.setKeyword5(keyword5);
		WxPushRevokeOrderData.ValueData remark = wxPushData.new ValueData();
		remark.setColor("#DE5B49");
		remark.setValue("米多多 订单编号为："+goodsOrderWith.getOrderNumber()+"商家已处理退款，请注意查收。");
		data.setRemark(remark);
		wxPushData.setData(data);
		wxPushData.setTouser(toUser);
		wxPushData.setTemplate_id(modelId);
		wxPushData.setUrl("https://m.mfoyou.com/huawucloud/#!/orderInfo?orderId="+goodsOrderWith.getOrderId());
		return JSON.toJSONString(wxPushData);
	}
	/**
	 * 支付成功  id为5
	 * @param goodsOrderWith
	 * @param toUser
	 * @param modelId 
	 * @return
	 */
	public static  String  getDataPaySuccess(MfoyouGoodsOrderWithPackage goodsOrderWith,String toUser, String modelId){
		String content = "";
		List<MfoyouGoodsOrderItme> goodsOrderItmes = goodsOrderWith.getGoodsOrderItmes();
		for(MfoyouGoodsOrderItme goodsOrderItme : goodsOrderItmes){
			content += goodsOrderItme.getGoodsName()+"("+goodsOrderItme.getItemNumber()+") ";
		}
		WxPushPaySuccessData wxPushData = new WxPushPaySuccessData();
		//start
		WxPushPaySuccessData.Data data = wxPushData.new Data();
		WxPushPaySuccessData.ValueData first = wxPushData.new ValueData();
		first.setColor("#173177");
		first.setValue("尊敬的华悟云购顾客，您的华悟云购订单已经成功付款啦～商家正在秒速安排配送，尽心尽力，不愿让您久等！");
		data.setFirst(first);
		WxPushPaySuccessData.ValueData orderProductPrice = wxPushData.new ValueData();
		orderProductPrice.setColor("#173177");
		orderProductPrice.setValue(formatPrice(goodsOrderWith.getOrderPayAmount())+"元");
		data.setOrderProductPrice(orderProductPrice);
		WxPushPaySuccessData.ValueData orderProductName = wxPushData.new ValueData();
		orderProductName.setColor("#173177");
		orderProductName.setValue(content);
		data.setOrderProductName(orderProductName);
		WxPushPaySuccessData.ValueData orderAddress = wxPushData.new ValueData();
		orderAddress.setColor("#173177");
		orderAddress.setValue(goodsOrderWith.getOrderUserAddress());
		data.setOrderAddress(orderAddress);
		WxPushPaySuccessData.ValueData orderName = wxPushData.new ValueData();
		orderName.setColor("#173177");
		orderName.setValue(goodsOrderWith.getOrderNumber());
		data.setOrderName(orderName);
		WxPushPaySuccessData.ValueData remark = wxPushData.new ValueData();
		remark.setColor("#DE5B49");
		remark.setValue("点击查看订单详情");
		data.setRemark(remark);
		wxPushData.setData(data);
		wxPushData.setTouser(toUser);
		wxPushData.setTemplate_id(modelId);
		wxPushData.setUrl("https://m.mfoyou.com/huawucloud/#!/orderInfo?orderId="+goodsOrderWith.getOrderId());
		return JSON.toJSONString(wxPushData);
	}
	/**
	 * push id为6
	 * @param goodsOrderWith
	 * @param toUser
	 * @param modelId 
	 * @return
	 */
	public static  String  getDataPushStore(MfoyouGoodsOrderWithPackage goodsOrderWith,String toUser, String modelId){
		WxPushStoreNotifyData wxPushData = new WxPushStoreNotifyData();
		//start
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日   HH:mm");
		Date orderPayTime = goodsOrderWith.getOrderPayTime();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(orderPayTime);
		calendar.add(Calendar.MINUTE, 45);
		WxPushStoreNotifyData.Data data = wxPushData.new Data();
		WxPushStoreNotifyData.ValueData first = wxPushData.new ValueData();
		first.setColor("#173177");
		first.setValue("老板，华悟云店又有新订单啦！请快速进入“华悟云店”小程序进行接单处理.");
		data.setFirst(first);
		WxPushStoreNotifyData.ValueData keyword1 = wxPushData.new ValueData();
		keyword1.setColor("#173177");
		keyword1.setValue(goodsOrderWith.getOrderNumber());
		data.setKeyword1(keyword1);
		WxPushStoreNotifyData.ValueData keyword2 = wxPushData.new ValueData();
		keyword2.setColor("#173177");
		keyword2.setValue(formatPrice(goodsOrderWith.getOrderPayAmount())+"元");
		data.setKeyword2(keyword2);
		WxPushStoreNotifyData.ValueData keyword3 = wxPushData.new ValueData();
		keyword3.setColor("#173177");
		keyword3.setValue(simpleDateFormat.format(calendar.getTime()));
		data.setKeyword3(keyword3);
		WxPushStoreNotifyData.ValueData keyword4 = wxPushData.new ValueData();
		keyword4.setColor("#173177");
		keyword4.setValue(goodsOrderWith.getOrderUserName()+"/"+goodsOrderWith.getOrderUserPhone());
		data.setKeyword4(keyword4);
		WxPushStoreNotifyData.ValueData keyword5 = wxPushData.new ValueData();
		keyword5.setColor("#173177");
		keyword5.setValue(goodsOrderWith.getOrderUserAddress());
		data.setKeyword5(keyword5);
		WxPushStoreNotifyData.ValueData remark = wxPushData.new ValueData();
		remark.setColor("#DE5B49");
		remark.setValue("点击查看订单详情");
		data.setRemark(remark);
		wxPushData.setData(data);
		WxPushStoreNotifyData.Miniprogram miniprogram = wxPushData.new Miniprogram();
		miniprogram.setAppid("wx85d40dd074a5b18f");
		miniprogram.setPagepath("/pages/index/index");
		wxPushData.setMiniprogram(miniprogram);
		wxPushData.setTouser(toUser);
		wxPushData.setTemplate_id(modelId);
		return JSON.toJSONString(wxPushData);
	}
	
	/**
	 * 模板id为3
	 * @param thirdPlatformOpenid
	 * @param ret
	 * @param amount
	 * @param date
	 * @param msg
	 * @return
	 */
	public static String getExtractFail(String thirdPlatformOpenid,Integer ret,Integer amount,Long date,String msg){
		WxPushExtractFailData wxPushData = new WxPushExtractFailData();
		//start
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		WxPushExtractFailData.Data data = wxPushData.new Data();
		WxPushExtractFailData.ValueData first = wxPushData.new ValueData();
		first.setColor("#173177");
		first.setValue("尊敬的华悟云商客户，您有一笔资金提现打款失败！失败原因:"+msg);
		data.setFirst(first);
		WxPushExtractFailData.ValueData money = wxPushData.new ValueData();
		money.setColor("#173177");
		money.setValue(formatPrice(amount)+"元");
		data.setMoney(money);
		WxPushExtractFailData.ValueData time = wxPushData.new ValueData();
		time.setColor("#173177");
		time.setValue(simpleDateFormat.format(new Date(date)));
		data.setTime(time);
		WxPushExtractFailData.ValueData remark = wxPushData.new ValueData();
		remark.setColor("#DE5B49");
		remark.setValue("资金已原路退回提现钱包，请更正提现账户信息后再次提现！");
		data.setRemark(remark);
		wxPushData.setData(data);
		WxPushExtractFailData.Miniprogram miniprogram = wxPushData.new Miniprogram();
		miniprogram.setAppid("wx85d40dd074a5b18f");
		miniprogram.setPagepath("/pages/finance/manage/manage");
		wxPushData.setMiniprogram(miniprogram);
		wxPushData.setTouser(thirdPlatformOpenid);
		wxPushData.setTemplate_id("SQQtMYXqjobuueoSD8dE4ZInYHr_P4G-wARa_TOIu9U");
		return JSON.toJSONString(wxPushData);
	}
	/**
	 * 同为3
	 * @param thirdPlatformOpenid
	 * @param ret
	 * @param amount
	 * @param date
	 * @param msg
	 * @return
	 */
	public static String getExtractRevoke(String thirdPlatformOpenid,Integer ret,Integer amount,Long date,String msg){
		WxPushExtractFailData wxPushData = new WxPushExtractFailData();
		//start
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		WxPushExtractFailData.Data data = wxPushData.new Data();
		WxPushExtractFailData.ValueData first = wxPushData.new ValueData();
		first.setColor("#173177");
		first.setValue("你的提现申请已被驳回，具体情况请联系平台。");
		data.setFirst(first);
		WxPushExtractFailData.ValueData money = wxPushData.new ValueData();
		money.setColor("#173177");
		money.setValue(formatPrice(amount)+"元");
		data.setMoney(money);
		WxPushExtractFailData.ValueData time = wxPushData.new ValueData();
		time.setColor("#173177");
		time.setValue(simpleDateFormat.format(new Date(date)));
		data.setTime(time);
		WxPushExtractFailData.ValueData remark = wxPushData.new ValueData();
		remark.setColor("#DE5B49");
		remark.setValue("资金已原路退回提现钱包，驳回具体原因请联系平台");
		data.setRemark(remark);
		wxPushData.setData(data);
		WxPushExtractFailData.Miniprogram miniprogram = wxPushData.new Miniprogram();
		miniprogram.setAppid("wx85d40dd074a5b18f");
		miniprogram.setPagepath("/pages/finance/manage/manage");
		wxPushData.setMiniprogram(miniprogram);
		wxPushData.setTouser(thirdPlatformOpenid);
		wxPushData.setTemplate_id("SQQtMYXqjobuueoSD8dE4ZInYHr_P4G-wARa_TOIu9U");
		return JSON.toJSONString(wxPushData);
	}
	/**
	 * type  4
	 * @param thirdPlatformOpenid
	 * @param ret
	 * @param amount
	 * @param date
	 * @param msg
	 * @return
	 */
	public static String getExtractSuccess(String thirdPlatformOpenid,Integer ret,Integer amount,Long date,String msg){
		WxPushExtractSuccessData wxPushData = new WxPushExtractSuccessData();
		//start
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		WxPushExtractSuccessData.Data data = wxPushData.new Data();
		WxPushExtractSuccessData.ValueData first = wxPushData.new ValueData();
		first.setColor("#173177");
		first.setValue("尊敬的华悟云商客户，您有一笔资金提现受理成功！");
		data.setFirst(first);
		WxPushExtractSuccessData.ValueData money = wxPushData.new ValueData();
		money.setColor("#173177");
		money.setValue(formatPrice(amount)+"元");
		data.setMoney(money);
		WxPushExtractSuccessData.ValueData timet = wxPushData.new ValueData();
		timet.setColor("#173177");
		timet.setValue(simpleDateFormat.format(new Date(date)));
		data.setTimet(timet);
		WxPushExtractSuccessData.ValueData remark = wxPushData.new ValueData();
		remark.setColor("#DE5B49");
		remark.setValue("资金已成功汇入指定收款账户，请注意查收！！");
		data.setRemark(remark);
		wxPushData.setData(data);
		WxPushExtractSuccessData.Miniprogram miniprogram = wxPushData.new Miniprogram();
		miniprogram.setAppid("wx85d40dd074a5b18f");
		miniprogram.setPagepath("/pages/finance/manage/manage");
		wxPushData.setMiniprogram(miniprogram);
		wxPushData.setTouser(thirdPlatformOpenid);
		wxPushData.setTemplate_id("Nj-NLkXdLE8mbpEcgDHDkeTSGBLWDIwx6ssNxoWN0Lw");
		return JSON.toJSONString(wxPushData);
	}
	/**
	 * 
	 * @param thirdPlatformOpenid
	 * @param token
	 * @param ret
	 * @param amount
	 * @param date
	 * @param msg
	 * @return
	 */
	public static String pushExtract(String thirdPlatformOpenid, String token, Integer ret, Integer amount, Long date,
			String msg){
		String pushData = "";
		if(ret.intValue() == 0){
			pushData = getExtractSuccess(thirdPlatformOpenid, ret, amount, date, msg);
		}else if(ret.intValue()==3){
			pushData = getExtractRevoke(thirdPlatformOpenid, ret, amount, date, msg);
		}else{
			pushData =  getExtractFail(thirdPlatformOpenid, ret, amount, date, msg);
		}
		String result = "fail";
		try {
			result = HttpsUtils.postJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token, 
						pushData);
		} catch (ConnectTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	private static String formatPrice(Integer acount){
		DecimalFormat   df   =new   DecimalFormat("#0.00");  
		Double intValue = (double) acount.intValue();
		return df.format(intValue/100);
	}
}
