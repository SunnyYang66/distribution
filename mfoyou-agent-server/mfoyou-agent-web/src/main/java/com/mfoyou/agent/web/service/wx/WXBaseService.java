package com.mfoyou.agent.web.service.wx;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mfoyou.agent.common.dao.domain.HuawuAgentWxInfo;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.ICommon;
import org.mfoyou.agent.utils.common.HttpsUtils;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.StrUtil;
import org.mfoyou.agent.utils.wx.XMLParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;
import com.mfoyou.agent.web.utils.wx.HttpRequest;
import com.mfoyou.agent.web.utils.wx.WxRefundData;


@Service
public class WXBaseService {

    private static Logger        logger           = Logger.getLogger(WXBaseService.class);
    @Autowired
    private RedisCacheManger     redisCacheManger;
    @Autowired
    private SessionService       sessionService;
    @Autowired
    IAccount iAccount;
    @Autowired
    ICommon iCommon;
//    @Value("#{settings['sys.debug']?:false}")
    private Boolean             isDebug = false;


    private static String        wxTokencachePrex = "wx:token:";
    private static String        wxTokencachePrexV1 = "wx:tokenV1:";
    public static final String revokeUrl = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    /**
     * 普通的小程序获取openId
     * @param request  
     * @param code   
     * @param type  100为小程序端    其他为微信端
     * @param agentId 
     * @return
     */
    public String code2OpenId(String code,HuawuAgentWxInfo huawuAgentWxInfo) {
    	//假如是小程序
    	String url = null;
    	if(huawuAgentWxInfo.getXcxType()!=200){
    		 url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + huawuAgentWxInfo.getXcxId() + "&secret="
                     + huawuAgentWxInfo.getXcxSecret() + "&js_code=" + code + "&grant_type=authorization_code";
    	}else {//公众号
    		url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + huawuAgentWxInfo.getXcxId() + "&secret="
                    + huawuAgentWxInfo.getXcxSecret() + "&code=" + code + "&grant_type=authorization_code";
		}
        String response = HttpsUtils.get(url);
        if (response == null)
            return null;
        logger.info(url + "\n" + response);
        JSONObject object = JSON.parseObject(response);
        String token = object.getString("access_token");
        String openId = object.getString("openid");
        logger.info("openid:"+openId);
        if (token != null && huawuAgentWxInfo.getXcxType()!= 100) {
            redisCacheManger.setValue(wxTokencachePrexV1 + openId, token, 7000);
        }
        return openId;
    }
    /**
     * 第三方平台获取openid
     * @param code
     * @param huawuAgentWxInfo
     * @return
     * @throws Exception
     */
	public String code2OpenIdV2(String code,HuawuAgentWxInfo huawuAgentWxInfo) {
		String url = "https://api.weixin.qq.com/sns/component/jscode2session?appid="
				+huawuAgentWxInfo.getXcxId()+"&js_code="+code+"&grant_type=authorization_code&component_appid=wx9a3e802adcc32457&component_access_token="
						+ getTokenV2(true);
		String response = HttpsUtils.get(url);
		if (response == null)
			return null;
		logger.info(url + "\n" + response);
		JSONObject object = JSON.parseObject(response);
		String openId = object.getString("openid");
//		String sessionKey = object.getString("session_key");
//		String[] strings= {openId,sessionKey};
		return openId;
	}
	/**
	 * 获取第三方 token
	 * @param retry
	 * @return
	 * @throws Exception
	 */
	public String getTokenV2(boolean retry){
		String tokenUrl = "http://api.mfoyou.com/xmd/wechat/getToken";
        String response = HttpsUtils.get(tokenUrl);
        JSONObject object = JSON.parseObject(response);
        String token = object.getString("data");
        if(token==null && retry){
        	return getTokenV2(false);
        }
        return token;
	}
        
	/**
	 * 非第三方平台获取token
	 * @param request
	 * @param breTry
	 * @param wxInfo
	 * @return
	 */
	public String getToken(HttpServletRequest request, Boolean breTry, HuawuAgentWxInfo wxInfo) {
        String appid = wxInfo.getXcxId();
        String secret = wxInfo.getXcxSecret();
        String token = redisCacheManger.getValue(wxTokencachePrex + appid);
        logger.info("appid="+appid+";secret="+secret+";token="+token);
        if(isDebug){ //暂时没用
            if (token == null || token.equals("")) {
                String tokenUrl = "http://api.mfoyou.cn/common/wxToken?token=111111asdwasd&appId="+appid;
                String response = HttpsUtils.get(tokenUrl);
                if (response == null || response.equals("")) {
                    return null;
                }
                JSONObject object = JSON.parseObject(response);
                token = object.getString("data");
                if (token != null) {
                    redisCacheManger.setValue(wxTokencachePrex + appid, token, 70);
                }else{
                	isDebug=true;
                	token=getToken(request,false,wxInfo);
                	isDebug=false;
                }
            } 
        } else  if (token == null || token.equals("")) {
            String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret;
            String response = HttpsUtils.get(tokenUrl);
            if (response == null || response.equals("")) {
                if (breTry)
                    return getToken(request, false,wxInfo);
                return null;
            }
            JSONObject object = JSON.parseObject(response);
            token = object.getString("access_token");
            if (token != null) {
                redisCacheManger.setValue(wxTokencachePrex + appid, token, 7000);
            }
        } else {
            //redisCacheManger.setExpire(wxTokencachePrex + appid, 7000);
        }
        return token;

    }
	/**
	 * 公众号获取用户信息 
	 * @param openId  
	 * @param breTry 是否从事
	 * @param appId 
	 * @return
	 */
    public String getUserInfo(String openId, Boolean breTry, Integer appId) {
    	String token = redisCacheManger.getValue(wxTokencachePrexV1 + openId);
        String userUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token + 
        		"&openid=" + openId+"&lang=zh_CN";
        String response = HttpsUtils.get(userUrl);
        if (response == null || response.equals("")) {
            if (breTry)
                return getUserInfo(openId, false,appId);
            return null;
        }
        return response;
    }
    /**
     * 获取wxinfo 根据agentId  和appid
     * @param agentId
     * @param appid
     * @return
     */
   public HuawuAgentWxInfo getWxInfo(Integer agentId,Integer appid){
	   String value = redisCacheManger.getValue("agent:wxinfo:"+agentId+":"+appid);
	   if(value!=null && !value.equals("")){
		   return JSON.parseObject(value, HuawuAgentWxInfo.class);
	   }
	   HuawuAgentWxInfo huawuWxInfo = iCommon.getHuawuWxInfo(agentId,appid);
	   if(huawuWxInfo==null){
		   return null;
	   }
	   redisCacheManger.setValue("agent:wxinfo:"+agentId+":"+appid, JSON.toJSONString(huawuWxInfo), 60);
	   return huawuWxInfo;
   }
   /**
    * 微信分享token
    * @param request
    * @param agentId
    * @return
    */
    public String getJsApiTicket(HttpServletRequest request,Integer agentId) {
        String jsApiTicket = null;
        HuawuAgentWxInfo wxInfo = getWxInfo(agentId,sessionService.currentAppId(request));
        if(wxInfo==null){
        	return null;
        }
        try {
            jsApiTicket = redisCacheManger.getValue("jsapi_ticket:" + wxInfo.getXcxId());
            if (!StrUtil.isEmpty(jsApiTicket)) {
                return jsApiTicket;
            }
            String ticketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
            String access_token = getToken(request, true,wxInfo);
            StringBuilder sb = new StringBuilder();
            sb.append(ticketUrl);
            sb.append("?access_token=");
            sb.append(access_token);
            sb.append("&type=jsapi");
            String returnVal = HttpsUtils.get(sb.toString());
            if (!StrUtil.isEmpty(returnVal)) {
                Map<String, Object> result = JSON.parseObject(returnVal);
                jsApiTicket = (String) result.get("ticket");
                if(jsApiTicket == null)return null;
                redisCacheManger.setValue("jsapi_ticket:" + wxInfo.getXcxId(), jsApiTicket, 7000);
                return jsApiTicket;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 发送post
     * @param xmlObj
     * @param wxInfo
     * @return
     * @throws UnrecoverableKeyException
     * @throws KeyManagementException
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    private String sendPost(Object xmlObj,HuawuAgentWxInfo wxInfo) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{
    	HttpRequest	httpRequest=new HttpRequest(wxInfo.getXcxPayRediPath(),wxInfo.getXcxMchid());
		String responseString = httpRequest.sendPost(revokeUrl, xmlObj);
		logger.info(responseString);
		return responseString;
	}
    /**
     * 撤销支付
     * @param agentId
     * @param payAppId
     * @param payNumber
     * @param payAmount
     * @return
     */
	public Boolean refundPay(Integer agentId,Integer payAppId,  String payNumber, Integer payAmount){
		HuawuAgentWxInfo wxInfo = getWxInfo(agentId, payAppId);
		WxRefundData wxRefundData = new WxRefundData(wxInfo.getXcxMchid(),
				wxInfo.getXcxId(), payNumber, 
				payNumber, payAmount, payAmount, wxInfo.getXcxPaySecret());
		boolean equals=false;
		try {
			String sendPost = sendPost(wxRefundData,wxInfo);
			logger.info(sendPost);
			equals= XMLParse.getPreId(sendPost, "result_code").equals("SUCCESS");
		} catch (Exception e) {
			logger.error("撤单遇见问题了。", e);
		}
		return equals;
	} 
}

