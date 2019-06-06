package com.mfoyou.agent.web.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.common.inf.IStatistics;
import org.mfoyou.agent.utils.common.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.session.SessionService;

@Path("statistics")
@Service
public class StatisticsController {

    @Autowired
    IStatistics    iStatistics;
    @Autowired
    SessionService sessionService;

    @GET
    @Path(value = "noSettlement")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({ UserRight.AGENTACCESS, UserRight.RUNERACCESS })
    public JsonRet<?> citySearch(@Context HttpServletRequest request) {
        Integer type = sessionService.currentUserType(request);
        if (type.equals(UserRight.AGENTACCESS.getValue())) {
            return JsonRet.buildRet(0, iStatistics.getAgentNoSettlement(sessionService.currentUserId(request)));

        }
        if (type.equals(UserRight.RUNERACCESS.getValue())) {
            return JsonRet.buildRet(0, iStatistics.getRunerNoSettlement(sessionService.currentUserId(request)));

        }
        return JsonRet.buildRet(-1);
    }

}
