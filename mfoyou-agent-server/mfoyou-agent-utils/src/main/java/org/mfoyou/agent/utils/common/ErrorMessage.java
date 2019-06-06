package org.mfoyou.agent.utils.common;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {

	private static Map<Integer, String> commonMap = new HashMap<>();

	static {
		commonMap.put(-4002, "未配置支付参数，无法提现");
		commonMap.put(-4000, "账户余额不足，无法充值");
		commonMap.put(-3334, "商品价格不足起送费");
		commonMap.put(-3333, "超出配送范围");
		commonMap.put(-3003, "积分不足");
		commonMap.put(-3002, "无该兑换信息");
		commonMap.put(-3001, "手机号已注册");
		commonMap.put(-3000, "用户无会员卡");
		commonMap.put(-2999, "没在配送时间内");
		commonMap.put(-2222, "商铺未找到");
		commonMap.put(-2001, "服务商未注册");
		commonMap.put(-1999, "商店没小程序，绑定个毛。");
		commonMap.put(-1998, "微信未配置");
		commonMap.put(-1557, "优惠券已过期");
		commonMap.put(-1556, "优惠券金额不对");
		commonMap.put(-1555, "优惠券已经没那么多了");
		commonMap.put(-1554, "优惠券不存在");
		commonMap.put(-1556, "优惠券已使用或已过期");
		commonMap.put(-1444, "验证码错误");
		commonMap.put(-1111, "所在城市无达达");
		commonMap.put(-1108, "信息未找到");
		commonMap.put(-1107, "删除打印机失败");
		commonMap.put(-1106, "自配送失败，订单初始状态不对");
		commonMap.put(-1105, "打印机已存在");
		commonMap.put(-1104, "参数缺失");
		commonMap.put(-1103, "参数错误");
		commonMap.put(-1102, "你未拥有该订单");
		commonMap.put(-1101, "订单不存在");
		commonMap.put(-1100, "打印机不存在");
		commonMap.put(-1004, "已接单，但无法配送");
		commonMap.put(-1003, "危险操作，请联系开发人员");
		commonMap.put(-1002, "订单处理错误，请联系管理员");
		commonMap.put(-1001, "订单不存在，有疑问请联系客服人员");
		commonMap.put(-1000, "配送余额不足");
		commonMap.put(-999, "该用户已经是服务商");
		commonMap.put(-998, "该站长已被其他服务商添加");
		commonMap.put(-405, "请确认 post/get 请求方式是否正确");
		commonMap.put(-404, "路径不正确,请确认路径");
		commonMap.put(-403, "未登录");
		commonMap.put(-201, "缺packagetid");
		commonMap.put(-124, "请重新登录。");
		commonMap.put(-103, "接单员不存在。");
		commonMap.put(-102, "功能未允许。");
		commonMap.put(-101, "无法删除分类，该分类下有商品");
		commonMap.put(-100, "未处理的异常情况，请联系开发人员");
		commonMap.put(-99, "提交json数据错误");
		commonMap.put(-98, "目标数据未找到");
		commonMap.put(-97, "无此权限");
		commonMap.put(-96, "参数缺失");
		commonMap.put(-95, "当前状态不允许此操作");
		commonMap.put(-94, "余额不足");
		commonMap.put(-93, "此订单已经完成支付,无须在进行支付");
		commonMap.put(-92, "抢单失败，订单已撤销或被其他达人接走了");
		commonMap.put(-91, "商家未在你区域内");
		commonMap.put(-90, "商家未定义坐标");
		commonMap.put(-89, "订单未达到商家最低起送价。");
		commonMap.put(-88, "商铺被禁，请联系管理员。");
		commonMap.put(-87, "该接单员已在其它团队,无法邀请");
		commonMap.put(-86, "登录成功，未设置区县");
		commonMap.put(-85, "提现金额不满足最低要求");
		commonMap.put(-84, "需要先绑定微信用户");		
		commonMap.put(-83, "登录成功，但是需要绑定用户");
		commonMap.put(-82, "未开通此功能");
		commonMap.put(-81, "申请审核中，请耐心等待");
		commonMap.put(-80, "申请审核未通过，请重新 修改资料");
		commonMap.put(-79, "登录失败");
		commonMap.put(-78, "请先完善用户资料");
		commonMap.put(-77, "用户需要实力认证");
		commonMap.put(-76, "性别不允许修改");
		commonMap.put(-75, "此用户已认证，请撤销后再认证");
		commonMap.put(-74, "非法的输入");
		commonMap.put(-73, "数据取值范围错误");
		commonMap.put(-72, "此用户尚未认证");
		commonMap.put(-71, "用户开通的账号，但未注册商城");
		commonMap.put(-70, "用户已注册商城");
		commonMap.put(-62,"代理商被关闭，请联系平台续约");
		commonMap.put(-54,"已被解雇，无法操作");
		commonMap.put(-53,"非本团队接单员");
		commonMap.put(-52, "接单员不存在");
		commonMap.put(-51, "金额一万以内");
		commonMap.put(-50, "更新失败");
		////商品相关 start  
		commonMap.put(-49, "商家已过期");
		commonMap.put(-48, "优惠已不存在");
		commonMap.put(-47, "优惠已使用过了");
		commonMap.put(-46, "配送费不够");
		commonMap.put(-45, "信息已存在");
		commonMap.put(-44, "该用户已绑定过了");
		commonMap.put(-42, "请稍户再试");
		commonMap.put(-41, "附近无团队");
		commonMap.put(-40, "商品没主要图片");
		commonMap.put(-39, "商品或套餐不存在");
		commonMap.put(-38, "提交数据不完整");
		commonMap.put(-37, "距离计算错误");
		commonMap.put(-36, "库存不足");
		commonMap.put(-35, "非本店铺订单");
		commonMap.put(-34, "库存锁定失败，请重试");
		commonMap.put(-33, "超出商家配送距离");
		////商品相关end
		commonMap.put(-32,"短信发送太频繁，请稍后再试");
		commonMap.put(-31,"代理商已到期，请联系平台续约");
		commonMap.put(-30,"时间不足，请及时联系管理员");
		commonMap.put(-29,"该商店不属于你的区县");
		commonMap.put(-28,"该店铺已关联服务商");
		commonMap.put(-27,"服务商不可用");
		commonMap.put(-26,"服务商不存在");
		commonMap.put(-24,"验证码过期");
		commonMap.put(-23, "时间格式不对");
		commonMap.put(-22, "时间范围不对");
		commonMap.put(-21,"测试接口");
		commonMap.put(-20, "账号已停用");
		commonMap.put(-19, "填写数据不符合规范，请重新填写");
		commonMap.put(-18, "无访问此接口权限");
		commonMap.put(-17, "重复的请求");
		commonMap.put(-16, "未完成订单数过多");
		commonMap.put(-15, "订单状态以及发生变化,请刷新后再提交");
		commonMap.put(-14, "提交参数值超过合理范围");
		commonMap.put(-13, "未注册用户");
		commonMap.put(-12, "验证码错误");
		commonMap.put(-11, "参数取值错误");
		commonMap.put(-10, "手机号已注册");
		commonMap.put(-9, "新用户自动注册失败");
		commonMap.put(-8, "短信验证码错误");
		commonMap.put(-7, "用户名或密码出错");
		commonMap.put(-6, "填写信息不全，请确认填写");
		commonMap.put(-5, "用户尚未激活");
		commonMap.put(-4, "短信服務器異常");
		commonMap.put(-3, "ip請求過於頻繁");
		commonMap.put(-2, "緩存服務器故障");
		commonMap.put(-1, "Fail");
		commonMap.put(0, "Success");
		commonMap.put(1, "操作成功，请支付响应费用");
		commonMap.put(5002,"付款金额超出限制。低于最小金额1.00元或累计超过20000.00元。");


	}

	public static String getCommonError(int errorCode) {
		
		String message = commonMap.get(errorCode);
		return message==null?"Unknown":message;
	}

	public static String getSmsError(int errorCode) {
		if(errorCode > 0)return "短信发送失败";
		return getCommonError(errorCode);
	}

}
