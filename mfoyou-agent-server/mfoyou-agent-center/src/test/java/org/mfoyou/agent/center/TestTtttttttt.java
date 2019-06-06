package org.mfoyou.agent.center;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mfoyou.agent.center.dao.inf.HuawuSystemMapper;
import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.IGoods;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.common.inf.IPayment;
import org.mfoyou.agent.common.inf.IStore;
import org.mfoyou.agent.common.inf.IThirdPartInfo;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/JunitSpring.xml"})
public class TestTtttttttt {
	@Autowired
	IStore iStore;
	@Autowired
	HuawuSystemMapper huawuSystemMapper;
	@Autowired
	IGoods goodsOrderService;
	@Autowired
	IPayment iPayment;
	@Autowired
	IOrder iOrder;
	@Autowired
	IIdentity iIdentity;
	@Autowired
	IAccount iAccount;
	@Autowired
	IThirdPartInfo iThirdPartInfo;
	@Test
	public void getBy(){
		HuawuWorker huawuWorker = new HuawuWorker();
		huawuWorker.setStationId(4);
		 System.out.println(JSON.toJSONString(iIdentity.getMfoyouWorkerListV3(huawuWorker, 0, 10)));
//		HuawuUser userInfoByPhoneV2 = iAccount.getUserInfoByPhoneV2(null, 10);
//		System.out.println(JSON.toJSONString(userInfoByPhoneV2));
//		HuawuWorker huawuWorker = new HuawuWorker();
////		huawuWorker.setWorkerState(-1);
//		huawuWorker.setAgentId(10);
//		ArrayListObject<?> mfoyouWorkerListV2 = iIdentity.getMfoyouWorkerListV2(huawuWorker, 1, 10, null, null);
//		System.out.println(JSON.toJSON(mfoyouWorkerListV2));
//		iOrder.getServiceOrderList()
//		String sql = "select xcx_id ,xcx_type from huawu_agent_wx_info where agent_id = 14";
//		String agentTypeInfo = iStore.getAgentTypeInfo(9);
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		
//		iPayment.getUserWallet(17, simpleDateFormat.parse("2018-07"), eDate, countType, userType)
//		System.out.println(JSON.toJSON(goodsOrderService.getGoodsByid(2)));
	}
}

