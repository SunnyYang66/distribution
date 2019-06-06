package com.mfoyou.agent.web.controller.common;

import java.io.IOException;

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
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.utils.common.VarifyCode;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Path("varify")
@Service
public class VarifyController {
	
	@Autowired
	RedisCacheManger redisCacheManger;
	@GET
    @Path(value = "getVarifyCode")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public void getVarifyCode(@Context HttpServletRequest request,@Context HttpServletResponse response) throws IOException {
		VarifyCode varifyCode = new VarifyCode();
        redisCacheManger.setValue("varifyCode:"+SessionService.getSeesionId(request), varifyCode.getCode(), 3*60);
        varifyCode.write(response.getOutputStream());
    }
	@GET
    @Path(value = "checkVarifyCode")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> checkVarifyCode(@Context HttpServletRequest request,@Context HttpServletResponse response,@QueryParam("code")String code) throws IOException {
        String value = redisCacheManger.getValue("varifyCode:"+SessionService.getSeesionId(request));
        if(value.equals(code)){
        	return JsonRet.buildRet(0);
       }
       return JsonRet.buildRet(-1444);
    }
}
