package com.mfoyou.agent.web.service.common;

import java.awt.Polygon;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.PolygonArea;
import org.mfoyou.agent.utils.common.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.params.geo.GeoRadiusParam;

@Service
public class GeoService {

    @Autowired
    private RedisCacheManger redisCacheManger;

    private static Logger    logger         = Logger.getLogger(GeoService.class);

    private static String    RUNERPOS       = "pos:runer:";
    private static String    AGENTREGION    = "pos:agent";
    private static String    REGIONCUSTOMER = "pos:region:";
    private static String    ORDERPOS       = "pos:order";

    public void addOrderPos(Double lon, Double lat, String orderId) {
        ShardedJedis jedis = redisCacheManger.getRedis();
        try {
             jedis.geoadd(ORDERPOS, lon, lat, orderId);
        } catch (Exception e) {
            logger.error("", e);
        } finally {
            redisCacheManger.releaseRedis(jedis);
        }
    }

    public void removeOrderPos(String... orderId) {
        ShardedJedis jedis = redisCacheManger.getRedis();

        try {
             jedis.zrem(ORDERPOS, orderId);

        } catch (Exception e) {
            logger.error("", e);
        } finally {
            redisCacheManger.releaseRedis(jedis);
        }
    }

    public List<GeoRadiusResponse> getOrder(Double lon, Double lat, int distane) {

        List<GeoRadiusResponse> ret = null;
        ShardedJedis jedis = redisCacheManger.getRedis();
        try {
            ret = jedis.georadius(ORDERPOS, lon, lat, distane, GeoUnit.M, GeoRadiusParam.geoRadiusParam().sortAscending().withDist().withCoord());

        } catch (Exception e) {
            logger.error("", e);
        } finally {
            redisCacheManger.releaseRedis(jedis);
        }
        return ret;
    }

    /////////////////////////////////////////////////////////////////////////////////////

    public void updateRunerPos(Double lon, Double lat, Integer runerId, Integer agentId) {
        ShardedJedis jedis = redisCacheManger.getRedis();
        if (agentId == null)
            agentId = 0;
        try {
             jedis.geoadd(RUNERPOS + agentId, lon, lat, runer_makeKey("" + runerId));

        } catch (Exception e) {
            logger.error("", e);
        } finally {
            redisCacheManger.releaseRedis(jedis);
        }
    }

    public void removeRunerPos(Integer agentId, Integer... runerId) {
        ShardedJedis jedis = redisCacheManger.getRedis();

        try {
            for (int i = 0; i < runerId.length; i++) {
                jedis.zrem(RUNERPOS + agentId, runer_makeKey("" + runerId[i]));
            }

        } catch (Exception e) {
            logger.error("", e);
        } finally {
            redisCacheManger.releaseRedis(jedis);
        }
    }

    public List<GeoRadiusResponse> getRuner(Integer agentId, Double lon, Double lat, int distane) {

        List<GeoRadiusResponse> ret = null;
        ShardedJedis jedis = redisCacheManger.getRedis();
        try {
            ret = jedis.georadius(RUNERPOS + agentId, lon, lat, distane, GeoUnit.M, GeoRadiusParam.geoRadiusParam().sortAscending().withDist().withCoord());
        } catch (Exception e) {
            logger.error("", e);
        } finally {
            redisCacheManger.releaseRedis(jedis);
        }
        return ret;
    }

    public static String runer_getUserId(String s) {
        String[] strings = s.split("\\|\\|");
        return strings[0];
    }

    public static String runer_makeKey(String... s) {
        String result = s[0];

        for (int i = 1; i < s.length; i++) {
            result += ("\\|\\|" + s[i]);
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////

    public static String agent_getAgentId(String s) {
        String[] strings = s.split("\\|\\|");
        if (strings.length >= 2)
            return strings[0];
        strings = s.split("\\\\\\|\\\\\\|");
        if (strings.length >= 2)
            return strings[0];
        return strings[0];
    }

    public static String agent_getRegionId(String s) {
        String[] strings = s.split("\\|\\|");
        if (strings.length >= 2)
            return strings[1];
        strings = s.split("\\\\\\|\\\\\\|");
        if (strings.length >= 2)
            return strings[1];
        return null;
    }
//    public static void main(String[] ss){
//        String string =  agent_getRegionId("41\\|\\|40");
//    }

    public static String agent_makeKey(Object... s) {
        String result = "" + s[0];

        for (int i = 1; i < s.length; i++) {
            result += ("\\|\\|" + s[i]);
        }
        return result;
    }
//
//    public void addAgent(MfoyouRegionCustom mfoyouRegionCustom) {
//        ShardedJedis jedis = redisCacheManger.getRedis();
//        try {
//            String key = agent_makeKey(mfoyouRegionCustom.getAgentId(), mfoyouRegionCustom.getRegionCustomId());
//            jedis.geoadd(AGENTREGION, mfoyouRegionCustom.getRegionCustomLon(), mfoyouRegionCustom.getRegionCustomLat(), key);
//            jedis.set(REGIONCUSTOMER + mfoyouRegionCustom.getRegionCustomId(), mfoyouRegionCustom.getAgentCoordinateArea());
//        } catch (Exception e) {
//            logger.error("", e);
//        } finally {
//            redisCacheManger.releaseRedis(jedis);
//        }
//    }

    public void removeAgent(Integer agent, Integer regionId) {
        ShardedJedis jedis = redisCacheManger.getRedis();
        try {
            String key = agent_makeKey(agent, regionId);
            jedis.zrem(AGENTREGION, key);
            jedis.del(REGIONCUSTOMER + regionId);
        } catch (Exception e) {
            logger.error("", e);
        } finally {
            redisCacheManger.releaseRedis(jedis);
        }
    }

//    public MfoyouRegionCustom getNearAgent(Double lon, Double lat) {
//
//        ShardedJedis jedis = redisCacheManger.getRedis();
//        GeoRadiusResponse minGeoRadiusResponse = null;
//        try {
//            List<GeoRadiusResponse> ret = jedis.georadius(AGENTREGION, lon, lat, 10000, GeoUnit.M, GeoRadiusParam.geoRadiusParam().sortAscending().withDist().withCoord());
//            if (ret.size() > 0) {
//                minGeoRadiusResponse = ret.get(0);
//                for (int i = 1; i < ret.size(); i++) {
//                    if (ret.get(i).getDistance() < minGeoRadiusResponse.getDistance()) {
//                        minGeoRadiusResponse = ret.get(i);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            logger.error("", e);
//        } finally {
//            redisCacheManger.releaseRedis(jedis);
//        }
//        if (minGeoRadiusResponse != null) {
//            MfoyouRegionCustom mfoyouRegionCustom = new MfoyouRegionCustom();
//            mfoyouRegionCustom.setRegionCustomLon(minGeoRadiusResponse.getCoordinate().getLongitude());
//            mfoyouRegionCustom.setRegionCustomLat(minGeoRadiusResponse.getCoordinate().getLatitude());
//            String key = minGeoRadiusResponse.getMemberByString();
//            mfoyouRegionCustom.setAgentId(StrUtil.parseInteger(agent_getAgentId(key)));
//            mfoyouRegionCustom.setRegionCustomId(StrUtil.parseInteger(agent_getRegionId(key)));
//            return mfoyouRegionCustom;
//        }
//        return null;
//    }

    public Map<Integer, Integer> getNearRegionList(Double lon, Double lat) {

        ShardedJedis jedis = redisCacheManger.getRedis();
        GeoRadiusResponse minGeoRadiusResponse = null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        try {
            List<GeoRadiusResponse> ret = jedis.georadius(AGENTREGION, lon, lat, 10000, GeoUnit.M, GeoRadiusParam.geoRadiusParam().sortAscending().withDist().withCoord());
            logger.info("getNearRegionList:"+JSON.toJSONString(ret));
            for (int i = 0; i < ret.size(); i++) {
                minGeoRadiusResponse = ret.get(i);
                String key = minGeoRadiusResponse.getMemberByString();
                // reginId,agentId
                map.put(StrUtil.parseInteger(agent_getRegionId(key)), StrUtil.parseInteger(agent_getAgentId(key)));
            }
            return map;
        } catch (Exception e) {
            logger.error("", e);
        } finally {
            redisCacheManger.releaseRedis(jedis);
        }
        return map;
    }

    public Integer getInsideAgent(Double lon, Double lat) {

        Map<Integer, Integer> map = getNearRegionList(lon, lat);
        Set<Integer> regonIds = map.keySet();
        for (Integer regonId : regonIds) {
            logger.info("begin:"+map.get(regonId)+","+regonId);
            String value = redisCacheManger.getValue(REGIONCUSTOMER + regonId);
            try {
                if (value != null && (!value.equals(""))) {
                    PolygonArea polygonArea = JSON.parseObject(value, PolygonArea.class);
                    if (polygonArea == null)
                        {
                        logger.error("no polygonArea");
                            continue;
                        }
                    Polygon polygon = polygonArea.makePolygon(1000000);
                    if (polygon.contains( lon * 1000000,lat * 1000000)) {
                        logger.info("getInsideAgent:"+map.get(regonId)+","+regonId);
                        return map.get(regonId);
                    }
                }
            } catch (Exception e) {
                logger.error("", e);
            }
        }
        return null;
    }

//	public Integer getStationId(Double lon, Double lat,List<MfoyouStationMaster> mfoyouStationMasters,int type) {
//		for(MfoyouStationMaster mfoyouStationMaster : mfoyouStationMasters){
//			if((mfoyouStationMaster.getPowerState() & (0x01 << type))  == 0) continue;
//			String json = mfoyouStationMaster.getAgentCoordinateArea();
//			if(json == null) continue;
//			PolygonArea polygonArea = null;
//			try{
//				polygonArea = JSON.parseObject(json, PolygonArea.class);
//			}catch (Exception e) {
//				logger.error("error "+json);
//				continue;
//			}
//			Polygon polygon = polygonArea.makePolygon(1000000);
//			if (polygon.contains( lon * 1000000,lat * 1000000)) {
//                 logger.info("station id  is "+mfoyouStationMaster.getStationId());
//                 return mfoyouStationMaster.getStationId();
//            }
//		}
//		return null;
//	}
//	public Boolean isInstationArea(Double lon, Double lat,MfoyouStationMaster mfoyouStationMaster,int type) {
//		
//			if((mfoyouStationMaster.getPowerState() & (0x01 << type))  == 0) return false;
//			String json = mfoyouStationMaster.getAgentCoordinateArea();
//			if(json == null) return false;
//			PolygonArea polygonArea = null;
//			try{
//				polygonArea = JSON.parseObject(json, PolygonArea.class);
//			}catch (Exception e) {
//				logger.error("error "+json);
//				
//			}
//			Polygon polygon = polygonArea.makePolygon(1000000);
//			if (polygon.contains( lon * 1000000,lat * 1000000)) {
//                 logger.info("station id  is "+mfoyouStationMaster.getStationId());
//                 return true;
//            }
//		return false;
//	}

}
