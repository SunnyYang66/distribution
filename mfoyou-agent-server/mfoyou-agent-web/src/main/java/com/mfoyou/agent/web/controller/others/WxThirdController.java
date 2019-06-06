package com.mfoyou.agent.web.controller.others;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.common.dao.domain.MfoyouThirdPartAudit;
import org.mfoyou.agent.common.inf.ICommon;
import org.mfoyou.agent.utils.common.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;

@Path("wx")
@Service
public class WxThirdController {
	@Autowired
	ICommon iCommon;
	@GET
	@Path("getWxThirdAudit")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?>  getWxThirdAudit(@Context HttpServletRequest request,@QueryParam("appid")String appid,
			@QueryParam("versionId")String version) throws Exception {
		MfoyouThirdPartAudit mfoyouThirdPartAudit = new MfoyouThirdPartAudit();
		mfoyouThirdPartAudit.setAppid(appid);
		mfoyouThirdPartAudit.setVersionId(version);
		List<MfoyouThirdPartAudit> thirdPart = iCommon.getThirdPartAudit(mfoyouThirdPartAudit);
		return JsonRet.buildSuccRet(thirdPart);
	}
}
