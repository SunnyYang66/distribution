package org.mfoyou.agent.common.inf;

import org.mfoyou.agent.common.dao.domain.*;
import org.mfoyou.agent.common.entity.MfoyouWorkStatistics;
import org.mfoyou.agent.utils.common.ArrayListObject;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IPayment {

    MfoyouWorkStatistics getUserWallet(Integer userId, Date sDate, Date eDate, Integer countType, Integer userType);

    int addMfoyouPay(HuawuPay huawuPay);

    HuawuPay getMfoyouPayByNumber(String string);

    int modifyMfoyouPay(HuawuPay mfoyouPaySave);

    List<MfoyouWorkStatistics> getUsersWorkeWallet(List<Integer> userIds, Date sDate, Date eDate);

    Boolean addStream(Integer userId, Integer amount, Integer direction, Integer orderId, Integer orderType,
                      Integer sourceType, Integer targetType, String remark, Integer userType);


    Boolean addStream(HuawuStream gxnnStream);

    Boolean addPayWalletLog(String payType, Integer direction, Integer userId, Integer payAmount, String orderNumber,
                            Integer orderType, Integer agentId, Integer userRole);

    HuawuWallet getUserMfoyouWallet(Integer serviceOrderReceiveUser);

    Boolean payAddRunerWallet(Integer userId, Integer checkAmount, Integer payAmount, int orderType, String orderNumber,
                              Integer agentId);

    Boolean payAddAgentWallet(Integer userId, Integer checkAmount, Integer payAmount, int orderType, String orderNumber,
                              Integer agentId, Integer type);

    ArrayListObject<HuawuPay> getServicePayList(HuawuPay mfoyouServiceOrder, Integer pageIndex, Integer pageSize,
                                                Date startDate, Date endDate);

    ArrayListObject<HuawuExtract> getExtractList(Integer type, HuawuExtract mfoyouServiceOrder, Integer pageId,
                                                 Integer pageSize, Date startDate, Date endDate);

    Boolean modifyExtract(HuawuExtract checkExtract, HuawuExtract changeExtract);

    HuawuExtract getMfoyouExtract(int extractId);

    HuawuUser getOpenId(Integer userId);

    Boolean modifyExtractByKey(HuawuExtract changeExtract);

    Integer applyExtract(HuawuExtract mfoyouExtract);

    Boolean modifyWallet(HuawuWallet mfoyouWallet);

    Boolean beginExtractWallet(Integer userId, Integer checkAmount, Integer payAmount, Integer checkUserAmount,
                               Integer payUserAmount, String payNumber, int orderType, Integer agentId, Integer userType);

    Boolean payAddStoreWallet(Integer userId, Integer checkAmount, Integer payAmount, int orderType, String orderNumber,
                              Integer agentId);

    Boolean payAddStoreAgentWallet(Integer userId, Integer checkAmount, Integer payAmount, int orderType,
                                   String orderNumber, Integer agentId, Integer type);


    ArrayListObject<?> getPayList(Integer agenid, Integer pageId, Integer pageSize, Date startDate, Date endDate, Integer type);

    Map<String, Object> getCountData(Integer agentId, Integer type);

    ArrayListObject<HuawuStream> getStreamList(HuawuStream gxnnStream, Integer pageId, Integer pageSize, Date startDate,
                                               Date endDate);

    ArrayListObject<HuawuWalletLog> getAgentWalletList(Integer agentid, int userType, Date startDate, Date endDate,
                                                       Integer pageid, Integer pageSize);

}
