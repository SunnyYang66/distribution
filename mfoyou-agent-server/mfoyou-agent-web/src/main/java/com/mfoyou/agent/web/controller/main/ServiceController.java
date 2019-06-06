package com.mfoyou.agent.web.controller.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.common.dao.domain.HuawuServiceTag;
import org.mfoyou.agent.common.inf.ICommon;
import org.mfoyou.agent.utils.common.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;


@Path("service")
@Service
public class ServiceController {
	@Autowired
    ICommon iCommon;
    @GET
    @Path(value = "/get/allprefabtag/{tagTpyeId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({UserRight.AGENTACCESS,UserRight.ALLACCESS})
    public JsonRet<?> getallprefabtag(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("tagTpyeId") Integer tagTpyeId) {
    	List<HuawuServiceTag> mfoyouServiceTags = iCommon.getServiceTags(tagTpyeId);
       return JsonRet.buildSuccRet(mfoyouServiceTags);
    }
}
