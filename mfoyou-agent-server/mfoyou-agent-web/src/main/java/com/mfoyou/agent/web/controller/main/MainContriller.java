package com.mfoyou.agent.web.controller.main;

import java.net.SocketTimeoutException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.apache.http.conn.ConnectTimeoutException;
import org.mfoyou.agent.utils.common.HttpsUtils;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.AgentService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.thirdPart.AmapService;
import com.mfoyou.agent.web.service.wx.WXBaseService;
import com.mfoyou.agent.web.utils.network.WebUtils;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;


@Path("/")
@Service
public class MainContriller {

    Logger           logger = Logger.getLogger(MainContriller.class);

    @Autowired
    SessionService   sessionService;
//    @Autowired
//    AccountSvc       accountSvc;
    @Autowired
    WXBaseService    wXBaseService;
    @Autowired
    AmapService      amapService;
    @Autowired
    AgentService     agentService;
    @Autowired
    RedisCacheManger redisCacheManger;

    /**
     * 跨域请求发送options请求时候进行处理
     *
     * @param requestMethods
     * @param requestHeaders
     * @return
     * @throws Exception
     */
    /* @OPTIONS
    @Path("/{path:*}")
    public Response handleCORSRequest(@HeaderParam("Access-Control-Request-Method") final String requestMethods,
            @HeaderParam("Access-Control-Request-Headers") final String requestHeaders) throws Exception {
        Response.ResponseBuilder builder = Response.ok();
        if (requestHeaders != null)
            builder.header("Access-Control-Allow-Headers", requestHeaders);
        if (requestMethods != null)
            builder.header("Access-Control-Allow-Methods", requestMethods);
        return builder.build();
    }*/

    @GET
    @Path(value = "")
    @Produces("text/html;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public String getFileInfo(@Context HttpServletRequest request) {
        return "<div style=' text-align:center;'>Welcome to mfoyou</div><br/><div style=' text-align:center;'> you ip is :" + WebUtils.getIpAddr(request) + "</div>";
    }

    @GET
    @Path(value = "token")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> getToken(@Context HttpServletRequest request) {
        String token =SessionService.getSeesionId(request);
        return JsonRet.buildSuccRet(token);
    }

    @GET
    @Path(value = "test/token")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> testToken(@Context HttpServletRequest request, @QueryParam("lon") Double lon, @QueryParam("lat") Double lat) {
        Integer userId = sessionService.currentUserId(request);
        if (userId == null) {
            return JsonRet.buildSuccRet(-1);
        } else {
            return JsonRet.buildSuccRet(0);
        }
    }

    @GET
    @Path(value = "test/info/{id}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> testToken(@Context HttpServletRequest request, @PathParam("id") Integer id) {
        /*
         * if(id == 1){ String appId = "wxae454ad3c48e6e1b"; String secret =
         * "793c4b0f60d786367a8d8093e3734aac"; String openId =
         * "odUThwr9fHYcjrKOXakqdc8H5lAs"; return
         * JsonRet.buildSuccRet(wXBaseService.getToken(appId, secret, true)); }
         * if(id == 2){ String appId = "wxae454ad3c48e6e1b"; String secret =
         * "793c4b0f60d786367a8d8093e3734aac"; String openId =
         * "odUThwr9fHYcjrKOXakqdc8H5lAs"; String aString =
         * wXBaseService.getUserInfo(wXBaseService.getToken(appId, secret,
         * true), openId, true); return
         * JsonRet.buildSuccRet(JSON.parseObject(aString));
         * 
         * }
         */
        return JsonRet.buildSuccRet(null);
    }

//    @GET
//    @Path(value = "test/area")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.ALLACCESS)
//    public JsonRet<?> testArea(@Context HttpServletRequest request) {
//        PolygonArea polygonArea = new PolygonArea();
//        List<Point2D.Double> list = new ArrayList<Point2D.Double>();
//        list.add(new Point2D.Double(1, 2));
//        list.add(new Point2D.Double(1.111111111111111111, 2.222222222222));
//        list.add(new Point2D.Double(5, 6));
//        polygonArea.setPointCount(list.size());
//        polygonArea.setListPoint(list);
//        String a1 = JSON.toJSONString(polygonArea);
//        logger.info(a1);
//        PolygonArea polygonArea2 = JSON.parseObject(a1, PolygonArea.class);
//
//        MfoyouRegionEx mfoyouRegion = new MfoyouRegionEx();
//        mfoyouRegion.setPolygonArea(polygonArea2);
//        mfoyouRegion.setAgentId(1);
//        mfoyouRegion.setRegionCustomId(22);
//        mfoyouRegion.setRegionCustomCreateTime(new Date());
//        mfoyouRegion.setRegionCustomLat(11.0);
//        mfoyouRegion.setRegionCustomLon(22.0);
//        mfoyouRegion.setRegionCustomModfiyTime(new Date());
//        mfoyouRegion.setRegionCustomName("无敌团队");
//        mfoyouRegion.setRegionCustomValid(1);
//        String ab = JSON.toJSONString(mfoyouRegion);
//        logger.info(ab);
//        MfoyouRegionEx mfoyouRegion1 = JSON.parseObject(ab, MfoyouRegionEx.class);
//        MfoyouRegionCustom mfoyouRegionCustom = new MfoyouRegionCustom();
//        ReflectUtil.ObjectCopy(mfoyouRegion1, mfoyouRegionCustom);
//        ReflectUtil.ObjectCopy(mfoyouRegionCustom, mfoyouRegion1);
//        List<MfoyouRegionEx> list2 = new ArrayList<>();
//        list2.add(mfoyouRegion);
//        list2.add(mfoyouRegion1);
//        return JsonRet.buildSuccRet(ListObject.BulidListObject(list2));
//    }
//
//    @GET
//    @Path(value = "test/gd")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.ALLACCESS)
//    public JsonRet<?> testGD(@Context HttpServletRequest request, @QueryParam("lat") Double lat, @QueryParam("lon") Double lon) {
//
//        return JsonRet.buildSuccRet(amapService.getCityCode(lat, lon));
//    }
//
//    @GET
//    @Path(value = "test/gdd")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.ALLACCESS)
//    public JsonRet<?> testGDD(@Context HttpServletRequest request, @QueryParam("lat1") Double lat1, @QueryParam("lon1") Double lon1, @QueryParam("lat2") Double lat2, @QueryParam("lon2") Double lon2) {
//
//        return JsonRet.buildSuccRet(amapService.getDistance(lat1, lon1, lat2, lon2));
//    }

    @GET
    @Path(value = "test/gdd1")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> testhmd(@Context HttpServletRequest request) throws ConnectTimeoutException, SocketTimeoutException, Exception {

        return JsonRet.buildSuccRet(
            HttpsUtils.post("https://datasub.bbdservice.com/api/bbd_sub/uploadJSON", "[{\"companyName\":\"万科企业股份有限公司\"},{\"companyName\":\"中国农业银行股份有限公司\"}]", "application/json", "utf-8", 100, 100));
    }

    /*
     * @GET
     * 
     * @Path(value = "wechat/token")
     * 
     * @Produces("text/html;charset=UTF-8")
     * 
     * @UrlRight(UserRight.ALLACCESS) public String doGet(@Context
     * HttpServletRequest request,@Context HttpServletResponse response) throws
     * ServletException, IOException { // 微信加密签名 String signature =
     * request.getParameter("signature"); // 随机字符串 String echostr =
     * request.getParameter("echostr"); // 时间戳 String timestamp =
     * request.getParameter("timestamp"); // 随机数 String nonce =
     * request.getParameter("nonce");
     * 
     * if(checkSignature(signature, timestamp, nonce)){ return echostr; } return
     * ""; String[] str = { "123456", timestamp, nonce }; Arrays.sort(str); //
     * 字典序排序 String bigStr = str[0] + str[1] + str[2]; // SHA1加密 String digest =
     * new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
     * 
     * // 确认请求来至微信 if (digest.equals(signature)) {
     * response.getWriter().print(echostr); } } public static boolean
     * checkSignature(String signature, String timestamp, String nonce) {
     * String[] arr = new String[] { "123456", timestamp, nonce }; //
     * 将token、timestamp、nonce三个参数进行字典序排序 Arrays.sort(arr); StringBuilder content
     * = new StringBuilder(); for (int i = 0; i < arr.length; i++) {
     * content.append(arr[i]); } MessageDigest md = null; String tmpStr = null;
     * 
     * try { md = MessageDigest.getInstance("SHA-1"); //
     * 将三个参数字符串拼接成一个字符串进行sha1加密 byte[] digest =
     * md.digest(content.toString().getBytes()); tmpStr = byteToStr(digest); }
     * catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
     * 
     * content = null; // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信 return tmpStr !=
     * null ? tmpStr.equals(signature.toUpperCase()) : false; }
     * 
     *//**
        * 将字节数组转换为十六进制字符串
        * 
        * @param byteArray
        * @return
        */
    /*
     * private static String byteToStr(byte[] byteArray) { String strDigest =
     * ""; for (int i = 0; i < byteArray.length; i++) { strDigest +=
     * byteToHexStr(byteArray[i]); } return strDigest; }
     * 
     *//**
        * 将字节转换为十六进制字符串
        * 
        * @param mByte
        * @return
        *//*
          * private static String byteToHexStr(byte mByte) { char[] Digit = {
          * '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
          * 'E', 'F' }; char[] tempArr = new char[2]; tempArr[0] = Digit[(mByte
          * >>> 4) & 0X0F]; tempArr[1] = Digit[mByte & 0X0F];
          * 
          * String s = new String(tempArr); return s; }
          */

}
