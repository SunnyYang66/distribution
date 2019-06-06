package com.mfoyou.agent.web.utils.redis;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.common.StrUtil;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.ShardedJedisPool;

public class RedisCacheManger {

	private ShardedJedisPool pool;
	private Logger log = Logger.getLogger(RedisCacheManger.class);

	public ShardedJedisPool getPool() {
		return pool;
	}

	public void setPool(ShardedJedisPool pool) {
		this.pool = pool;
	}

	public ShardedJedis getRedis() {
	    ShardedJedis jedis = pool.getResource();
	    if(jedis == null){
	        log.error("jedis is null");
	    }
	    return jedis;
	}

	public void releaseRedis(ShardedJedis jedis) {
	    jedis.close();
	}

	public String getValue(String key) {
		ShardedJedis jedis = pool.getResource();
		String ret = null;
		try {
			ret = jedis.get(key);
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
		jedis.close();
		return ret;
	}
	public Integer getIntValue(String key) {
		ShardedJedis jedis = pool.getResource();
		Integer ret = null;
		try {
			ret = StrUtil.parseInteger(jedis.get(key));
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
		jedis.close();
		return ret;
	}

	public boolean setValue(String key, String value, int seconds) {
		ShardedJedis jedis = pool.getResource();
		try {
			ShardedJedisPipeline shardedJedisPipeline = jedis.pipelined();
			shardedJedisPipeline.set(key, value);
			shardedJedisPipeline.expire(key, seconds);
			shardedJedisPipeline.sync();
		} catch (Exception e) {

			log.error("", e);
			e.printStackTrace();
			jedis.close();
			return false;

		}
		jedis.close();
		return true;
	}
	public boolean setValue(String key, Integer value, int seconds){
		return setValue(key,""+value,seconds);
	}

	public Map<String, String> getMapValue(String key) {
		ShardedJedis jedis = pool.getResource();
		Map<String, String> map = null;
		try {
			map = jedis.hgetAll(key);
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
		jedis.close();
		return map;
	}

	public Map<byte[], byte[]> getMapValue(byte[] key) {
		ShardedJedis jedis = pool.getResource();
		Map<byte[], byte[]> map = null;
		try {
			map = jedis.hgetAll(key);
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
		jedis.close();
		return map;
	}

	public boolean setMapValue(String key, Map<String, String> map, int seconds) {
	    MfoyouMap.removeNullValue(map);
	    if(map.size() == 0){
	        return true;
	    }
	    log.info("set map:ket="+key+"value="+map.toString());
		ShardedJedis jedis = pool.getResource();
		try {
			jedis.hmset(key, map);
			jedis.expire(key, seconds);
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
			jedis.close();
			return false;
		}
		jedis.close();
		return true;
	}

	public boolean setMapValue(byte[] key, Map<byte[], byte[]> map, int seconds) {
		ShardedJedis jedis = pool.getResource();
		try {
			jedis.hmset(key, map);
			jedis.expire(key, seconds);
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
			jedis.close();
			return false;
		}
		jedis.close();
		return true;
	}
	
	public boolean setMapKeyValue(String mainKey,String mapKey,String value,Integer seconds) {
	    if(mainKey== null || mapKey == null || value == null)return false;
		ShardedJedis jedis = pool.getResource();
		try {
			jedis.hset(mainKey, mapKey, value);
			if(seconds != null)jedis.expire(mainKey, seconds);
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
			jedis.close();
			return false;
		}
		jedis.close();
		return true;
	}
	public boolean IncMapKeyValue(String mainKey,String mapKey,Integer incValue,Integer seconds) {
		ShardedJedis jedis = pool.getResource();
		try {
			jedis.hincrBy(mainKey, mapKey,incValue);
			if(seconds != null)jedis.expire(mainKey, seconds);
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
			jedis.close();
			return false;
		}
		jedis.close();
		return true;
	}

	public boolean deleteKey(String key) {
		ShardedJedis jedis = pool.getResource();
		log.info("deleteKey:"+key);
		try {
			jedis.del(key);
		} catch (Exception e) {

			log.error("", e);
			e.printStackTrace();
			jedis.close();
			return false;

		}
		jedis.close();
		return true;
	}
	
	//集群，分片模式下不能使用此函数不然会有问题的
    @Deprecated
    public Set<String> keys(String pattern) {
        Set<String> set = null;
        ShardedJedis jedis = pool.getResource();
        try {
            set = jedis.getShard(pattern).keys(pattern);
        } catch (Exception e) {

            log.error("", e);
            jedis.close();
            return new HashSet<>();

        }
        jedis.close();
        return set;
    }


	public boolean setExpire(String key, int seconds) {
		ShardedJedis jedis = pool.getResource();
		try {
			jedis.expire(key, seconds);
		} catch (Exception e) {

			log.error("", e);
			e.printStackTrace();
			jedis.close();
			return false;

		}
		jedis.close();
		return true;
	}

	public boolean exists(String key) {
		ShardedJedis jedis = pool.getResource();
		boolean bret = false;
		try {
			bret = jedis.exists(key);

		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
			jedis.close();
			return false;

		}
		jedis.close();
		return bret;
	}

	public Long getIncr(String key) {
		ShardedJedis jedis = pool.getResource();
		Long ret = null;
		try {
			ret = jedis.incr(key);
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
		jedis.close();
		return ret;
	}
	public Long getIncr(String key, int seconds) {
		ShardedJedis jedis = pool.getResource();
		Long ret = null;
		try {
			ShardedJedisPipeline shardedJedisPipeline = jedis.pipelined();
			shardedJedisPipeline.incr(key);
			shardedJedisPipeline.expire(key, seconds);
			List<Object> list = shardedJedisPipeline.syncAndReturnAll();
			ret = (Long) (list.get(0));
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
		jedis.close();
		return ret;
	}

	public Long pushSet(String key, String value, Integer seconds) {
		ShardedJedis jedis = pool.getResource();
		Long ret = Long.MAX_VALUE;
		try {
			ShardedJedisPipeline shardedJedisPipeline = jedis.pipelined();
			shardedJedisPipeline.sadd(key, value);
			shardedJedisPipeline.scard(key);
			if(seconds != null)shardedJedisPipeline.expire(key, seconds);
			List<Object> list = shardedJedisPipeline.syncAndReturnAll();
			ret = (Long) (list.get(0));
			if (ret != 0) {
				ret = (Long) (list.get(1));
			}
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
		jedis.close();
		return ret;
	}

	public Long pushSet(String key, Set<String> value, int seconds) {
		ShardedJedis jedis = pool.getResource();
		try {
			ShardedJedisPipeline shardedJedisPipeline = jedis.pipelined();
			for (String t : value)
				shardedJedisPipeline.sadd(key, t);
			shardedJedisPipeline.expire(key, seconds);
			shardedJedisPipeline.sync();
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
		jedis.close();
		return 1L;
	}
	
	public Long scardSet(String key){
		ShardedJedis jedis = pool.getResource();
		Long ret =  jedis.scard(key);
		jedis.close();
		return ret;		
	}

	public Long getSetExistValue(String key, String value, int seconds) {
		ShardedJedis jedis = pool.getResource();
		Long ret = -1L;
		try {
			ShardedJedisPipeline shardedJedisPipeline = jedis.pipelined();
			shardedJedisPipeline.exists(key);
			shardedJedisPipeline.sismember(key, value);
			shardedJedisPipeline.expire(key, seconds);
			List<Object> list = shardedJedisPipeline.syncAndReturnAll();
			Boolean br = (Boolean) (list.get(0));
			if (br) {
				ret = ((Boolean) (list.get(1))) ? 1L : 0L;
			}
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
		jedis.close();
		return ret;
	}
	public Set<String> getSetValue(String key) {
		ShardedJedis jedis = pool.getResource();
		Set<String> set = null;
		try {
			set = jedis.smembers(key);
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
		jedis.close();
		return set;
	}

	public Long removeSetValue(String key, String value) {
		ShardedJedis jedis = pool.getResource();
		Long ret = jedis.srem(key, value);
		jedis.close();
		return ret;
	}

	public void pushRList(String key, String value) {
		ShardedJedis jedis = pool.getResource();
		jedis.rpush(key, value);
		jedis.close();
	}
	public void pushRListx(String key, String... value) {
		ShardedJedis jedis = pool.getResource();
		jedis.rpushx(key, value);
		jedis.close();
	}

	public String popLList(String key) {
		ShardedJedis jedis = pool.getResource();
		String string = jedis.lpop(key);
		jedis.close();
		return string;
	}
	public String hget(String key,String field) {
		ShardedJedis jedis = pool.getResource();
		String string = jedis.hget(key, field);
		jedis.close();
		return string;
	}
	public void hset(String key,String field,String value){
		ShardedJedis jedis = pool.getResource();
		jedis.hset(key, field, value);
		jedis.close();
	}
	public void hremove(String key,String field){
		ShardedJedis jedis = pool.getResource();
		jedis.hdel(key, field);
		jedis.close();
	}
	public void srem(String key,String value){ 
		ShardedJedis jedis = pool.getResource();
		jedis.srem(key, value);
		jedis.close();
	}
}