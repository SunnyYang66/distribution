package com.boyuanitsm.pay.unionpay.token;

import com.boyuanitsm.pay.unionpay.Acp;
import com.boyuanitsm.pay.unionpay.common.AcpService;
import com.boyuanitsm.pay.unionpay.config.SDKConfig;
import com.boyuanitsm.pay.unionpay.error.SignValidateFailException;
import org.mfoyou.agent.utils.common.Logger;

import org.apache.commons.httpclient.HttpException;



import java.util.HashMap;
import java.util.Map;

/**
 * 商户可通过发起解除标记交易解除之前在银联全渠道支付平台申请的Token标记。
 *
 * @author hookszhang on 7/26/16.
 */
public class DeleteToken {

    private Logger log = Logger.getLogger(DeleteToken.class);

    /**
     * 商户可通过发起解除标记交易解除之前在银联全渠道支付平台申请的Token标记。
     * 交易流程同支付开通交易。
     *
     * @param orderId 商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
     * @param token 从前台开通的后台通知中获取或者后台开通的返回报文中获取
     * @return
     * @throws HttpException
     * @throws SignValidateFailException
     */
    public Map<String, String> delete(String orderId, String token) throws HttpException, SignValidateFailException {
        Map<String, String> contentData = new HashMap<>();

        /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
        contentData.put("version", Acp.version);                  //版本号
        contentData.put("encoding", Acp.encoding_UTF8);                //字符集编码 可以使用UTF-8,GBK两种方式
        contentData.put("signMethod", "01");                           //签名方法 目前只支持01-RSA方式证书加密
        contentData.put("txnType", "74");                              //交易类型 74-解除标记
        contentData.put("txnSubType", "01");                           //交易子类型 01-解除标记
        contentData.put("bizType", "000902");                          //业务类型 token支付
        contentData.put("channelType", "07");                          //渠道类型07-PC

        /***商户接入参数***/
        contentData.put("merId", Acp.merId);                               //商户号码（本商户号码仅做为测试调通交易使用，该商户号配置了需要对敏感信息加密）测试时请改成自己申请的商户号，【自己注册的测试777开头的商户号不支持代收产品】
        contentData.put("accessType", "0");                            //接入类型，商户接入固定填0，不需修改
        contentData.put("orderId", orderId);                           //商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
        contentData.put("txnTime", Acp.getCurrentTime());                           //订单发送时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
        //token号（从前台开通的后台通知中获取或者后台开通的返回报文中获取）
        contentData.put("tokenPayData", "{token=" + token + "&trId=" + Acp.trId + "}");
        //contentData.put("reqReserved", "透传字段");        					//请求方保留域，透传字段（可以实现商户自定义参数的追踪）本交易的后台通知,对本交易的交易状态查询交易、对账文件中均会原样返回，商户可以按需上传，长度为1-1024个字节

        /**对请求参数进行签名并发送http post请求，接收同步应答报文**/
        Map<String, String> reqData = AcpService.sign(contentData, Acp.encoding_UTF8);            //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
        String requestBackUrl = SDKConfig.getConfig().getBackRequestUrl();            //交易请求url从配置文件读取对应属性文件acp_sdk.properties中的 acpsdk.backTransUrl
        Map<String, String> rspData = AcpService.post(reqData, requestBackUrl, Acp.encoding_UTF8); //发送请求报文并接受同步应答（默认连接超时时间30秒，读取返回结果超时时间30秒）;这里调用signData之后，调用submitUrl之前不能对submitFromData中的键值对做任何修改，如果修改会导致验签不通过

        /**对应答码的处理，请根据您的业务逻辑来编写程序,以下应答码处理逻辑仅供参考------------->**/
        //应答码规范参考open.unionpay.com帮助中心 下载  产品接口规范  《平台接入接口规范-第5部分-附录》
        if (!rspData.isEmpty()) {
            if (!AcpService.validate(rspData, Acp.encoding_UTF8)) {
                throw new SignValidateFailException("验证签名失败");
            }
        } else {
            //未返回正确的http状态
            throw new HttpException("未获取到返回报文或返回http状态码非200");
        }
        String reqMessage = Acp.genHtmlResult(reqData);
        String rspMessage = Acp.genHtmlResult(rspData);

        log.debug("Request : "+ reqMessage);
        log.debug("Response : "+ rspMessage);

        return rspData;
    }

}
