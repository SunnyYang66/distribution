package org.mfoyou.agent.common.entity;

import java.util.List;

import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.utils.common.Logger;


public class MfoyouCommonUtil {

	private static Logger logger = Logger.getLogger(MfoyouCommonUtil.class);

	public static void calcOrderPercentage(List<HuawuServiceOrder> list, int percentage) {
		int agentPercentage = percentage % 100;
		for (HuawuServiceOrder mfoyouServiceOrder : list) {
			if (mfoyouServiceOrder.getServiceOrderState() >= OrderState.emRunerAccept.getValue())
				continue;
			Integer payAmount = mfoyouServiceOrder.getServiceOrderPayAmount();
			Integer goodAmount = mfoyouServiceOrder.getServiceOrderGoodAmount();
			Integer runAmount = mfoyouServiceOrder.getServiceOrderAmount();
			if (goodAmount == null) {
				goodAmount = 0;
			}
			if (payAmount.intValue() != (goodAmount + runAmount)) {
				logger.error("payAmount.intValue() != (goodAmount + runAmount)");
			}
			int worker = (int) Math.round(runAmount * (100 - agentPercentage) / 100.0) + goodAmount;
			int agent = agentPercentage == 0 ? 0
					: payAmount - worker;
			mfoyouServiceOrder.setServiceAdminAmount(0);
			mfoyouServiceOrder.setServiceAgentAmount(agent);
		}
	}

	public static void calcOrderPercentage(HuawuServiceOrder mfoyouServiceOrder, int percentage, MfoyouStationMaster mfoyouStationMaster) {
		if (mfoyouServiceOrder.getServiceOrderState() >= OrderState.emRunerAccept.getValue())
			return;
		Integer payAmount = mfoyouServiceOrder.getServiceOrderPayAmount();
		Integer goodAmount = mfoyouServiceOrder.getServiceOrderGoodAmount();
		Integer runAmount = mfoyouServiceOrder.getServiceOrderAmount();
		Integer stationPercent = null;
		if(mfoyouStationMaster!=null){
			stationPercent = mfoyouStationMaster.getRunnerShareFee();
		}
		if (goodAmount == null) {
			goodAmount = 0;
		}
		if (payAmount.intValue() != (goodAmount + runAmount)) { 
			logger.error("payAmount.intValue() != (goodAmount + runAmount)");
		}
		int worker = (int) Math.round(runAmount * (100 - percentage) / 100.0) + goodAmount;
		int agent = percentage == 0 ? 0: payAmount - worker;
		int stationAmount = stationPercent==null?0:agent*stationPercent/100;
		agent-=stationAmount;
		mfoyouServiceOrder.setServiceAdminAmount(0);
		mfoyouServiceOrder.setServiceAgentAmount(agent);
		mfoyouServiceOrder.setServiceStationAmount(stationAmount);
	}

}
