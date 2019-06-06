package com.mfoyou.agent.web.controller.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.common.dao.domain.HuawuAddress;
import org.mfoyou.agent.common.inf.ICommon;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.json.Json2Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.session.SessionService;


@Path("user/address")
@Service
public class UserAdressController {

	@Autowired
	private SessionService sessionService;
	@Autowired
	ICommon iCommon;

	@POST
	@Path(value = "/add")
	@Produces("application/json;charset=UTF-8") 
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<?> addAddress(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		HuawuAddress mfoyouAddress = Json2Object.json2Object(json, HuawuAddress.class);
		if (mfoyouAddress == null)
			JsonRet.buildRet(-99);
		mfoyouAddress.setUserId(sessionService.currentUserId(request));
		int addrId = iCommon.addMfoyouAddress(mfoyouAddress);
		if (addrId == 1) {
			return JsonRet.buildSuccRet(addrId);
		} else {
			return JsonRet.buildFailRet("最多20个地址");
		}
	}

	@POST
	@Path(value = "/modify")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<?> modifyAddress(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		HuawuAddress mfoyouAddress = Json2Object.json2Object(json, HuawuAddress.class);
		if (mfoyouAddress == null)
			JsonRet.buildRet(-99);
		mfoyouAddress.setUserId(sessionService.currentUserId(request));
		Boolean bRet = iCommon.modifyMfoyouAddress(mfoyouAddress);
		if (bRet != null && bRet) {
			return JsonRet.buildSuccRet(null);
		} else {
			return JsonRet.buildFailRet("添加失败");
		}
	}

	@GET
	@Path(value = "/single/{userId}/{addressId}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<?> singleAddress(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("addressId") Integer addressId, @PathParam("userId") Integer userId) {
		if (userId == null) {
			userId = sessionService.currentUserId(request);
		}
		List<HuawuAddress> lRet = iCommon.getUserMfoyouAddress(userId, addressId);
		if (lRet != null && lRet.size() >= 1) {
			return JsonRet.buildSuccRet(lRet.get(0));
		} else {
			return JsonRet.buildRet(-98);
		}

	}

	@GET	
	@Path(value = "/list")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<?> listAddress(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		List<HuawuAddress> lRet = iCommon.getUserMfoyouAddress(sessionService.currentUserId(request), null);
		return JsonRet.buildSuccRet(lRet);
	}
	
}
