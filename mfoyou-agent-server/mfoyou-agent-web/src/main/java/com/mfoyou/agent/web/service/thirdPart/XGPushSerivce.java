package com.mfoyou.agent.web.service.thirdPart;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;
import com.tencent.xinge.PushData;

@Service
public class XGPushSerivce {

    @Autowired
    RedisCacheManger      redisCacheManger;

    //推送给接单员有新的订单
    private static String NEWORDERPUSH       = "xp:Line1";
    //推送给代理商，检查2分钟后是否有人接单，没接单就指派
    private static String NEWORDERAGENTCHECK = "xp:Line6";
    //推送给所有人
    private static String NEWORDERCHECK      = "xp:Line2";

    //所有用户都能看见时间
    private static String ORDERALLSEECHECK   = "xp:Line3";

    //10分钟检查一下订单是否被接 如果没有就通知一下
    private static String ORDERCHECKORDER    = "xp:Line4";

    //催单
    private static String REMINDERRUNNER     = "xp:Line5";

    //实时通知
    private static String NOTICEINFO         = "xp:Line7";
    
    private static String EXTRACT 			 = "xp:Line8";
    
    public void pushExtractNotify(Integer userId, Integer orderId, Integer userType,  String title,String content) {

        List<String> userIds = new ArrayList<>();
        if (userId != null) {
            if (userId < 10)
                userIds.add("0" + userId);
            else
                userIds.add("" + userId);
        }
        PushData pushData = new PushData();
        pushData.setUserIds(userIds);
        pushData.setOrderId(orderId);
        pushData.setUserType(userType);
        pushData.setTitlePrefix(title);
        pushData.setContent(content);
        redisCacheManger.pushRList(EXTRACT, JSON.toJSONString(pushData));
    }
    
    public void pushNoticeUser(Integer userId, Integer orderId, Integer userType,  String title,String content) {

        List<String> userIds = new ArrayList<>();
        if (userId != null) {
            if (userId < 10)
                userIds.add("0" + userId);
            else
                userIds.add("" + userId);
        }
        PushData pushData = new PushData();
        pushData.setUserIds(userIds);
        pushData.setOrderId(orderId);
        pushData.setUserType(userType);
        pushData.setTitlePrefix(title);
        pushData.setContent(content);
        redisCacheManger.pushRList(NOTICEINFO, JSON.toJSONString(pushData));
    }

    public void checkOrderState(Integer orderId, Long effectTime) {

        PushData pushData = new PushData();
        pushData.setOrderId(orderId);
        pushData.setEffectTime(effectTime);
        redisCacheManger.pushRList(ORDERCHECKORDER, JSON.toJSONString(pushData));

    }

    public void checkAllSee(Integer orderId, Long effectTime) {

        PushData pushData = new PushData();
        pushData.setOrderId(orderId);
        pushData.setEffectTime(effectTime);
        redisCacheManger.pushRList(ORDERALLSEECHECK, JSON.toJSONString(pushData));

    }

    public void pushNoticeNewOrderAgentCheck(Integer agentId, Integer orderId, Integer userType, Integer type, Long effectTime) {

        List<String> userIds = new ArrayList<>();
        if (agentId < 10)
            userIds.add("0" + agentId);
        else
            userIds.add("" + agentId);
        PushData pushData = new PushData();
        pushData.setUserIds(userIds);
        pushData.setOrderId(orderId);
        pushData.setType(type);
        pushData.setEffectTime(effectTime);
        pushData.setUserType(userType);
        redisCacheManger.pushRList(NEWORDERAGENTCHECK, JSON.toJSONString(pushData));
    }

    public void pushNoticeNewOrderCheck(Integer agentId, Integer orderId, Integer userType, Integer type, Long effectTime) {

        List<String> userIds = new ArrayList<>();
        if (agentId < 10)
            userIds.add("0" + agentId);
        else
            userIds.add("" + agentId);
        PushData pushData = new PushData();
        pushData.setUserIds(userIds);
        pushData.setOrderId(orderId);
        pushData.setType(type);
        pushData.setEffectTime(effectTime);
        pushData.setUserType(userType);
        redisCacheManger.pushRList(NEWORDERCHECK, JSON.toJSONString(pushData));

    }

    public void pushNoticeNewOrderCheck(List<String> userIds, Integer orderId, Integer userType, Integer type, Long effectTime) {

        PushData pushData = new PushData();
        pushData.setUserIds(userIds);
        pushData.setOrderId(orderId);
        pushData.setType(type);
        pushData.setEffectTime(effectTime);
        pushData.setUserType(userType);
        redisCacheManger.pushRList(NEWORDERCHECK, JSON.toJSONString(pushData));

    }
    @Deprecated
    public void pushNoticeToRuner(List<String> userIds, Integer orderId, Integer userType, Integer type, Long effectTime) {

        PushData pushData = new PushData();
        pushData.setUserIds(userIds);
        pushData.setOrderId(orderId);
        pushData.setType(type);
        pushData.setEffectTime(effectTime);
        pushData.setUserType(userType);
        if (userType != null && userType == 2) {
            pushData.setTitlePrefix("未分配的新订单");
        } else {
            pushData.setTitlePrefix("新订单提醒");
        }
        redisCacheManger.pushRList(NEWORDERPUSH, JSON.toJSONString(pushData));

    }

    public void pushNoticeNewOrderToRuner(List<String> userIds, Integer orderId, Integer userType, Integer type, Long effectTime) {

        PushData pushData = new PushData();
        pushData.setUserIds(userIds);
        pushData.setOrderId(orderId);
        pushData.setType(type);
        pushData.setEffectTime(effectTime);
        pushData.setUserType(userType);
        if (userType != null && userType == 2) {
            pushData.setTitlePrefix("未分配的新订单");
        } else {
            pushData.setTitlePrefix("新订单提醒");
        }
        redisCacheManger.pushRList(NEWORDERPUSH, JSON.toJSONString(pushData));

    }

    public void pushNoticeReminderToRunner(List<String> userIds, Integer orderId, Integer userType, Integer type, Long effectTime) {
       
    	PushData pushData = new PushData();
        pushData.setUserIds(userIds);
        pushData.setOrderId(orderId);
        pushData.setType(type);
        pushData.setEffectTime(effectTime);
        pushData.setUserType(userType);
        pushData.setTitlePrefix("催单提醒");
        redisCacheManger.pushRList(REMINDERRUNNER, JSON.toJSONString(pushData));
    }

    public void pushOrderNoticeUser(Integer userId, Integer orderId, Integer userType, Integer type, String prefix) {

        List<String> userIds = new ArrayList<>();
        if (userId != null) {
            if (userId < 10)
                userIds.add("0" + userId);
            else
                userIds.add("" + userId);
        }
        PushData pushData = new PushData();
        pushData.setUserIds(userIds);
        pushData.setOrderId(orderId);
        pushData.setType(type);
        pushData.setEffectTime(System.currentTimeMillis() - 100000);
        pushData.setUserType(userType);
        pushData.setTitlePrefix(prefix);
        redisCacheManger.pushRList(NEWORDERPUSH, JSON.toJSONString(pushData));
    }

}
