package com.mfoyou.agent.web.service.session;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

import redis.clients.jedis.ShardedJedis;

@Service
public class SessionService {
	 private static final String MFOYOU_USER_ID           = "userId";
	    private static final String MFOYOU_ADMIN_ID          = "adminId";

	    public static final String  MFOYOU_AGENT_ID          = "agentId";
	    public static final String  MFOYOU_STATION_ID        = "stationId";

	    private static final String MFOYOU_USER_PHONE        = "userPhone";

	    private static final String MFOYOU_USER_LOGIN_TYPE   = "userType";

	    private static final String MFOYOU_USER_RIGHT        = "userRight";
	    
	    private static final String ADMIN_TYPE = "type";

	    private static final String MFOYOU_SERIVCE_TYPE      = "workerServiceType";
	    public static final String  MFOYOU_OPENID            = "openId";
	    public static final String  MFOYOU_APPID             = "appId";

	    private static final String MFOYOU_OPEN_STATE        = "workerOpenState";
	    private static final String MFOYOU_RUNER_TYPE        = "workerType";

	    private static final String MFOYOU_AGENT_PHONE       = "agentUserPhone";
	    private static final String MFOYOU_AGENT_TEARM_NAME  = "agentTeamName";
	    private static final String MFOYOU_AGENT_USER_NAME   = "agentUserContacts";
	    private static final String MFOYOU_AGENT_USER_NAME1  = "agentUserName";
	    private static final String MFOYOU_AGENT_USER_NAME2  = "userName";
	    private static final String MFOYOU_AGENT_PERCENTAGE  = "agentPercentage";

	    private static final String MFOYOU_USER_LON          = "lon";
	    private static final String MFOYOU_USER_LAT          = "lat";
	    private static final String MFOYOU_USER_WLON         = "workerLong";
	    private static final String MFOYOU_USER_WLAT         = "worketLat";
	//
//	    private static final String MFOYOU_USER_NAME         = "userName";
	//
//	    private static final String MFOYOU_USER_BIRTH        = "userBirthDate";
	//
//	    private static final String MFOYOU_USER_SEX          = "userSex";
	//
//	    private static final String MFOYOU_USER_PROVINCE     = "userProvince";
	//
//	    private static final String MFOYOU_USER_CITY         = "userCity";
	//
//	    private static final String MFOYOU_USER_COUNTY       = "userCounty";
	//
//	    private static final String MFOYOU_USER_ADDRESS      = "userAddress";
	//
//	    private static final String MFOYOU_USER_EMAIL        = "userEmail";
	//
//	    private static final String MFOYOU_USER_QQ           = "userQq";
	//
//	    private static final String MFOYOU_USER_WECHAT       = "userWechat";
	//
//	    private static final String MFOYOU_USER_REGISTER_TIM = "userRegisterTime";

	    public static final String  SESSION_TYPE_USERINFO    = "userinfo:";

	    public static final String  SESSION_COOKIE           = "token";
	    
	    public static final String  SESSION_INFO             = "USER_INFO";
	    
	    public static final String  GOODS_INFO				 = "goodsinfo:";
	    
	    public static final String  GOODS_Type  			 = "goodstype";
		public static final String MFOYOU_LOGIN_INFO = "login_info";
	    @Autowired
	    private RedisCacheManger    redisCacheManger;

	    @Value("#{settings['session.timout.minutes']?:30}")
	    private int                 sessionTimeoutMinutes;
	    
	    @Value("#{settings['goods.timout.minutes']?:30}")
	    private int 				goodsTimeout;
	    
	    @Value("#{settings['goodstype.timout.minutes']?:30}")
	    private int 				goodstypeTimeout;
	    public static String makeSessionCookie() {
	        return UUID.randomUUID().toString();
	    }

	    public static String getSeesionId(HttpServletRequest request) {
	        Object sessionObject = request.getAttribute(SESSION_COOKIE);
	        if (sessionObject != null && sessionObject instanceof String) {
	            return (String) sessionObject;
	        }
	        Cookie[] cookies = request.getCookies();
	        if (cookies == null)
	            return null;
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals(SESSION_COOKIE)) {
	                request.setAttribute(SESSION_COOKIE, cookie.getValue());
	                return cookie.getValue();
	            }
	        }
	        return null;
	    }

	    public static void setSeesionId(HttpServletRequest request, HttpServletResponse response, String sessionId) {
	        Cookie cookie = new Cookie(SessionService.SESSION_COOKIE, sessionId);
	        cookie.setPath("/");
//	        cookie.setHttpOnly(true);
	        response.addCookie(cookie);
	        request.setAttribute(SessionService.SESSION_COOKIE, sessionId);
	    }

	    public static void setSeesionId(HttpServletRequest request, String sessionId) {
	        request.setAttribute(SessionService.SESSION_COOKIE, sessionId);
	    }

	    public static void checkSeesionCookie(HttpServletRequest request, HttpServletResponse response) {
	        String sessionId = getSeesionId(request);
	        if (sessionId != null)
	            return;
	        sessionId = makeSessionCookie();
	        setSeesionId(request, response, sessionId);
	    }

	    public Map<String, String> getRedisMap(HttpServletRequest request, String keys) {
	        String key = getSeesionId(request);
	        if (key == null)
	            return null;
	        ShardedJedis shardedJedis = redisCacheManger.getRedis();
	        key = keys + "_" + key;
	        Map<String, String> map = shardedJedis.hgetAll(key);
	        if (map != null) {
	            if (map.isEmpty())
	                return null;
	            shardedJedis.expire(key, 60 * sessionTimeoutMinutes);
	        }
	        redisCacheManger.releaseRedis(shardedJedis);
	        return map;
	    }

	    public void setRedisMap(HttpServletRequest request, String keys, Map<String, String> map) {
	        String key = getSeesionId(request);
	        if (key == null)
	            return;
	        ShardedJedis shardedJedis = redisCacheManger.getRedis();
	        shardedJedis.hmset(key, map);
	    }
	    private String makeSessionIdKey(String sessionId) {
	        return SESSION_TYPE_USERINFO + sessionId;
	    }
	    /**
	     * 此方法用于获取目前登陆的用户，如果用户没有登陆则返回为null，如果登陆，则返回用户的信息对象
	     * 
	     * @param request
	     * @return
	     */
	    public MfoyouMap currentUser(HttpServletRequest request) {
	        if (request.getAttribute(SESSION_INFO) != null) {
	            return (MfoyouMap) request.getAttribute(SESSION_INFO);
	        }
	        String sessionId = getSeesionId(request);
	        MfoyouMap map = MfoyouMap.fromHashMap(redisCacheManger.getMapValue(makeSessionIdKey(sessionId)));
	        request.setAttribute(SESSION_INFO, map);
	        if (map != null && map.size() > 0) {            
	            if (Math.random() < 0.2) {
	                redisCacheManger.setExpire(makeSessionIdKey(sessionId), 60 * sessionTimeoutMinutes);
	            }
	        }
	        return map;
	    }
	    
	    public Integer currentUserType(HttpServletRequest request) {
	    	Integer userType = currentUser(request).getInteger(MFOYOU_USER_LOGIN_TYPE);
	        return userType==null?null: userType==1 ? userType : (userType & 0xfe);
	    }
	    public Long currentUserLoginTime(HttpServletRequest request) {
	        return currentUser(request).getLong("loginTime");
	    }


	    public void setUserType(HttpServletRequest request, int type) {
	        loginAppend(request, MFOYOU_USER_LOGIN_TYPE, "" + type);
	    }

	    public void setUserAppId(HttpServletRequest request, String appId) {
	        loginAppend(request, MFOYOU_APPID, "" + appId);
	    }

	    public void setUserOpenId(HttpServletRequest request, String openId) {
	        loginAppend(request, MFOYOU_OPENID, "" + openId);
	    }

	    public Integer currentUserRight(HttpServletRequest request) {
	        return currentUser(request).getInteger(MFOYOU_USER_RIGHT);
	    }

	    public Integer currentUserId(HttpServletRequest request) {
	        Integer userType = currentUserType(request);
	        if (userType != null && userType.equals(UserRight.ADMINACCESS.getValue())) {
	            return currentUser(request).getInteger(MFOYOU_ADMIN_ID);
	        }
	        return currentUser(request).getInteger(MFOYOU_USER_ID);
	    }

	    public Double currentUserlon(HttpServletRequest request) {
	        Double lon = currentUser(request).getDouble(MFOYOU_USER_LON);
	        if (lon == null)
	            currentUser(request).getDouble(MFOYOU_USER_WLON);
	        return lon;
	    }

	    public Double currentUserlat(HttpServletRequest request) {
	        Double lat = currentUser(request).getDouble(MFOYOU_USER_LAT);
	        if (lat == null)
	            currentUser(request).getDouble(MFOYOU_USER_WLAT);
	        return lat;
	    }

	    public Integer currentAppId(HttpServletRequest request) {
	        return currentUser(request).getInteger(MFOYOU_APPID);
	    }
	    public void currentAppId(HttpServletRequest request,Integer appId) {
	        currentUser(request).put(MFOYOU_APPID,appId);
	    }

	    public String currentAgentPhone(HttpServletRequest request) {
	        String phone = currentUser(request).get(MFOYOU_AGENT_PHONE);
	        if (phone != null)
	            return phone;
	        return currentUserPhone(request);
	    }

	    public String currentAgentTeamName(HttpServletRequest request) {
	        return currentUser(request).get(MFOYOU_AGENT_TEARM_NAME);
	    }

	    public String currentAgentContacts(HttpServletRequest request) {
	        String name = currentUser(request).get(MFOYOU_AGENT_USER_NAME);
	        if (name != null)
	            return name;
	        name = currentUser(request).get(MFOYOU_AGENT_USER_NAME1);
	        if (name != null)
	            return name;
	        name = currentUser(request).get(MFOYOU_AGENT_USER_NAME2);
	        return name;
	    }

	   

	    public String currentUserPhone(HttpServletRequest request) {
	        return currentUser(request).get(MFOYOU_USER_PHONE);
	    }

	    public String currentWorkerServiceType(HttpServletRequest request) {
	        return currentUser(request).get(MFOYOU_SERIVCE_TYPE);
	    }

	    public String currentOpenId(HttpServletRequest request) {
	        return currentUser(request).get(MFOYOU_OPENID);
	    }

	    public Integer currentWorkerOpenState(HttpServletRequest request) {
	        return currentUser(request).getInteger(MFOYOU_OPEN_STATE);
	    }

	    public Integer currentAgentPercentage(HttpServletRequest request) {
	        return currentUser(request).getInteger(MFOYOU_AGENT_PERCENTAGE);
	    }
	    
	    public Integer currentUserAgentId(HttpServletRequest request) {
	        return currentUser(request).getInteger(MFOYOU_AGENT_ID);
	    }
	    public Integer currentUserStationId(HttpServletRequest request) {
	        return currentUser(request).getInteger(MFOYOU_STATION_ID);
	    }

	    public Integer currentWorderType(HttpServletRequest request) {
	        return currentUser(request).getInteger(MFOYOU_RUNER_TYPE);
	    }

	    public void loginSucessful(HttpServletRequest request, Map<String,String> map,Integer appid,Integer agentId) {
	    	//删除以前的token
	    	 if (map.get(MFOYOU_USER_ID) != null && map.get(MFOYOU_USER_LOGIN_TYPE)!=null){
	    		 String session = redisCacheManger.getValue("l:u:"+map.get(MFOYOU_USER_LOGIN_TYPE)+":"+appid+":"+map.get(MFOYOU_USER_ID));
	    			if(session != null){
	    				redisCacheManger.deleteKey(makeSessionIdKey(session));
	    			}
	    	 }
	        String sessionId = getSeesionId(request);
	        if (map.get(MFOYOU_USER_ID) != null && map.get(MFOYOU_USER_LOGIN_TYPE) != null) {
	            redisCacheManger.setValue("l:u:"+map.get(MFOYOU_USER_LOGIN_TYPE)+":"+appid+":"+map.get(MFOYOU_USER_ID), sessionId, 15*24*3600);
	        }
	        redisCacheManger.setMapValue(makeSessionIdKey(sessionId), map,15*24*3600 );
	        request.setAttribute(SESSION_INFO, map);
	    }

	    public void loginAppend(HttpServletRequest request, Map<String, String> map) {
	        String sessionId = getSeesionId(request);
	        redisCacheManger.setMapValue(makeSessionIdKey(sessionId), map, 60 * sessionTimeoutMinutes);
	        currentUser(request).putAll(map);
	    }

	    public void loginAppend(HttpServletRequest request, String key, String vale) {
	        String sessionId = getSeesionId(request);
	        redisCacheManger.setMapKeyValue(makeSessionIdKey(sessionId), key, vale, 60 * sessionTimeoutMinutes);
	        currentUser(request).put(key, vale);
	    }

	    public void clearCurrentUser(HttpServletRequest request) {
	        String sessionId = getSeesionId(request);
	        redisCacheManger.deleteKey(makeSessionIdKey(sessionId));
	    }

	    /**
	     * 此方法用于获取目前登陆的用户的ID，如果用户没有登陆则返回为null，如果登陆，则返回用户的ID
	     * 
	     * @param request
	     * @return
	     */
	    public String getUserId(HttpServletRequest request) {
	        String sessionId = getSeesionId(request);
	        Map<String, String> user = redisCacheManger.getMapValue(makeSessionIdKey(sessionId));
	        if (user != null && !user.isEmpty()) {
	            return user.get("KEY_USER_ID");
	        } else {
	            return "-1";
	        }
	    }

	    /**
	     * 此方法用于设置信息到redis
	     * 
	     * @param request
	     * @param user
	     *            信息map对象
	     * @param seconds
	     *            信息保存有效时间
	     * @param type
	     *            信息名称比如user
	     * @return
	     */
	    /*
	     * public void setSessionMap(HttpServletRequest request, Map<String ,String>
	     * map,int seconds,String type){ String sessionId = getSeesionId(request);
	     * redisCacheManger.setMapValue(sessionId+type,map,seconds); }
	     */

	    /**
	     * 此方法用于获取redis中指定的信息
	     * 
	     * @param request
	     * @param type
	     *            信息名称，比如获取用户信息则值为user
	     * @return
	     */
	    public Map<String, String> getSessionMap(HttpServletRequest request, String type) {
	        String sessionId = getSeesionId(request);
	        return redisCacheManger.getMapValue(sessionId + type);
	    }

	    /**
	     * 此方法用于设置信息到redis
	     * 
	     * @param request
	     * @param user
	     *            用户信息对象
	     * @param seconds
	     *            信息保存有效时间
	     * @param type
	     *            保存的信息名称，比如验证码就是code
	     * @return
	     */
	    public void setSessionInfo(HttpServletRequest request, String value, int seconds, String type) {
	        String sessionId = getSeesionId(request);
	        redisCacheManger.setValue(sessionId + type, value, seconds);
	    }

	    /**
	     * 此方法用于设置目前登陆的用户信息到redis
	     * 
	     * @param request
	     * @param user
	     *            用户信息对象
	     * @param seconds
	     *            信息保存有效时间
	     * @param type
	     *            保存的信息名称，比如验证码就是code
	     * @return
	     */
	    public String getSessionInfo(HttpServletRequest request, String type) {
	        String sessionId = getSeesionId(request);
	        return redisCacheManger.getValue(sessionId + type);
	    }

	    /**
	     * 判断是否登录
	     * 
	     * @param request
	     * @return
	     */
	    public boolean isLogin(HttpServletRequest request) {
	        Map<String, String> user = currentUser(request);
	        if (user == null || user.isEmpty()) { // 未登录
	            return false;
	        }
	        return true;
	    }

		public Map<String, String> getGoodsInfo(Integer id) {
			Map<String, String> mapValue = redisCacheManger.getMapValue(GOODS_INFO+id);
			if(mapValue != null && !mapValue.isEmpty()){
				if (Math.random() < 0.2) {
					redisCacheManger.setExpire(GOODS_INFO+id, 60 * goodsTimeout);
	            }
			}
			return mapValue;
		}
		
		public void setGoodsInfo(Map<String, String> map,Integer id){
			redisCacheManger.setMapValue(GOODS_INFO+id, map, 60*goodsTimeout);
		}

		public Set<String> getGoodsType(Integer storeId) {
			Set<String> set = redisCacheManger.getSetValue(GOODS_Type+storeId);
			if(set != null && !set.isEmpty()){
				if (Math.random() < 0.2) {
					redisCacheManger.setExpire(GOODS_Type+storeId, 60 * goodstypeTimeout);
	            }
			}
			return set;
		}
		public void  addType(String type,Integer storeId){
			redisCacheManger.pushSet(GOODS_Type+storeId, type, 60 * goodstypeTimeout);
		}

		public void setGoodsType(Set<String> typeList, Integer storeId) {
			
			redisCacheManger.pushSet(GOODS_Type+storeId, typeList, 60 * goodstypeTimeout);
		}


		public int checkdeleteGoods(Integer id, Integer storeId) {
			
			//检查是否有操作这个goods的权限
			String storeIdV1 = redisCacheManger.getMapValue(GOODS_INFO+id).get("storeId");
			if(storeIdV1 == null){
				return -1;
			}else if(storeId.equals(Integer.parseInt(storeIdV1))){
				return 1;
			}else{
				return 0;
			}
		}

		public void removGoods(Integer id) {
			
			redisCacheManger.deleteKey(GOODS_INFO+id);
		}

		public Integer currentExtractType(HttpServletRequest request) {
			
			 return currentUser(request).getInteger(ADMIN_TYPE);
		}
		public String currentExtractPhone(HttpServletRequest request) {
			
			 return currentUser(request).get("adminPhone");
		}

		public void logout(Integer storeid,int userType) {
			
			String session = redisCacheManger.getValue("l:u:"+userType+":" + storeid);
			if(session != null){
				redisCacheManger.deleteKey(makeSessionIdKey(session));
			}
		}

		public Integer currentAgentPercenttage(HttpServletRequest request) {
			
			String string = currentUser(request).get("storeAgentPercent");
			if(string==null){
				return 5;
			}
			return Integer.parseInt(string);
		}
		public int currentAgentPowerType(HttpServletRequest request) {
			String string = currentUser(request).get("power");
			if(string!=null){
				return Integer.parseInt(string) >> 9 & 0x03;
			}
			return 0;
		}


		public String currentHeadUrl(HttpServletRequest request) {
			MfoyouMap currentUser = currentUser(request);
			String headUrl = currentUser.get("userHeadUrl");
			return headUrl == null ?currentUser.get("userHeadWechatUrl"):headUrl ;
		}

		public String currentNickName(HttpServletRequest request) {
			return currentUser(request).get("userNickName");
		}

		public String currentUserInfo(HttpServletRequest request) {
			MfoyouMap currentUser = currentUser(request);
			return currentUser.get("login_info");
		}
		public int currentWorkFee(HttpServletRequest request) {
			MfoyouMap currentUser = currentUser(request);
			String workerFee = currentUser.get("workerFee");
			return workerFee==null ? null : Integer.parseInt(workerFee);
		}

		public void modifyWorkerAgent(Integer agentId, Integer workerId) {
			String value = redisCacheManger.getValue("l:u:3:100:"+workerId);
			if(value!=null){
				 redisCacheManger.setMapKeyValue(makeSessionIdKey(value), "agentId", agentId+"", 60 * sessionTimeoutMinutes);
				 redisCacheManger.setMapKeyValue("u:"+workerId, agentId+"", value, null);
			}
		}

		
	public void appendUserInfo_head(HuawuUser mfoyouUser) {
		redisCacheManger.hset("u:" + mfoyouUser.getUserId(),"userHeadUrl",  mfoyouUser.getUserHeadUrl());
	}

}
