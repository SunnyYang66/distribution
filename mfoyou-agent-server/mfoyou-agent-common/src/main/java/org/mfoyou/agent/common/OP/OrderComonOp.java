package org.mfoyou.agent.common.OP;

import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuWallet;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.entity.enums.OrderType;
import org.mfoyou.agent.common.entity.enums.PayType;
import org.mfoyou.agent.common.inf.IGoodsOrder;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.common.inf.IPayment;
import org.mfoyou.agent.utils.common.Logger;

public class OrderComonOp {

    private static Logger logger = Logger.getLogger(OrderComonOp.class);

    
    public static void finshOrderV1(HuawuServiceOrder tempServiceOrder, IIdentity iIdentity, IOrder iOrder, IPayment iPayment) {
       
        int agent = tempServiceOrder.getServiceAgentAmount();
        int station = tempServiceOrder.getServiceStationAmount()==null?0:tempServiceOrder.getServiceStationAmount();
        int total = tempServiceOrder.getServiceOrderPayAmount();
        int worker = total - agent-station;
        HuawuServiceOrder oldOrder = new HuawuServiceOrder();
        oldOrder.setServiceOrderState(OrderState.emServiceUserFinsh.getValue());
        oldOrder.setServiceOrderId(tempServiceOrder.getServiceOrderId());
        HuawuServiceOrder newOrder = new HuawuServiceOrder();
        newOrder.setServiceOrderState(OrderState.emServiceSystemFinsh.getValue());
        if (iOrder.updateServiceOrderState(oldOrder, newOrder, -1)) {
            for (int i = 0; i < 3; i++) {	
                HuawuWallet mfoyouWallet = iPayment.getUserMfoyouWallet(tempServiceOrder.getServiceOrderReceiveUser());
                if (iPayment.payAddRunerWallet(tempServiceOrder.getServiceOrderReceiveUser(), mfoyouWallet.getWalletRunerAmount(), worker, 1, tempServiceOrder.getServiceOrderNumber(),
                    tempServiceOrder.getAgentId())) {
                    iPayment.addStream(tempServiceOrder.getServiceOrderReceiveUser(), worker, 1, tempServiceOrder.getServiceOrderId(), OrderType.serviceOrder.getValue(), PayType.serviceOrder.getValue(),
                        PayType.wallet.getValue(), "服务订单结算",MfoyouUserType.runer.getValue());
                    break;
                }
            }
            for (int i = 0; i < 3; i++) {
            	HuawuWallet mfoyouWallet = iPayment.getUserMfoyouWallet(tempServiceOrder.getAgentId());
                if (iPayment.payAddAgentWallet(tempServiceOrder.getAgentId(), mfoyouWallet.getWalletAgentAmount(), agent, 1, tempServiceOrder.getServiceOrderNumber(), tempServiceOrder.getAgentId(),2)) {
                    iPayment.addStream(tempServiceOrder.getAgentId(), agent, 1, tempServiceOrder.getServiceOrderId(), OrderType.serviceOrder.getValue(), PayType.serviceOrder.getValue(),
                        PayType.wallet.getValue(), "服务订单结算",MfoyouUserType.agent.getValue());
                    break;
                }
            }
            if(tempServiceOrder.getServiceStationAmount()!=null && tempServiceOrder.getServiceStationAmount()>0){
            	for (int i = 0; i < 3; i++) {
                	HuawuWallet mfoyouWallet = iPayment.getUserMfoyouWallet(tempServiceOrder.getStationId());
                    if (iPayment.payAddStoreAgentWallet(tempServiceOrder.getStationId(), mfoyouWallet.getWalletStoreAgentAmount(), station, 1, tempServiceOrder.getServiceOrderNumber(), tempServiceOrder.getAgentId(),2)) {
                        iPayment.addStream(tempServiceOrder.getStationId(), station, 1, tempServiceOrder.getServiceOrderId(), OrderType.serviceOrder.getValue(), PayType.serviceOrder.getValue(),
                            PayType.wallet.getValue(), "服务订单结算",MfoyouUserType.station.getValue());
                        break;
                    }
                }
            }
            //统计订单信息
            HuawuWorker mfoyouWorker = iIdentity.getMfoyouWorkerInfo(tempServiceOrder.getServiceOrderReceiveUser(),tempServiceOrder.getAgentId());
            HuawuWorker saveWorker = new HuawuWorker();
            saveWorker.setUserId(tempServiceOrder.getServiceOrderReceiveUser());
            if (mfoyouWorker.getWorkerOrderCount() == null) {
                saveWorker.setWorkerOrderCount(1);
            } else {
                saveWorker.setWorkerOrderCount(mfoyouWorker.getWorkerOrderCount() + 1);
            }
            if (mfoyouWorker.getWorkerServiceDistance() == null) {
                saveWorker.setWorkerServiceDistance(tempServiceOrder.getServiceOrderDistance() == null ? 0 : tempServiceOrder.getServiceOrderDistance());
            } else {
                saveWorker.setWorkerServiceDistance(mfoyouWorker.getWorkerServiceDistance() + (tempServiceOrder.getServiceOrderDistance() == null ? 0 : tempServiceOrder.getServiceOrderDistance()));
            }
            iIdentity.modifyMfoyouWorkerInfo(saveWorker);
        }
    }

	public static void finshStoreOrderV1(MfoyouGoodsOrder goodsOrder, IGoodsOrder iOrder,
			IPayment iPayment) {
		
		int updateOrder = iOrder.fininshGoodorder(goodsOrder.getOrderId());
		if(updateOrder == 1){
			for(int i = 0 ;i < 3; i++){
				HuawuWallet userMfoyouWallet = iPayment.getUserMfoyouWallet(goodsOrder.getStoreId());
				if (iPayment.payAddStoreWallet(goodsOrder.getStoreId(), userMfoyouWallet.getWalletStoreAmount(), goodsOrder.getOrderStoreAmount(), 2, goodsOrder.getOrderNumber(),
	                    goodsOrder.getAreaAgentId())) {
	                iPayment.addStream(goodsOrder.getStoreId(), goodsOrder.getOrderStoreAmount(), 1, goodsOrder.getOrderId(), OrderType.goodsOrder.getValue(), PayType.goodsOrder.getValue(),
	                PayType.wallet.getValue(), "商品订单结算",MfoyouUserType.store.getValue());
	                break;
	            }
			}
			for (int i = 0; i < 3; i++) {
				HuawuWallet mfoyouWallet = iPayment.getUserMfoyouWallet(goodsOrder.getAreaAgentId());
	               if (iPayment.payAddStoreAgentWallet(goodsOrder.getAreaAgentId(), mfoyouWallet.getWalletStoreAgentAmount(), goodsOrder.getOrderAgentAdmount(), 2, goodsOrder.getOrderNumber(), 
	            		   goodsOrder.getAreaAgentId(),16)) {
	                   iPayment.addStream(goodsOrder.getAreaAgentId(), goodsOrder.getOrderAgentAdmount(), 1, goodsOrder.getOrderId(), OrderType.goodsOrder.getValue(), PayType.goodsOrder.getValue(),
	                        PayType.wallet.getValue(), "商品订单返点",16);
	                   break;
	               }
	           }
			if(goodsOrder.getOrderStationAmount()!=null && goodsOrder.getOrderStationAmount()>0){
            	for (int i = 0; i < 3; i++) {
                	HuawuWallet mfoyouWallet = iPayment.getUserMfoyouWallet(goodsOrder.getStationId());
                    if (iPayment.payAddStoreAgentWallet(goodsOrder.getStationId(), mfoyouWallet.getWalletStoreAgentAmount(), goodsOrder.getOrderStationAmount(), 2, goodsOrder.getOrderId()+"", goodsOrder.getAreaAgentId(),32)) {
                        iPayment.addStream(goodsOrder.getStationId(),  mfoyouWallet.getWalletStoreAgentAmount(), 1,  goodsOrder.getOrderId(), OrderType.goodsOrder.getValue(), PayType.goodsOrder.getValue(),
                            PayType.wallet.getValue(), "服务订单结算",MfoyouUserType.station.getValue());
                        break;
                    }
                }
            }
			logger.info("订单金钱处理完成，订单id为"+goodsOrder.getOrderId());
			
			//在下单的地方已经加过了
			//MfoyouStoreInfo mfoyouStoreInfo = iStaffUser.getMfoStoreInfo(goodsOrder.getStoreId());
			//mfoyouStoreInfo.setStoreTotalOrderCount(mfoyouStoreInfo.getStoreTotalOrderCount()+1);
			//iStaffUser.updateStoreInfoById(goodsOrder.getStoreId(), mfoyouStoreInfo);
		}
	}

}
