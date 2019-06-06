package com.mfoyou.agent.web.service.wx;

import java.net.SocketTimeoutException;
import java.util.HashMap;

import org.apache.http.conn.ConnectTimeoutException;
import org.mfoyou.agent.utils.common.HttpsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.boyuanitsm.pay.alipay.util.httpClient.HttpRequest;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
@Service
public class PayService {
//	public static final String ShopCode = "812400205000001";
//	public static final String terminal_id = "30051623";
//	public static final String token = "fafeac8d61064ab79d1310cc14c4e5ae";
//	public static final String request_base_url = "http://test.lcsw.cn:8022/lcsw";
//	public static final String doc_url = "http://www.lcsw.cn/doc/index.html";
	
	public HashMap<Integer, HttpRequest> hashMap = new HashMap<>();
	public static final String payurl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	public static final String revokeUrl = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	Logger logger = LoggerFactory.getLogger(PayService.class);
	public String post(Object object) throws ConnectTimeoutException, SocketTimeoutException, Exception{
		return HttpsUtils.postXml(payurl, obj2xml(object));
	}
	public String obj2xml(Object object){
		XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        //将要提交给API的数据对象转换成XML格式数据Post给API
        String postDataXML = xStreamForRequestPostData.toXML(object);
		return postDataXML;
	}
	
//	public Boolean refundPay(Integer storeId,Integer payAppId,  String payNumber, Integer payAmount) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException, AesException {
//		MfoyouXingXcx xcxInfoByStoreId = iXingStatff.getXcxInfoByStoreId(storeId);
//		WxRefundData wxRefundData = new WxRefundData(xcxInfoByStoreId.getXcxMchid(),
//				xcxInfoByStoreId.getXcxAppid(), payNumber, 
//				payNumber, payAmount, payAmount, xcxInfoByStoreId.getXcxSecrte());
//		String sendPost = sendPost(wxRefundData,storeId);
//		logger.info(sendPost);
//		return XMLParse.getPreId(sendPost, "result_code").equals("SUCCESS");
//	}
	
}
