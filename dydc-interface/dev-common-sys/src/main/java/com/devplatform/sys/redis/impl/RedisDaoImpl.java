package com.devplatform.sys.redis.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.devplatform.sys.redis.RedisDao;
import com.devplatform.sys.redis.template.AbstractBaseRedisDao;

public class RedisDaoImpl extends AbstractBaseRedisDao<String, Object> implements RedisDao {

	public static final String REDIS_USER = "redis_user_";
	
	public static final String REDIS_ACTIVE = "redis_active_";

	public static final String REDIS_UCOURSE = "redis_ucourse_";

	public static final String REDIS_USER_FGF = "|";

	/**
	 * Dao
	 * 
	 * @author http://blog.csdn.net/java2000_wl
	 * @version <b>1.0</b>
	 */

	/**
	 * 设置时间超时
	 * 
	 * @param key
	 * @param timeout
	 */
	// public void expire(String key,long timeout){
	// redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
	// }
	//

	/**
	 * 超时<br>
	 * ------------------------------<br>
	 * 
	 * @param list2
	 */

	@Override
	public void expire(final String key, final long timeout) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) {
				connection.expire(redisTemplate.getStringSerializer().serialize(key), timeout);
				return null;
			}
		});
	}

	/**
	 * set <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	public Object set(final String key, final String value) {
		return redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keys = serializer.serialize(key);
				byte[] names = serializer.serialize(value);
				connection.set(keys, names);
				return null;
			}
		});
	}

	/**
	 * setNx <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	public Boolean setNx(final String key, final String value) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keys = serializer.serialize(key);
				byte[] names = serializer.serialize(value);
				return connection.setNX(keys, names);
			}
		});
	}

	/**
	 * add <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	public boolean add(final String key, final String value) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keys = serializer.serialize(key);
				byte[] names = serializer.serialize(value);
				return connection.setNX(keys, names);
			}
		});
		return result;
	}

	/**
	 * 批量新增 使用pipeline方式 <br>
	 * ------------------------------<br>
	 * 
	 * @param list
	 * @return
	 */
	/*
	 * public boolean add(final List<User> list) { Assert.notEmpty(list);
	 * boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
	 * public Boolean doInRedis(RedisConnection connection) throws
	 * DataAccessException { RedisSerializer<String> serializer =
	 * getRedisSerializer(); for (User user : list) { byte[] key =
	 * serializer.serialize(user.getId()); byte[] name =
	 * serializer.serialize(user.getName()); connection.setNX(key, name); }
	 * return true; } }, false, true); return result; }
	 */
	/**
	 * 删除 <br>
	 * ------------------------------<br>
	 * 
	 * @param list2
	 */

	@Override
	public void delete(final String keyId) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) {
				connection.del(redisTemplate.getStringSerializer().serialize(keyId));
				return null;
			}
		});
	}

	/**
	 * 删除多个 <br>
	 * ------------------------------<br>
	 * 
	 * @param keys
	 */
	/*
	 * public void delete(List<String> keys) { redisTemplate.delete(keys); }
	 */
	/**
	 * 修改 <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(final String key, final String value) {
		if (get(key) == null) {
			throw new NullPointerException("数据行不存在, key = " + key);
		}
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keys = serializer.serialize(key);
				byte[] names = serializer.serialize(value);
				connection.set(keys, names);
				return true;
			}
		});
		return result;
	}
	
	/**
	 * 添加 <br>
	 * @param key
	 * @param strs
	 * @return list长度
	 */
	public Long lpush(final String key , final String strs) {
		Long res = (Long) redisTemplate.execute(new RedisCallback<Object>() {
			public Long doInRedis(RedisConnection connection) {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keys = serializer.serialize(key);
				byte[] value = serializer.serialize(strs);
				return connection.lPush(keys, value);
			}
		});
		return res;
	}
	
	/**
	 * 通过key从list的头部删除一个value,并返回该value</p> 
	 * @param key
	 * @return 
	 */
	public String lpop(final String key ) {
		 String res = (String) redisTemplate.execute(new RedisCallback<Object>() {
			synchronized public String doInRedis(RedisConnection connection) {
				return new String(connection.lPop(key.getBytes()));  
			}
		});
		return res;
	}
	
	/**
	 * 通过key返回该list指定下标的value</p> 
	 * @param key
	 * @param beginIndxe
	 * @param endIndxe
	 * @return 
	 */
	public List<String> lrange(final String key ,final long beginIndxe ,final long endIndxe) {
		
		@SuppressWarnings("unchecked")
		List<String> resList = (List<String>) redisTemplate.execute(new RedisCallback<Object>() {
			synchronized public List<String> doInRedis(RedisConnection connection) {
				RedisSerializer<String> serializer = getRedisSerializer();
				List<String> serializerStringList = new ArrayList<String>();
				byte[] keys = serializer.serialize(key);
				List<byte[]> lRange = connection.lRange(keys, beginIndxe, endIndxe);
				if (lRange == null) {
					return null;
				}
				for (byte[] bs : lRange) {
					String value = serializer.deserialize(bs);
					serializerStringList.add(value);
				}
				return serializerStringList;
			}
		});
		return resList;
	}

	/**
	 * 通过key获取 <br>
	 * ------------------------------<br>
	 * 
	 * @param keyId
	 * @return
	 */
	@Override
	public String get(final String keyId) {
		String result = redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(keyId);
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				String name = serializer.deserialize(value);
				return new String(name);
			}
		});
		return result;
	}

	/**
	 * 通过key获取 (模糊搜索)<br>
	 * 
	 * @param keyString
	 * @return
	 */
	@Override
	public String getkeys(final String keyString, final String fgf) {
		String result = redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				// System.out.println("----"+keyString+"----"+fgf);
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(keyString);
				Set<byte[]> values = connection.keys(key);
				if (values == null) {
					return null;
				}
				String name = "";
				for (byte[] v : values) {
					name += serializer.deserialize(v) + fgf;
				}
				return name;
			}
		});
		return result;
	}

	/*
	 * @Override public SiteNews getId(final String keyId) { SiteNews result =
	 * redisTemplate.execute(new RedisCallback<SiteNews>() {
	 * 
	 * @Override public SiteNews doInRedis(RedisConnection connection) throws
	 * DataAccessException { RedisSerializer<String> serializer =
	 * getRedisSerializer(); byte[] key = serializer.serialize(keyId);
	 * connection.keys(key); serializer.deserialize(key); return null ; } });
	 * return null; }
	 */
	/**
	 * 获取分布式锁
	 * 
	 * @param lockName
	 *            竞争获取锁key
	 * @param acquireTimeoutInMS
	 *            获取锁超时时间 单位 毫秒
	 * @param lockTimeoutInMS
	 *            锁的超时时间 单位 毫秒
	 * @return 获取锁标识
	 */
	public String acquireLockWithTimeout(final String lockName, final long acquireTimeoutInMS, final long lockTimeoutInMS) {

		String result = redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection conn) throws DataAccessException {

				String retIdentifier = null;
				RedisSerializer<String> serializer = getRedisSerializer();
				String identifier = java.util.UUID.randomUUID().toString();
				String lockKey = "lock:" + lockName;
				int lockExpire = (int) (lockTimeoutInMS / 1000);
				long end = System.currentTimeMillis() + acquireTimeoutInMS;

				while (System.currentTimeMillis() < end) {
					if (conn.setNX(serializer.serialize(lockKey), serializer.serialize(identifier))) {
						conn.expire(serializer.serialize(lockKey), lockExpire);
						retIdentifier = identifier;
						return retIdentifier;
					}
					if (conn.ttl(serializer.serialize(lockKey)) == -1) {// 查看是否超时，-1是未超时，-2是无此key
						conn.expire(serializer.serialize(lockKey), lockExpire);
					}

					try {
						Thread.sleep(5);
					} catch (InterruptedException ie) {
						Thread.currentThread().interrupt();
					}
				}
				return retIdentifier;
			}
		});
		return result;
	}

	/**
	 * 释放锁
	 * 
	 * @param lockName
	 *            竞争获取锁key
	 * @param identifier
	 *            释放锁标识
	 * @return
	 */
	public boolean releaseLock(final String lockName, final String identifier) {

		Boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection conn) throws DataAccessException {
				String lockKey = "lock:" + lockName;
				boolean retFlag = false;
				RedisSerializer<String> serializer = getRedisSerializer();
				while (true) {
					conn.watch(serializer.serialize(lockKey));
					if (identifier.equals(serializer.deserialize(conn.get(serializer.serialize(lockKey))))) {
						conn.multi();
						conn.del(serializer.serialize(lockKey));
						List<Object> results = conn.exec();
						if (results == null) {
							continue;
						}
						retFlag = true;
					}
					conn.unwatch();
					break;
				}
				return retFlag;
			}
		});
		return result;
	}

	
	public Set<String> getMembers(final String key) {
		Set<String> result = redisTemplate.execute(new RedisCallback<Set<String>>() {
			public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keys = serializer.serialize(key);
				Set<byte[]> rb = connection.sMembers(keys);
				if(rb == null){
					 return null;
				}
				Set<String> reset = new HashSet<String>();
				for(byte[] r:rb){
					reset.add(serializer.deserialize(r));
				}
				return reset;
			}
		});
		return result;
	}
	public Long setMembers(final String key,final String... values) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keys = serializer.serialize(key);
				long count=0;
				if(values!=null){
					for(String v:values){
						count+=connection.sAdd(keys, serializer.serialize(v));
					}
				}
				return count;
			}
		});
	}

}
