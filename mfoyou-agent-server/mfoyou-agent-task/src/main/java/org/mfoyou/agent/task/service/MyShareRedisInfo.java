package org.mfoyou.agent.task.service;

import redis.clients.jedis.JedisShardInfo;

public class MyShareRedisInfo extends JedisShardInfo{
	private int db=0;
	public MyShareRedisInfo(String host, int port, int db) {
		super(host, port);
		this.setDb(db);
	}
	public int getDb() {
		return db;
	}
	public void setDb(int db) {
		this.db = db;
	}
}
