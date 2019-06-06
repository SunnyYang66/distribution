package com.mfoyou.agent.web.service.thirdPart;

import org.mfoyou.agent.common.dao.domain.HuawuAlipay;
import org.mfoyou.agent.common.inf.IThirdPartInfo;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.common.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.mfoyou.agent.web.service.order.OrderService;
import com.mfoyou.agent.web.service.order.PaymentService;

@Service
public class AliPayService {
    private static String getWay     = "https://openapi.alipay.com/gateway.do";
    private static Logger logger     = Logger.getLogger(Logger.class);

    @Autowired
    PaymentService        paymentService;
    @Autowired
    OrderService          orderService;
    @Autowired
    IThirdPartInfo 		  iThirdPartInfo;
    @Value("#{settings['alipay_notifyUrl']}")
    private String        alipay_notifyUrl;

    public JsonRet<String> extract(int extractId, Integer amount, String name, String account,Integer agentId) {
    	HuawuAlipay huawuAlipay = iThirdPartInfo.getAliPayByAgentId(agentId);
//    	String appId = "2018071260595100";
//    	String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC3Q+ibUi9P+VmCrL8z89ccfDft7NxcJLy+i7wtf3jPYvdMIfULwyEiEzi7eBX7aV5yH+xN/6GG9pzxXBCcd5JE7A+eMb/d8eRkN1TkqEOrtc2P3SSch6/UH1VS3n84IHoniAtKTvSQTohygL0v/Ut00deh++MbFhTIYFpKaoIzEodhaOsFVdrNTshgYbUgeRRqAnjLyS8xB+4Mkeyi2pQEKyqZAWY374p5k2/ProTyALdvMVOTdyDikTl0yyt1HXtXycArd2Y9cAwMFXa/KvAuc4MgZnC/FqM3DbNqLIMGzGPK2p793bq2UXp6klP7SQIy68i1CVNZVruEUIAHsxcFAgMBAAECggEAcRcs4Tw0Cgv7WpIzY2HjqqZU9TOnQA1Dk+oy83ioGoIdzRNfXiTJu3dVGQqftgdtyss8TV2kVd61NpPzhDqdPn7VnG9i0RlGMTmb34aeS8Xi1hZHU3i/3gx/4KWAqCgSeXaQUQisDqkHtnEPTh/mgm5DvKftm3di18vtq+JR+iU0XE4ddZIa/Pd5mUUloBjvlkT3Udfysc4SENMRz76IMujLhaMxTNIuVZ2G/6Ayb5+8/5rozNwFFuJ8WpYZ/kuo//DgWbDZPFQ8vh5kPIf/hH8lghOZ33cyotWwoQK/cHIm6QayaklgOrcLjbs2H2IwRpSvS7n4Tg9HOVuKpfllQQKBgQD9V12l8/ad3GwzgQQJ7rDOmdd1AaC7qX52B5PV3HXAoo6z4D9/aQzpYcVq0hc80VODC36gor6GflrgHkiL9e7leAZW8H1gsKCGmX+SVTr9q9zVCXd6j12vJgZpI1dyrTe0C8xX1BTlh4zRsFM1bHOaNwcZdsBTcx6hYnjTqTRpGQKBgQC5MEZHsMP4kdFCSTMcySSa1+zX98onyRyKxq9aC64w/l//EXzSdpjTgb7Sz7DEIm9rXSDGqo25QEXgBaJ1o9XN+Tk8oA9cWlnNA08EyuML3XvkJzUS2tRmXJt0avFed8caZnZ8oh7A7QqhSlLyLjWwPjNrJFloKvDbBH3TEvoezQKBgCnGmVu/UiCP84u+r6LPqHo5Ji1WOmIXvhHKiBdRBl3gsHV6+h2Rfh6SD9LgmBJgVkwaviPREmftOCES/VWPFXjjhPAbMiGanq3za/T+dv7Ts1Ox/vDH6WPzekUmHcp8Q949v9GP2G5NHuyJDf+WRa3dex841Ngt+JQWP+RvV4QpAoGAaKONYp7P7Nk/+4tu9Rn2tAPEETgzIw3xMb0YgfHNqGNjjLWt6SIYMpLCZ03xnLG0cV760Sa30/AsS2wDoyNDARKMs+PhKhbnXP88nAGkDyVEBuPcil3Z3EkBkeOHpRBbEWDKHJxicjK+aeqcObnAnmhXF3g/iKuS0r6T9jtn1xUCgYAHCbhBegrlE7vhc2MHUipwguzJUdhF67o7wU696XQx2hv51wFOekBcDLiX2lzguf8QBZAEt7ium5higMXfXfaD40ZFjztsWXKXI2Z3Y9Bih00/hHXpFtTThRviSY8yfuFx2TqGugmqL4XJCJjkwGX4IoEt9YKvAJ+LEJYH2XL/rQ==";
//    	String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAquEY9eJOdrBMnQeMoYDY7sogZ0OxOGS9tBn9a94bVt2YMguOlVI441UK5qOBGSwb/Tb//jVsnsTwuSMTgc06cvIViks/Qq19RiXcSvQr1CtNBFk3z6cdJGM+34n3Udug4MmBdl8/TCxXMjxo7hxkN5zuhFiXOM6uBbIejy5xu15sVezSyiMHWhNBmihoJKKOqnE7yJXjwgY/wQDJZkc6l909hB7cUlMPwtjp2B6FLU+LtpAkWV9ISPvAzctjA+7P87ypI200zhEbq8CW6eVxoqq8IScq++1sJebW9dn4GztotdFN76JbvgrYumYS8MjfPHqhNLtoj0TyzCkRjGXUaQIDAQAB";
    	if(huawuAlipay==null) return JsonRet.buildRet(-4002);
        AlipayClient alipayClient = new DefaultAlipayClient(getWay, huawuAlipay.getAlipayAppid(), huawuAlipay.getAlipayPrivateKey(), "json", "utf-8", huawuAlipay.getAlipayPublicKey(), "RSA2");
//    	AlipayClient alipayClient = new DefaultAlipayClient(getWay, appId, privateKey, "json", "utf-8", publicKey, "RSA2");
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
        MfoyouMap map = new MfoyouMap();
        map.put("out_biz_no", "" + extractId);
        map.put("payee_type", "ALIPAY_LOGONID");
        map.put("payee_account", account);
        map.put("amount", StrUtil.fen2yuan(amount));
        map.put("payer_show_name", "mfoyou提现");
        if (name != null)
            map.put("payee_real_name", name);
        map.put("remark", "mfoyou提现,加入mfoyou,成就创业梦想");
        request.setBizContent(JSON.toJSONString(map));
        AlipayFundTransToaccountTransferResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            logger.error(JSON.toJSONString(map), e);
            e.printStackTrace();
            return JsonRet.buildRet(-2, JSON.toJSONString(e));
        }
        logger.info(response.getBody());
        if (response.isSuccess()) {
            return JsonRet.buildRet(0, response.getBody());
        } else {
            return JsonRet.buildRet(-1, response.getBody());
        }
    }
//    public static void main(String[] args) {
//		new AliPayService().extract(1999, 1, "吴河东", "16602807180", 1);
//	}
}
