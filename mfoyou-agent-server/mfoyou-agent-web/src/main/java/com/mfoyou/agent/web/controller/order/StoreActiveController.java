package com.mfoyou.agent.web.controller.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.json.Json2Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.StoreActiveService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.utils.common.StoreActiveInfo;

@Path("store/active")
@Service
public class StoreActiveController {
    
    @Autowired
    private StoreActiveService storeActiveService;
    @Autowired
    private SessionService sessionService;
    
    @GET
    @Path(value = "/info/{storeId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({ UserRight.ALLACCESS})
    public JsonRet<?> runerInfo(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("storeId") Integer storeId) {
        if (storeId == null)
            return JsonRet.buildRet(-96);
        return JsonRet.buildRet(0, storeActiveService.getStoreActive(storeId));
    }
    @GET
    @Path(value = "/myInfo/get")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({ UserRight.STOREACCESS})
    public JsonRet<?> myActiveInfo(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        return JsonRet.buildRet(0, storeActiveService.getStoreActive(sessionService.currentUserId(request)));
    }
    @POST
    @Path(value = "/myInfo/mdf")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({ UserRight.STOREACCESS})
    public JsonRet<?> mdfMyActiveInfo(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
        StoreActiveInfo storeActiveInfo = Json2Object.json2Object(json, StoreActiveInfo.class);
        storeActiveInfo.setStoreId(sessionService.currentUserId(request));
        return JsonRet.buildRet(0, storeActiveService.mdfStoreActive(storeActiveInfo));
    }
    
}
