package com.mfoyou.agent.web.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.common.dao.domain.HuawuAgentStoreSetting;
import org.mfoyou.agent.common.dao.domain.HuawuAgentWxInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGdCity;
import org.mfoyou.agent.common.inf.ICommon;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IStatistics;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.MfoyouEncrypt;
import org.mfoyou.agent.utils.common.ObjectUtil;
import org.mfoyou.agent.utils.common.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.AccountService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.wx.WXBaseService;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

import weixin.p3.oauth2.util.Sign;

@Path("/common")
@Service
public class CommonController {
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	AccountService accountService;
	@Autowired
	IIdentity iIdentity;
	@Autowired
	SessionService sessionService;
	@Autowired
	WXBaseService wxBaseService;
	@Autowired
	ICommon iCommon;
	@Autowired
	IStatistics iStatistics;

	@GET
	@Path(value = "/test")
	@UrlRight(UserRight.ALLACCESS)
	@Produces("application/json;charset=UTF-8")
	public JsonRet<?> test(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		redisCacheManger.setValue("test", "test", 300);
		return JsonRet.buildSuccRet(accountService.getTest(1));
	}

	@GET
	@Path(value = "baseAgentInfo/{agentId}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> baseAgentInfo(@Context HttpServletRequest request, @PathParam("agentId") String agentstr,
			@QueryParam("appId") Integer appid) {
		Integer agentId = MfoyouEncrypt.decode(agentstr);
		HuawuAgentStoreSetting specialSettingV1 = iIdentity.getSpecialSettingV1(agentId);
		specialSettingV1.setAppid(iStatistics.getWxinfo(agentId));
		return JsonRet.buildSuccRet(specialSettingV1);
	}

	@GET
	@Path(value = "wxShareSigen/{agentId}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> wxShareSigen(@Context HttpServletRequest request, @PathParam("agentId") Integer agentId,
			@QueryParam("url") String url, @QueryParam("appId") String appId) {
		ObjectUtil.checkInputValue(appId, url);
		sessionService.currentUser(request).put(SessionService.MFOYOU_APPID, appId);
		String ticket = wxBaseService.getJsApiTicket(request, agentId);
		if (StrUtil.isEmpty(ticket)) {
			return JsonRet.buildRet(-1);
		}
		Map<String, String> map = Sign.sign(ticket, url);
		// map.put("appId", sessionService.currentAppConfig(request,
		// ConfigService.WX_APPID));
		return JsonRet.buildSuccRet(map);

	}

	@GET
	@Path(value = "wxShareSigen")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> wxShareSigenold(@Context HttpServletRequest request, @QueryParam("url") String url,
			@QueryParam("appId") String appId) {

		// map.put("appId", sessionService.currentAppConfig(request,
		// ConfigService.WX_APPID));
		return JsonRet.buildSuccRet(0);
	}

	@GET
	@Path(value = "wxToken")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> wxToken(@Context HttpServletRequest request, @QueryParam("appId") Integer appId,
			@QueryParam("agentId") Integer agentId) {
		HuawuAgentWxInfo wxInfo = wxBaseService.getWxInfo(agentId, appId);
		if (wxInfo == null) {
			return JsonRet.buildRet(-1);
		}
		return JsonRet.buildSuccRet(wxBaseService.getToken(request, true, wxInfo));
	}

	@GET
	@Path(value = "provinceList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> provinceList(@Context HttpServletRequest request) {
		return JsonRet.buildSuccRet(iCommon.provinceList());
	}

	@GET
	@Path(value = "cityList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> cityList(@Context HttpServletRequest request, @QueryParam("province") String province,
			@QueryParam("provinceId") Integer provinceId) {
		if (provinceId != null) {
			return JsonRet.buildSuccRet(iCommon.cityList(provinceId));
		}
		return JsonRet.buildSuccRet(iCommon.cityListEx(province));
	}

	@GET
	@Path(value = "countyList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> countyList(@Context HttpServletRequest request, @QueryParam("city") String city,
			@QueryParam("cityId") Integer cityId) {
		if (cityId != null) {
			return JsonRet.buildSuccRet(iCommon.countyList(cityId));
		}
		return JsonRet.buildSuccRet(iCommon.countyListEx(city));
	}

	@GET
	@Path(value = "allCityList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> allcityList(@Context HttpServletRequest request) {
		return JsonRet.buildSuccRet(iCommon.allCityList());
	}

	@GET
	@Path(value = "allCityByPY")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> allCityByPY(@Context HttpServletRequest request) {
		List<MfoyouGdCity> list = iCommon.allCityList();
		List<Map<String, Object>> rList = new ArrayList<>();
		String laString = "";
		List<MfoyouGdCity> laList = null;
		for (MfoyouGdCity mfoyouGdCity : list) {
			if (!laString.equals(mfoyouGdCity.getCityPy())) {
				Map<String, Object> map = new HashMap<>();
				laString = mfoyouGdCity.getCityPy();
				map.put("code", mfoyouGdCity.getCityPy());
				laList = new ArrayList<>();
				map.put("list", laList);
				rList.add(map);
			}
			laList.add(mfoyouGdCity);
		}
		return JsonRet.buildSuccRet(rList);
	}
}
