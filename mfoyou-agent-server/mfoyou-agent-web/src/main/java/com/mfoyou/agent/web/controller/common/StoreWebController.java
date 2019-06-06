package com.mfoyou.agent.web.controller.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.utils.common.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.StoreService;
import com.mfoyou.agent.web.service.order.OrderService;
import com.mfoyou.agent.web.service.session.SessionService;


@Path("store/tongji")
@Service
public class StoreWebController {
	@Autowired
	OrderService orderService;
	@Autowired
	SessionService sessionService;
	@Autowired
	StoreService storeService;
	@GET
	@Path(value = "getTongji")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> getTongji(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer storeid = sessionService.currentUserId(request);
		Map<String, Object> orderTongji = orderService.getOrderTongji(storeid);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		int visitCount = storeService.getVisitCount(storeid, simpleDateFormat.format(new Date()));
		orderTongji.put("visitOrCount", visitCount);
		return JsonRet.buildSuccRet(orderTongji);
	}
	@GET
	@Path(value = "get/statistics")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> statistics(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer storeid = sessionService.currentUserId(request);
		Map<String, Object> orderTongji = orderService.getOrderTongjiV2(storeid);
		//to get staticstics today
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		int visitCount = storeService.getVisitCount(storeid, simpleDateFormat.format(new Date()));
		orderTongji.put("visitOrCount", visitCount);
		int usercount = storeService.getUsercount(storeid, simpleDateFormat.format(new Date()));
		orderTongji.put("userCount", usercount);
		//to  get  statistics yesterday
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		int[] yesvisitCount = storeService.getVisitTorAndUserCount(storeid, simpleDateFormat.format(calendar.getTime()));
		orderTongji.put("yesvisitOrCount", yesvisitCount[0]);
		orderTongji.put("yesuserCount", yesvisitCount[1]);
		return JsonRet.buildSuccRet(orderTongji);
	}
	
	@GET
	@Path(value = "get/data")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> getStatics(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("dataStr")String dateStr) throws ParseException {
		if(dateStr==null){
			return JsonRet.buildRet(-96);
		}
		Integer storeid = sessionService.currentUserId(request);
		//to get staticstics toda
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = simpleDateFormat.parse(dateStr);
		Map<String, Map<String, Object>> dataAnaly = orderService.getDataAnaly(storeid,date);
		int visitCount = storeService.getNewUsercount(storeid, dateStr);
		dataAnaly.get("the_day").put("visitOrCount", visitCount);
		//to  get  statistics yesterday
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		int yesusercount = storeService.getNewUsercount(storeid, simpleDateFormat.format(calendar.getTime()));
		dataAnaly.get("yestheday").put("yesuserCount", yesusercount);
		return JsonRet.buildSuccRet(dataAnaly);
	}
	@GET
	@Path(value = "get/dataV2")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> getStaticsv2(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("startDate")Long startDate,@QueryParam("endDate")Long endDate) throws ParseException {
		if(startDate==null || endDate==null){
			return JsonRet.buildRet(-96);
		}
		Integer storeid = sessionService.currentUserId(request);
		Map<String, Object> dataAnaly = orderService.getDataAnaly(storeid,startDate,endDate);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String start = simpleDateFormat.format(new Date(startDate));
		String end = simpleDateFormat.format(new Date(endDate));
		int count = storeService.getCountVisitUser(start,end,storeid);
		dataAnaly.put("userCount", count);
		return JsonRet.buildSuccRet(dataAnaly);
	}
	
	
}
