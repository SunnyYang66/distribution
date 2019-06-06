package com.mfoyou.agent.web.controller.sms;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.utils.common.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.sms.SmsService;


@Path("/sms")
@Service
public class SmsController {

	@Autowired
	SmsService smsService;
	@Autowired
	IAccount accountSvc;
	@Autowired
	SessionService sessionService;

	@GET
	@Path(value = "/regist/{phonenumber}/{agentId}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<Map<String, String>> regist(@Context HttpServletRequest request,
			@Context HttpServletResponse response, @PathParam("phonenumber") String phonenumber
			,@PathParam("agentId")Integer agentId) throws Exception {
		HuawuUser mfoyouUser =  accountSvc.getUserInfoByPhone(phonenumber, agentId);
		if(mfoyouUser != null){
			return JsonRet.buildRet(-10);
		}
		int ret = smsService.sendRandSms(request, phonenumber, 1);
		return JsonRet.buildRet(ret, null);
	}

	@GET
	@Path(value = "/test/regist/{phonenumber}/{code}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<Map<String, String>> testRegist(@Context HttpServletRequest request,
			@Context HttpServletResponse response, @PathParam("phonenumber") String phonenumber,
			@PathParam("code") String code) throws Exception {
		int ret = smsService.checkPhoneCode(request, phonenumber, code, 1, false);
		return JsonRet.buildRet(ret);
	}

	@GET
	@Path(value = "/login/{phonenumber}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<Map<String, String>> login(@Context HttpServletRequest request,
			@Context HttpServletResponse response, @PathParam("phonenumber") String phonenumber) throws Exception {
		int ret = smsService.sendRandSms(request, phonenumber, 2);
		return JsonRet.buildRet(ret, null);
	}

	@GET
	@Path(value = "/defautphone")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<Map<String, String>> defautPhone(@Context HttpServletRequest request,
			@Context HttpServletResponse response, @PathParam("phonenumber") String phonenumber) throws Exception {
		int ret = smsService.sendRandSms(request, phonenumber, 3);
		return JsonRet.buildRet(ret, null);
	}
	@GET
	@Path(value = "/newphone/{phonenumber}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<Map<String, String>> newPhone(@Context HttpServletRequest request,
			@Context HttpServletResponse response, @PathParam("phonenumber") String phonenumber) throws Exception {
		int ret = smsService.sendRandSms(request, phonenumber, 4);
		return JsonRet.buildRet(ret, null);
	}
	@GET
	@Path(value = "/test/newphone/{phonenumber}/{code}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<Map<String, String>> testnewPhone(@Context HttpServletRequest request,
			@Context HttpServletResponse response, @PathParam("phonenumber") String phonenumber,
			@PathParam("code") String code) throws Exception {
		int ret = smsService.checkPhoneCode(request, phonenumber, code, 4, false);
		return JsonRet.buildRet(ret);
	}
	@GET
	@Path(value = "/restpassword/{phonenumber}/{agentId}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<Map<String, String>> restpassword(@Context HttpServletRequest request,
			@Context HttpServletResponse response, @PathParam("phonenumber") String phonenumber,
			@PathParam("agentId")Integer agentId) throws Exception {
		if(accountSvc.getUserInfoByPhone(phonenumber, agentId) == null){
			return JsonRet.buildRet(-13);
		}
		int ret = smsService.sendRandSms(request, phonenumber, 5);
		return JsonRet.buildRet(ret, null);
	}
	@GET
	@Path(value = "/test/restpassword/{phonenumber}/{code}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<Map<String, String>> testrestpassword(@Context HttpServletRequest request,
			@Context HttpServletResponse response, @PathParam("phonenumber") String phonenumber,
			@PathParam("code") String code) throws Exception {
		int ret = smsService.checkPhoneCode(request, phonenumber, code, 5, false);
		return JsonRet.buildRet(ret);
	}
	@GET
	@Path(value = "/commoncode")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<Map<String, String>> opCode(@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception {
		String phonenumber = sessionService.currentUserPhone(request);
		int ret = smsService.sendRandSms(request, phonenumber, 10);
		return JsonRet.buildRet(ret);
	}
	@GET
	@Path(value = "/test/commoncode/{code}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<Map<String, String>> testopCode(@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@PathParam("code") String code) throws Exception {
		String phonenumber = sessionService.currentUserPhone(request);
		int ret = smsService.checkPhoneCode(request, phonenumber, code, 10, false);
		return JsonRet.buildRet(ret);
	}
	@GET
	@Path(value = "/xing/regist/{phoneNumber}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<Map<String, String>> xingregistCode(@Context HttpServletRequest request,
			@Context HttpServletResponse response,@PathParam("phoneNumber") String phonenumber) throws Exception {
		int ret = smsService.sendRandSms(request, phonenumber, 8);
		return JsonRet.buildRet(ret);
	}
}
