package com.mfoyou.agent.web.service.account;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.wx.WXBaseService;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;
import org.mfoyou.agent.common.dao.domain.*;
import org.mfoyou.agent.common.entity.WxMpUser;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.utils.common.*;
import org.mfoyou.agent.utils.map.MapObjectTrans;
import org.mfoyou.agent.utils.map.ReflectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {
	@Autowired
	IOrder iOrder;
	@Autowired
	IAccount iAccount;
	@Autowired
	SessionService sessionService;
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	WXBaseService wxBaseService;
	@Autowired
	IIdentity iIdentity;
	@Autowired
	StoreService storeService;
	private static final String keys = "huawuhuawuhuawu12138";
	Logger logger = LoggerFactory.getLogger(AccountService.class);

	public AgentTest getTest(int id) {
		return iOrder.getAgntTets(id);
	}

	public HuawuUser login(String phone, String pass, Integer agentId) {
		return iAccount.login(phone, makePassWord(pass), agentId);
	}

	private String makePassWord(String passWord) {
		return MD5Utils.encrypt(passWord, keys);
	}

	public JsonRet<?> loginV2(HttpServletRequest request, Integer type, HuawuUser huawuUser, Integer appId, Double lon,
			Double lat, Integer agentId) {
		if (huawuUser == null)
			return JsonRet.buildRet(-7);
		if ((huawuUser.getUserDisable() != null) && huawuUser.getUserDisable().equals(1)) {
			return JsonRet.buildRet(-20);
		}
		if ((type & 128) > 0)
			return JsonRet.buildRet(-20);// 不允许管理员登录
		// huawuUser.setUserName(accountSvc.getUserName(mfoyouUser.getUserId()));
		logger.info(JSON.toJSONString(huawuUser));
		int ret = 0;
		Map<String, String> retMap = MapObjectTrans.objectToMap(huawuUser);
		retMap.put("appId", appId + "");
		if (type.intValue() == MfoyouUserType.agent.getValue()) {
			if (agentId != 0)
				return JsonRet.buildRet(-1);
			HuawuAgentInfo huawuAgentInfo = new HuawuAgentInfo();
			ret = checkAgent(huawuUser.getUserId(), huawuAgentInfo);
			if (ret != 0)
				return ret == -3 ? JsonRet.buildRet(-31,huawuAgentInfo) : JsonRet.buildRet(-2001,huawuAgentInfo);
			if(huawuUser.getUserType()!=null && huawuUser.getUserType().intValue()!=1){
				retMap.put("power", (huawuUser.getUserType()<<8 | 1)+"");
			}else{
				retMap.put("power", "383");
			}
			retMap.putAll(MapObjectTrans.objectToMap(huawuAgentInfo));
		} else if (type.intValue() == MfoyouUserType.runer.getValue()) {
			HuawuWorker workerInfo = iAccount.getWorkerInfo(huawuUser.getUserId());
			if (workerInfo != null && workerInfo.getWorkerState() == -1)
				return JsonRet.buildRet(-20);
			if (workerInfo == null) {
				workerInfo = new HuawuWorker();
				workerInfo.setUserId(huawuUser.getUserId());
				workerInfo.setWorkerPhone(huawuUser.getUserPhone());
				workerInfo.setWorkerFee(20);
				if(agentId!=-2){
					workerInfo.setAgentId(agentId);
				}
				iIdentity.addWorker(workerInfo);
			}else{
				HuawuIdcardInfo idcardInfo = iAccount.getIdcardInfo(huawuUser.getUserId());
				// 保持与身份证表的认证状态一致
				if (idcardInfo != null) {
					Integer sqareFieldInt = idcardInfo.getState();
					workerInfo.setWorkerAuth(sqareFieldInt.intValue());
				} else {
					workerInfo.setWorkerAuth(0);
				}
			}
			retMap.putAll(MapObjectTrans.objectToMap(workerInfo));
			if(workerInfo.getAgentId()!=null)
			retMap.put("agentId", workerInfo.getAgentId()+"");
		} else if (type.intValue() == MfoyouUserType.store.getValue()) {
			HuawuStoreInfo huawuStoreInfo = storeService.getStoreInfo(huawuUser.getUserId());
			if (huawuStoreInfo != null && huawuStoreInfo.getStoreReject().intValue() == 1) {
				return JsonRet.buildRet(-88);
			}
			if (huawuStoreInfo != null) {
				retMap.putAll(MapObjectTrans.objectToMap(huawuStoreInfo));
				if(huawuStoreInfo.getStoreAgentId()!=null)
					retMap.put("agentId", huawuStoreInfo.getStoreAgentId()+"");
			} else {
				ret = -2;
			}
		}else if (type.intValue() == MfoyouUserType.station.getValue()) {
			MfoyouStationMaster mfoyouStationMaster = iIdentity.getStationMasterByUserId(huawuUser.getUserId());
			if(mfoyouStationMaster==null){
				return JsonRet.buildRet(-20);
			}
			retMap.putAll(MapObjectTrans.objectToMap(mfoyouStationMaster));
			retMap.put("agentId", mfoyouStationMaster.getAgentId()+"");
		}
		retMap.put("userType", (type | 0x01)+"");
		sessionService.loginSucessful(request, retMap, appId, agentId);
		// //保存用户状态数据
		Map<String, String> map = new HashMap<>();
		if (appId != null)
			map.put("appId", "" + appId);
		if (type != null)
			map.put("type", "" + type);
		if (lon != null)
			map.put("lon", "" + lon);
		if (lat != null)
			map.put("lat", "" + lat);
		map.put("phone", "" + huawuUser.getUserPhone());
		map.put("userName", huawuUser.getUserName());
		map.put("userNickName", "" + huawuUser.getUserNickName());
		map.put("loginTime", "" + System.currentTimeMillis());
		map.put("userHeadUrl", huawuUser.getUserHeadUrl());
		map.put("agentId", huawuUser.getAgentId()+"");
		logger.info(map.toString());
		redisCacheManger.setMapValue("u:" + huawuUser.getUserId(), map, 3600 * 24 * 180);
		HuawuUser save = new HuawuUser();
		if(appId.equals(100)){
			save.setUserSex(huawuUser.getUserSex());
			save.setUserHeadUrl(huawuUser.getUserHeadUrl());
			save.setUserNickName(huawuUser.getUserNickName());
		}
		save.setUserId(huawuUser.getUserId());
		save.setUserLastLogin(new Date());
		iAccount.modifyUser(save);
		if (ret == 0) {
			return JsonRet.buildSuccRet(retMap);
		} else if (ret == -2) {
			return JsonRet.buildRet(-82, retMap);
		}else {
			return JsonRet.buildRet(-80, huawuUser);
		}
	}

	private int checkAgent(Integer userId, HuawuAgentInfo huawuAgentInfo) {
		HuawuAgentInfo huawuAgentInfonew = iAccount.getAgentInfoByAgentId(userId);
		if (huawuAgentInfo != null) {
			ReflectUtil.ObjectCopy(huawuAgentInfonew, huawuAgentInfo);
		}
		return huawuAgentInfonew == null ? -4 : huawuAgentInfonew.getAgentEndTime().before(new Date()) ? -3 : 0;
	}

	public HuawuUser loginWechat(HttpServletRequest request, String code, Integer appId, Integer agentId,
			String headUrl, String sex, String nickName) {
		HuawuAgentWxInfo huawuAgentWxInfo = iAccount.getAgentWxInfo(agentId, appId);
		if (huawuAgentWxInfo == null) {
			return null;
		}
		HuawuUser huawuUser = null;
		String openId = wxBaseService.code2OpenId(code, huawuAgentWxInfo);
		if (openId == null)
			return null;
		HuawuThirdUser huawuThirdUser = iAccount.getThirdUser(agentId, appId, openId);
		if (huawuThirdUser != null) {
			// 此人已经绑定过了
			huawuUser = iAccount.getUserInfoByUserId(huawuThirdUser.getUserId());
			if (huawuUser.getUserHeadUrl() == null && appId.equals(200)) {
				String userString = wxBaseService.getUserInfo(openId, true, appId);
				WxMpUser user = JSON.parseObject(userString, WxMpUser.class);
				logger.info(userString);
				headUrl = user.getHeadimgurl();
				nickName = user.getNickname();
				sex = user.getSex();
			}
			huawuUser.setUserHeadWechatUrl(headUrl);
			huawuUser.setUserHeadUrl(headUrl);
			huawuUser.setUserNickName(nickName);
			huawuUser.setUserSex(sex);
			HuawuUser huawuUser2 = new HuawuUser();
			huawuUser2.setUserId(huawuUser.getUserId());
			huawuUser2.setUserHeadUrl(headUrl);
			huawuUser2.setUserNickName(nickName);
			iAccount.modifyUser(huawuUser2);
			logger.info("已绑定用户登录" + JSON.toJSONString(huawuUser));
		} else {
			huawuUser = new HuawuUser();
			if(headUrl!=null){
				huawuUser.setUserHeadUrl(headUrl);
				huawuUser.setUserSex(sex);
				huawuUser.setUserNickName(nickName);
			}
		}
		huawuUser.setOpenId(openId);// 修复 内嵌网页bug，内圈网页的时候 会传kong
		return huawuUser;
	}

	public HuawuUser userInfoByPhoneV1(String phone, Integer agentId) {

		return iAccount.getUserInfoByPhone(phone, agentId);
	}

	public HuawuUser registUser(HuawuUser huawuUser) {
		if(huawuUser.getUserPassword()!=null){
			huawuUser.setUserPassword(makePassWord(huawuUser.getUserPassword()));
		}
		return iAccount.registUser(huawuUser);
	}

	public HuawuUser bindWechat(HttpServletRequest request, Integer appId, String phone, String pass, boolean newUser,
			Integer agentId) {
		MfoyouMap currentUser = sessionService.currentUser(request);
		if (currentUser == null) {
			logger.error("openId is null");
			return null;
		}
		HuawuUser huawuUser = null;
		if (newUser) {
			huawuUser = new HuawuUser();
			huawuUser.setUserNickName(StrUtil.filterEmoji(currentUser.get("userNickName")));
			huawuUser.setUserHeadUrl(currentUser.get("userHeadUrl"));
			huawuUser.setUserPhone(phone);
			huawuUser.setAgentId(agentId);
			huawuUser.setUserSex(currentUser.get("userSex"));
			if (pass != null) {
				huawuUser.setUserPassword(pass);
			}
			huawuUser = registUser(huawuUser);
		} else {
			huawuUser = userInfoByPhoneV1(phone, agentId);
			if (huawuUser != null && pass != null) {
				huawuUser = login(phone, pass, agentId);
				if (huawuUser == null) {
					return null;
				}
			}
			if (huawuUser == null) {
				logger.error("密码错误或者未找到对应用户");
				return bindWechat(request, appId, phone, pass, true, agentId);
			}
			HuawuUser huawuuserSave = new HuawuUser();
			huawuuserSave.setUserId(huawuUser.getUserId());
			if (huawuUser.getUserNickName() == null)
				huawuuserSave.setUserNickName(StrUtil.filterEmoji(currentUser.get("userNickName")));
			if (huawuUser.getUserHeadUrl() == null)
				huawuuserSave.setUserHeadUrl(currentUser.get("userHeadUrl"));
			if (huawuUser.getUserSex() == null)
				huawuuserSave.setUserSex(currentUser.get("userSex"));
			huawuuserSave.setUserLastLogin(new Date());
			modifyUser(huawuuserSave);
			huawuUser = userInfoByPhoneV1(phone, agentId);
		}
		HuawuThirdUser huawuThirdUser = new HuawuThirdUser();
		huawuThirdUser.setUserId(huawuUser.getUserId());
		huawuThirdUser.setAppTypeId(appId);
		huawuThirdUser.setOpenId(currentUser.get("openId"));
		huawuThirdUser.setAgentId(agentId);
		iAccount.addThirdUser(huawuThirdUser);
		huawuUser.setOpenId(currentUser.get("openId"));
		return huawuUser;
	}

	private void modifyUser(HuawuUser huawuuserSave) {
		iAccount.modifyUser(huawuuserSave);
	}

	public boolean modifyUserPass(HttpServletRequest request, String phone, String oldPass, String newPass,
			Integer agentId) {
		HuawuUser huawuUser = null;
		if (oldPass != null) {
			huawuUser = login(sessionService.currentUserPhone(request), oldPass, agentId);
		} else {
			huawuUser = userInfoByPhoneV1(phone, agentId);
		}
		if (huawuUser == null) {
			return false;
		}
		HuawuUser huawuNewUser = new HuawuUser();
		huawuNewUser.setUserId(huawuUser.getUserId());
		huawuNewUser.setUserPassword(makePassWord(newPass));
		return iAccount.modifyUser(huawuNewUser) == 1;
	}

	public Boolean modifyUserPass(HttpServletRequest request, String newPass) {
		HuawuUser mfoyouUser = new HuawuUser();
		mfoyouUser.setUserId(sessionService.currentUserId(request));
		mfoyouUser.setUserPassword(makePassWord(newPass));
		return iAccount.modifyUser(mfoyouUser) == 1;
	}

	public HuawuUser userInfo(Integer currentUserId) {
		return iAccount.getUserInfoByUserId(currentUserId);
	}

	public Integer authentication(String code, String appId, Integer storeId, Integer agentId) {
		HuawuAgentWxInfo agentWxInfo = iAccount.getAgentWxInfo(agentId, 200);
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + agentWxInfo.getXcxId() + "&secret="
				+ agentWxInfo.getXcxSecret() + "&code=" + code + "&grant_type=authorization_code";
		String response = HttpsUtils.get(url);
		if (response == null)
			return null;
		logger.info(url + ";response:" + response);
		JSONObject object = JSON.parseObject(response);
		String openId = object.getString("openid");
		logger.info("openid:" + openId);
		if (openId == null) {
			return 0;
		}
		HuawuThirdUser mfoyouThirdUser = new HuawuThirdUser();
		mfoyouThirdUser.setUserId(storeId);
		mfoyouThirdUser.setAgentId(agentId);
		mfoyouThirdUser.setOpenId(openId);
		mfoyouThirdUser.setAppTypeId(200);
		Integer result = iAccount.addThirdUser(mfoyouThirdUser);
		updateWe(appId, storeId);
		return result;
	}

	public void updateWe(String appId, Integer storeId) {
		HuawuWorker huawuWorker = new HuawuWorker();
		huawuWorker.setUserId(storeId);
		huawuWorker.setWorkerThirdAuth(1);

		iIdentity.modifyMfoyouWorkerInfo(huawuWorker);
	}
}
