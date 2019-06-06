package com.mfoyou.agent.web.service.thirdPart;


import net.sf.json.JSONObject;
import org.mfoyou.agent.common.entity.WXPutForwardReps;
import org.mfoyou.agent.utils.common.HttpsUtils;
import org.mfoyou.agent.utils.common.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeiXinService {
    private static Logger logger = Logger.getLogger(Logger.class);

    public String extract(Integer amount, String openId) throws IOException {
        // 创建指定url的url对象,这里调用的是PHP体现的URL
        String url = "http://dls.llhlec.com/index.php/WXAPI/WeiXin/WXPutForward/openId/" + openId + "/totalFee/" + amount;
        // 创建http链接对象
        String s = HttpsUtils.get(url);
        logger.info("response:" + s);
        //json字符串转成对象
        JSONObject jsonObject1 = JSONObject.fromObject(s);
        WXPutForwardReps result = (WXPutForwardReps) JSONObject.toBean(jsonObject1, WXPutForwardReps.class);

        if (result.getReturn_code().equals("SUCCESS")) {
            if (result.getResult_code().equals("SUCCESS") ) {
                return "提现成功";
            } else {
                return result.getErr_code_des();
            }
        } else {
            return "支付失败";
        }
    }
}
