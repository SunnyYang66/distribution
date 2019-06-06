package com.mfoyou.agent.web.service.order;

import org.mfoyou.agent.common.dao.domain.*;
import org.mfoyou.agent.common.entity.MfoyouWorkStatistics;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.entity.enums.PayType;
import org.mfoyou.agent.common.inf.IPayment;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {
	@Autowired
	IPayment iPayment;


	public MfoyouWorkStatistics getUserWallet(Integer userId, Date sDate, Date eDate, Integer countType,
			Integer userType) {
		return iPayment.getUserWallet(userId, sDate, eDate, countType, userType);
	}

	public List<MfoyouWorkStatistics> getUsersWorkeWallet(List<Integer> userIds, Date sDate, Date eDate) {
		return iPayment.getUsersWorkeWallet(userIds, sDate, eDate);
	}

	public ArrayListObject<HuawuPay> getServicePayList(HuawuPay mfoyoupay, Integer pageIndex, Integer pageSize,
			Date startDate, Date endDate) {
		return iPayment.getServicePayList(mfoyoupay, pageIndex, pageSize, startDate, endDate);
	}

	public int modifyMfoyouPay(HuawuPay savePay) {
		return iPayment.modifyMfoyouPay(savePay);
	}

	public boolean addStream(Integer userId, Integer amount, int direction, Integer orderId, Integer orderType,
			int sourceType, int targetType, String remark, int userType) {
		return iPayment.addStream(userId, amount, direction, orderId, orderType, sourceType, targetType, remark,
				userType);
	}

	public HuawuWallet getUserWallet(Integer userId) {
		
		return iPayment.getUserMfoyouWallet(userId);
	}

	public ArrayListObject<?> getExtractList(Integer type, HuawuExtract mfoyouExtract, Integer pageId, Integer pageSize,
			Date startDate, Date endDate) {
		return iPayment.getExtractList(type, mfoyouExtract, pageId, pageSize, startDate, endDate);
	}

	public boolean modifyExtract(HuawuExtract checkExtract, HuawuExtract updateExtract) {
		return iPayment.modifyExtract(checkExtract, updateExtract);
	}

	public HuawuExtract getMfoyouExtract(Integer auditId) {
		return iPayment.getMfoyouExtract(auditId);
	}

	public HuawuUser getOpenId(Integer userId){
		return iPayment.getOpenId(userId);
	}

	public boolean returnExtractFailMoney(int orderType, Integer userId, Integer oldValue, Integer amount,
			Integer auditId, Integer type) {
		
		boolean result = false;
		if (type == MfoyouUserType.runer.getValue()) {
			result = iPayment.payAddRunerWallet(userId, oldValue, amount, 98, auditId + "", 0);
		} else if (type == MfoyouUserType.agent.getValue()) {
			result = iPayment.payAddAgentWallet(userId, oldValue, amount, 98, auditId + "", 0, type);
		}
		// else if(type == MfoyouUserType.store.getValue()){
		// result = iPayment.payAddStoreWallet(userId, oldValue, amount, 98,
		// auditId+"", 0);
		// }
		// else if(type == 16){
		// result = iPayment.payAddStoreAgentWallet(userId, oldValue, amount,
		// 98, auditId+"", 0,type);
		// }
		else if (type == 32) {
			result = iPayment.payAddAgentWallet(userId, oldValue, amount, 98, auditId + "", 0, type);
		}
		// else if(type == 64){
		// result = iPayment.payAddStoreAgentWallet(userId, oldValue, amount,
		// 98, auditId+"", 0,type);
		// }
		if (result) {
			String content = orderType == 5 ? "提现失败" : "提现被驳回";
			iPayment.addStream(userId, amount, 1, auditId, orderType, PayType.system.getValue(),
					PayType.wallet.getValue(), content, type);
			return true;
		}
		return false;
	}

	public boolean modifyExtract(HuawuExtract restultExtract) {
		return iPayment.modifyExtractByKey(restultExtract);
	}

	public Integer applyExtract(HuawuExtract mfoyouExtract) {

		return iPayment.applyExtract(mfoyouExtract);
	}

	public Boolean beginExtractWallet(Integer userId, Integer checkAmount, Integer payAmount, Integer checkUserAmount,
			Integer payUserAmount, String payNumber, int orderType, Integer agentId, Integer userType) {
		return iPayment.beginExtractWallet(userId, checkAmount, payAmount, checkUserAmount, payUserAmount, payNumber,
				orderType, agentId, userType);
	}

	public Boolean modifyWallet(HuawuWallet mfoyouWallet) {
		return iPayment.modifyWallet(mfoyouWallet);
	}

	public Map<String, Object> getCountData(Integer agenid,Integer type) {
		
		return iPayment.getCountData(agenid,type);
	}

	public ArrayListObject<?> getPayList(Integer agenid, Integer pageId, Integer pageSize, Date startDate,
			Date endDate,Integer type) {
		
		return iPayment.getPayList(agenid,pageId,pageSize,startDate,endDate,type);
	}

	public ArrayListObject<HuawuStream> getStreamList(HuawuStream gxnnStream, Integer pageId, Integer pageSize,
			Date startDate, Date endDate) {
		return iPayment.getStreamList(gxnnStream, pageId, pageSize, startDate, endDate);
	}

	public ArrayListObject<HuawuWalletLog> getAgentList(Integer agentid, int userType, Date startDate, Date endDate,
			Integer pageid, Integer pageSize) {
		return iPayment.getAgentWalletList(agentid,userType,startDate,endDate,pageid,pageSize);
	}
}
