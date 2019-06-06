package com.boyuanitsm.pay.wxpay.business;

import com.boyuanitsm.pay.wxpay.common.XMLParser;
import com.boyuanitsm.pay.wxpay.protocol.unified_order_protocol.UnifiedOrderResData;
import com.alibaba.fastjson.JSON;
import com.boyuanitsm.pay.wxpay.common.Configure;
import com.boyuanitsm.pay.wxpay.common.Signature;
import com.boyuanitsm.pay.wxpay.protocol.unified_order_protocol.UnifiedOrderReqData;
import com.boyuanitsm.pay.wxpay.service.BaseService;
import org.mfoyou.agent.utils.common.Logger;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

/**
 * 统一下单. 应用场景: 除被扫支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易回话标识后再按扫码、JSAPI、APP等不同场景生成交易串调起支付。
 * 接口链接: URL地址：https://api.mch.weixin.qq.com/pay/unifiedorder
 *
 * @see <a href="https://api.mch.weixin.qq.com/pay/unifiedorder">https://api.mch.weixin.qq.com/pay/unifiedorder</a>
 * @author hookszhang on 7/8/16.
 */
public class UnifiedOrderBusiness extends BaseService{

    private static Logger logger = Logger.getLogger(UnifiedOrderBusiness.class);
    public UnifiedOrderBusiness() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        super(Configure.UNIFIFED_ORDER_API);
    }

    public UnifiedOrderResData run(UnifiedOrderReqData unifiedOrderReqData) throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException, ParserConfigurationException, SAXException {
        logger.info(JSON.toJSONString(unifiedOrderReqData));
    	String responseString = sendPost(unifiedOrderReqData);
        logger.info(responseString);
        boolean isSignValid = Signature.checkIsSignValidFromResponseString(responseString);
        if (!isSignValid) {
            throw new RuntimeException(String.format("验证签名失败! api: %s, response: %s", Configure.UNIFIFED_ORDER_API, responseString));
        }
        UnifiedOrderResData unifiedOrderResData = (UnifiedOrderResData) XMLParser.getObjectFromXML(responseString, UnifiedOrderResData.class);
        return unifiedOrderResData;
    }
}
