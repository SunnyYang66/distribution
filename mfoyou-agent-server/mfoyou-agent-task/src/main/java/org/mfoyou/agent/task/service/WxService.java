package org.mfoyou.agent.task.service;

import org.mfoyou.agent.common.inf.IThirdPartInfo;
import org.mfoyou.agent.utils.common.HttpsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tencent.xinge.XingeApp;
@Service
public class WxService {
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	IThirdPartInfo iThirdPartInfo;
	@Value("#{settings['sys.debug']?:false}")
  	private Boolean             isDebug;
	private static String wxTokencachePrex = "wx:token:";
	private static String wxmodelPrex = "wx:push:model:";
	private static Long ACCESSID = 2100301601L;
	private static String ACCESSSECRET = "fca33d200a133a05e1f95f05c90f46c1";
	
	private static Long ACCESSID2 = 2100307181L;
	private static String ACCESSSECRET2 = "720dbcbbcaf1ad07c23f0a58c0770673";
	public XingeApp getXingApp(Integer agentId, Integer type) {
//		HuawuXgClient huawuXgClient = iThirdPartInfo.getXgClient(agentId,type);
//		if(huawuXgClient==null) return null;
//		return new XingeApp(Long.parseLong(huawuXgClient.getAccessId()), huawuXgClient.getAccessSecret());
		if(type.intValue()==0){
			return new XingeApp(ACCESSID,ACCESSSECRET);
		}
		return new XingeApp(ACCESSID2,ACCESSSECRET2);
	}
	public String getTokenV1(Integer agentId,int appid) {
		String token = redisCacheManger.getValue(wxTokencachePrex + agentId+":"+appid);
		if (token == null || token.equals("")) {
			String tokenUrl = null;
//			if(isDebug){
//				tokenUrl = "http://api-d.mfoyou.cn/common/wxToken?token=111111asdwasdsss&appId="
//						+appid+"&agentId="+agentId;
//			}else{
				tokenUrl = "http://api.mfoyou.cn/common/wxToken?token=111111asdwasdsss&appId="
						+appid+"&agentId="+agentId;
//			}
			String response = HttpsUtils.get(tokenUrl);
			if (response == null || response.equals("")) {
				return null;
			}
			com.alibaba.fastjson.JSONObject object = JSON.parseObject(response);
			token = object.getString("data");
			if (token != null) {
				redisCacheManger.setValue(wxTokencachePrex + agentId+":"+appid, token, 200);
			}
		}
		return token;
	}
	public String getModelId(Integer agentId ,Integer type){
		String value = redisCacheManger.getValue(wxmodelPrex+agentId+":"+type);
		if(value==null || value.equals("")){
			value = iThirdPartInfo.getModelId(agentId,type);
			if(value!=null){
				redisCacheManger.setValue(wxmodelPrex+agentId+":"+type, value, 60*60);
			}
		}
		return value;
	}
	public String getModelId(Integer areaAgentId, String types) {
		if(types.equals("1")){
			return getModelId(areaAgentId, 5);
		}else if(types.equals("3")){
			return getModelId(areaAgentId, 6);
		}else{
			return getModelId(areaAgentId, 7);
		}
	}
}
