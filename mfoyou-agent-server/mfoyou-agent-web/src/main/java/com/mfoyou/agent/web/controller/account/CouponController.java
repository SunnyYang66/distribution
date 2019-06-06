package com.mfoyou.agent.web.controller.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCoupon;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.ListObject;
import org.mfoyou.agent.utils.common.MfoyouEncrypt;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.json.Json2Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.StoreService;
import com.mfoyou.agent.web.service.order.PaymentService;
import com.mfoyou.agent.web.service.session.SessionService;


@Path("/coupon")
@Service
public class CouponController {
	
	@Autowired
	StoreService storeService;
	@Autowired
	SessionService sessionService;
	@Autowired
	PaymentService paymentService;
	@GET
	@Path(value = "getlist")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS})
	public JsonRet<?> getList(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("pageId") Integer pageid, @QueryParam("pageSize") Integer pagesize,
			@QueryParam("state")Integer state){
		Integer agentId = sessionService.currentUserId(request);
		ArrayListObject<MfoyouAgentStoreCoupon> coupons = storeService.getAgentCouponList(agentId,state,pageid,pagesize);
		return JsonRet.buildSuccRet(ListObject.BulidListObject(coupons));
	}
	@POST
	@Path(value = "addCoupon")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS})
	public JsonRet<?> addCoupon(@Context HttpServletRequest request, String json){
		Integer agentId = sessionService.currentUserId(request);
		MfoyouAgentStoreCoupon mfoyouAgentStoreCoupon = JSON.parseObject(json, MfoyouAgentStoreCoupon.class);
		mfoyouAgentStoreCoupon.setAgentId(agentId);
		int addAgentCoupon = storeService.addAgentCoupon(mfoyouAgentStoreCoupon);
		if(addAgentCoupon==-1){
			return JsonRet.buildRet(-1);
		}
		return JsonRet.buildRet(0);
	}
	@GET
	@Path(value = "getSingleCoupon")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS})
	public JsonRet<?> getSingleCoupon(@Context HttpServletRequest request, @QueryParam("couponId")Integer couponId){
		MfoyouAgentStoreCoupon mfoyouAgentStoreCoupon = storeService.getSingleCoupon(couponId);
		return JsonRet.buildSuccRet(mfoyouAgentStoreCoupon);
	}
	@POST
	@Path(value = "mofifyCoupon")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS})
	public JsonRet<?> mofifyCoupon(@Context HttpServletRequest request, String json){
		MfoyouAgentStoreCoupon oldmfoyouAgentStoreCoupon = new MfoyouAgentStoreCoupon();
		Integer agentId = sessionService.currentUserId(request);
		MfoyouMap json2MfoyouMap = Json2Object.json2MfoyouMap(json);
		Integer couponId = json2MfoyouMap.getInteger("couponId");
		if(couponId==null){
			return JsonRet.buildRet(-96);
		}
		oldmfoyouAgentStoreCoupon.setAgentId(agentId);
		oldmfoyouAgentStoreCoupon.setCouponId(couponId);
		MfoyouAgentStoreCoupon newMfoyouXingStoreCoupon = new MfoyouAgentStoreCoupon();
		newMfoyouXingStoreCoupon.setCouponName(json2MfoyouMap.get("couponName"));
		newMfoyouXingStoreCoupon.setCouponCount(json2MfoyouMap.getInteger("couponCount"));
		newMfoyouXingStoreCoupon.setCouponState(json2MfoyouMap.getInteger("couponState"));
		return JsonRet.buildRet(storeService.modifyAgentCoupon(oldmfoyouAgentStoreCoupon,newMfoyouXingStoreCoupon)-1);
	}
	@GET
    @Path(value = "getAgentCouponList")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> getCouponList(@Context HttpServletRequest request, @QueryParam("agentStr")String agentStr) {
    	Integer agentId = MfoyouEncrypt.decode(agentStr);
    	if(agentId==null || agentId<0){
    		return JsonRet.buildRet(0);
    	}
    	Integer userId = sessionService.currentUserId(request);
    	List<MfoyouAgentStoreCoupon> coupons = storeService.getAgentCouponListByUser(agentId,userId);
        return JsonRet.buildSuccRet(coupons);
    }
	 //抢优惠券
    @GET
    @Path(value = "takeCoupon")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> takeCoupon(@Context HttpServletRequest request, @QueryParam("couponIds")Integer[] couponIds) {
    	if(couponIds==null || couponIds.length==0){
    		return JsonRet.buildRet(-96);
    	}
    	Integer userid = sessionService.currentUserId(request);
    	List<Integer> ret = storeService.takeCoupons(couponIds,userid);
        return JsonRet.buildSuccRet(ret);
    }
    //我的优惠券列表
    @GET
    @Path(value = "myCouponList")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> myCouponList(@Context HttpServletRequest request,@QueryParam("state")Integer state,@QueryParam("type")Integer type) {
    	Integer userId = sessionService.currentUserId(request);
    	List<MfoyouAgentStoreCoupon> coupons = storeService.getUserCouponList(userId,state,type);
        return JsonRet.buildSuccRet(coupons);
    }
}
