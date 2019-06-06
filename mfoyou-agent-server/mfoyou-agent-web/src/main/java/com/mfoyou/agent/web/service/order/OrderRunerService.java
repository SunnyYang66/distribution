package com.mfoyou.agent.web.service.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.common.dao.domain.HuawuIdcardInfo;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.entity.MfoyouWorkStatistics;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.common.inf.IStatistics;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.GisUtils;
import org.mfoyou.agent.utils.common.RunerWorkState;
import org.mfoyou.agent.utils.common.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.service.common.GeoService;
import com.mfoyou.agent.web.service.thirdPart.XGPushSerivce;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

import redis.clients.jedis.GeoRadiusResponse;

@Service
public class OrderRunerService {

    @Autowired
    RedisCacheManger redisCacheManger;
    @Autowired
    GeoService       geoService;
    @Autowired
    IStatistics        iStatistics;
    @Autowired
    IOrder iOrder;
    @Autowired
    XGPushSerivce    xgPushSerivce;
    @Autowired
    PaymentService		paymentService;
    @Autowired
    IIdentity		iIdentity;
    @Autowired
    IAccount 		iAccount;
    public Boolean InsertSeekAgentRuner(Integer orderId) {
        HuawuServiceOrder mfoyouServiceOrder = iOrder.getServiceOrderInfo(orderId);
       Integer  agentId = mfoyouServiceOrder.getAgentId();
        Double posLat = mfoyouServiceOrder.getServiceUserLat();
        Double posLon = mfoyouServiceOrder.getServiceUserLon();
        List<GeoRadiusResponse> list = null;
        if (posLat != null && posLon != null) {
            list = geoService.getRuner(agentId, posLon, posLat, 3000);
            geoService.addOrderPos(posLon, posLat, "" + orderId);
            if (list == null || list.size() == 0) {
                list = geoService.getRuner(agentId, posLon, posLat, 30000);
            }
        }
        Integer userType = 1;
        List<String> userIds = new ArrayList<>();
        if (list == null || list.size() == 0) {
            if (agentId != null && agentId != 0) {
                if (userIds.size() == 0) {
                    userType = 2;
                    if (agentId < 10)
                        userIds.add("0" + agentId);
                    else
                        userIds.add("" + agentId);
                }
            } else {
                return false;
            }
        } else {
            for (GeoRadiusResponse geoRadiusResponse : list) {
                String userId = GeoService.runer_getUserId(geoRadiusResponse.getMemberByString());
                if (userId.length() < 2) {
                    userId = "0" + userId;
                }
                userIds.add(userId);
            }
            //代理商区域需要进行二次推送
            if (agentId != 0) {
                //备选如果3分钟后无人接单推送团队管理员和30公里范围内所有人员
                xgPushSerivce.pushNoticeNewOrderAgentCheck(agentId, orderId, userType, userType, System.currentTimeMillis() + 2 * 60 * 1000L);
                List<GeoRadiusResponse> list0 = geoService.getRuner(agentId, posLon, posLat, 30000);
                if (list0 == null || list0.size() == 0) {
                } else {
                    List<String> userIds0 = new ArrayList<>();
                     String agents = "" + agentId;
                    if (agents.length() < 2) {
                        agents = "0" + agents;
                    }
                    userIds0.add(agents);
                    for (GeoRadiusResponse geoRadiusResponse : list0) {
                        String userId = GeoService.runer_getUserId(geoRadiusResponse.getMemberByString());
                        if (userId.length() < 2) {
                            userId = "0" + userId;
                        }
                        userIds0.add(userId);
                    }
                    if (userIds0.size() > 0)
                        xgPushSerivce.pushNoticeNewOrderCheck(userIds0, orderId, userType, userType, System.currentTimeMillis() + 3 * 60 * 1000L);
                }
            }
        }
        if (userIds.size() > 0) {
            xgPushSerivce.pushNoticeNewOrderToRuner(userIds, orderId, userType, userType, System.currentTimeMillis());
//            //3分钟
//            xgPushSerivce.checkAllSee(orderId, System.currentTimeMillis() + 3 * 60 * 1000L);
            if (userType == 2)
                return false;
            return true;
        }
        return false;
    }

    public List<RunerWorkState> orderMatchAgentRuner(HuawuServiceOrder mfoyouServiceOrder) {
        Integer agentId = mfoyouServiceOrder.getAgentId();
        Double srcLat = mfoyouServiceOrder.getServiceOrderPickupAddressLat();
        Double srcLon = mfoyouServiceOrder.getServiceOrderPickupAddressLon();
        Double desLat = mfoyouServiceOrder.getServiceOrderDeliveryAddressLat();
        Double desLon = mfoyouServiceOrder.getServiceOrderDeliveryAddressLon();
        Double uLat = mfoyouServiceOrder.getServiceUserLat();
        Double uLon = mfoyouServiceOrder.getServiceUserLon();

        if (agentId == null || agentId == 0) {
            return new ArrayList<RunerWorkState>();
        }
        List<GeoRadiusResponse> list = null;
        if (desLat != null && desLon != null) {
            list = geoService.getRuner(agentId, desLon, desLat, 50000);
        }
        if (list.size()==0  && srcLat != null && srcLon != null) {
            list = geoService.getRuner(agentId, srcLon, srcLat, 50000);
        }
        if (list.size()==0 && uLat != null && uLon != null) {
            list = geoService.getRuner(agentId, uLon, uLat, 50000);
        }
        List<Integer> userIds = new ArrayList<>();
        Map<Integer, RunerWorkState> map = new HashMap<>();
        List<HuawuWorker> mfoyouUsers = null;
        if (list == null || list.size() == 0) {
        	mfoyouUsers = iIdentity.getMfoyouWorkerListByAgentId(mfoyouServiceOrder.getAgentId());
        	for(HuawuWorker huawuWorker : mfoyouUsers){
        		 userIds.add(huawuWorker.getUserId());
        		 RunerWorkState runerWorkState = new RunerWorkState();
//                 runerWorkState.setDistane((int) geoRadiusResponse.getDistance());
                 runerWorkState.setUserId(huawuWorker.getUserId());
                 runerWorkState.setLat(huawuWorker.getWorkerLat());
                 runerWorkState.setLon(huawuWorker.getWorkerLong());
                 if(huawuWorker.getWorkerLat()!=null && huawuWorker.getWorkerLong()!=null){
                	 runerWorkState.setDistane((int)GisUtils.getDistance(srcLon, srcLat, huawuWorker.getWorkerLong(), huawuWorker.getWorkerLat()));
                 }
                 map.put(huawuWorker.getUserId(), runerWorkState);
        	}
//            return new ArrayList<RunerWorkState>();
        }else{
        	for (GeoRadiusResponse geoRadiusResponse : list) {
                Integer userId = StrUtil.parseInteger(GeoService.runer_getUserId(geoRadiusResponse.getMemberByString()));
                userIds.add(userId);
                RunerWorkState runerWorkState = new RunerWorkState();
                runerWorkState.setDistane((int) geoRadiusResponse.getDistance());
                runerWorkState.setUserId(userId);
                runerWorkState.setLat(geoRadiusResponse.getCoordinate().getLatitude());
                runerWorkState.setLon(geoRadiusResponse.getCoordinate().getLongitude());
                map.put(userId, runerWorkState);
            }
        	mfoyouUsers = iIdentity.getMfoyouWorkerList(userIds);
        }
        List<Integer> listState = new ArrayList<>();
        listState.add(OrderState.emRunerAccept.getValue());
        listState.add(OrderState.emServiceFinshPick.getValue());
        listState.add(OrderState.emServiceStart.getValue());
        Map<Integer, Integer> MfoyouServiceOrder = iOrder.getWorkerOrder(userIds, listState, null, null);
        HashMap<Integer , MfoyouWorkStatistics> hashMap = new HashMap<>();
        if(mfoyouServiceOrder.getServiceOrderSource() == -2){
        	List<MfoyouWorkStatistics> today = paymentService.getUsersWorkeWallet(userIds, DateUtils.getTimesmorning(), null);
            for(MfoyouWorkStatistics mfoyouWorkStatistics : today){
            	hashMap.put(mfoyouWorkStatistics.getUserId(), mfoyouWorkStatistics);
            }
        }
        for (HuawuWorker mfoyouUser : mfoyouUsers) {
            RunerWorkState runerWorkState = map.get(mfoyouUser.getUserId());
            if(mfoyouServiceOrder.getServiceOrderSource() == -2){
            	MfoyouWorkStatistics mfoyouWorkStatistics = hashMap.get(mfoyouUser.getUserId());
            	if(mfoyouWorkStatistics!=null){
            		runerWorkState.setTodayAmount(mfoyouWorkStatistics.getOrderAoument());
                  	runerWorkState.setTodayOrderCount(mfoyouWorkStatistics.getOrderCount());
            	}
            }
            HuawuIdcardInfo idcardInfo = iAccount.getIdcardInfo(mfoyouUser.getUserId());
            if(idcardInfo!=null){
            	runerWorkState.setName(idcardInfo.getUserTrueName());
            }
            // runerWorkState.setNickName(mfoyouUser.getUserNickName());
            runerWorkState.setOpenState(mfoyouUser.getWorkerOpenState());
            runerWorkState.setPhone(mfoyouUser.getWorkerPhone());
            runerWorkState.setHeadUrl(redisCacheManger.hget("u:"+mfoyouUser.getUserId(), "userHeadUrl"));
//            Double sDouble = mfoyouUser.getWorkerStar();
//            Integer ic = mfoyouUser.getWorkerCommentCount();
//            if (ic != null && ic > 0 && sDouble != null) {
//                runerWorkState.setStar(sDouble / ic);
//            } else {
                runerWorkState.setStar(5d);
//            }
            runerWorkState.setRemainderOrderCount(MfoyouServiceOrder.get(runerWorkState.getUserId()));
            if (runerWorkState.getRemainderOrderCount() == null) {
                runerWorkState.setRemainderOrderCount(0);
            }
        }
        List<RunerWorkState> listRet = new ArrayList<RunerWorkState>();
        listRet.addAll(map.values());
        Collections.sort(listRet); 
        return listRet;
    }

}
