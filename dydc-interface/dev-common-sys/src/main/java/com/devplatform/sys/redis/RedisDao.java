package com.devplatform.sys.redis;

import java.util.List;
import java.util.Set;

public interface RedisDao {
	/**
	 * 新增 <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	boolean add(String key, String value);

	/**
	 * set <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	Object set(String key, String value);

	/**
	 * set <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	Boolean setNx(String key, String value);

	/**
	 * 批量新增 使用pipeline方式 <br>
	 * ------------------------------<br>
	 * 
	 * @param list
	 * @return
	 */
	// boolean add(List<User> list);

	/**
	 * 删除 <br>
	 * ------------------------------<br>
	 * 
	 * @param key
	 * @return
	 */
	void delete(String key);

	/**
	 * 删除多个 <br>
	 * ------------------------------<br>
	 * 
	 * @param keys
	 */
	// void delete(List<String> keys);

	/**
	 * 修改 <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	boolean update(String key, String value);

	/**
	 * 通过key获取 <br>
	 * ------------------------------<br>
	 * 
	 * @param keyId
	 * @return
	 */

	String get(String keyId);
	
	/**
	 * 添加 <br>
	 * @param key
	 * @param strs
	 * @return list长度
	 */
	Long lpush(String key , String strs);
	
	/**
	 * 通过key从list的头部删除一个value,并返回该value</p> 
	 * @param key
	 * @return 
	 */
	String lpop(String key );
	
	/**
	 * 通过key返回该list指定下标的value</p> 
	 * @param key
	 * @param beginIndxe
	 * @param endIndxe
	 * @return 
	 */
	List<String> lrange(String key ,long beginIndxe ,long endIndxe);

	/**
	 * 设置超时
	 * 
	 * @param key
	 * @param timeout
	 *            时间单位为秒
	 */
	public void expire(String key, long timeout);

	/**
	 * 获取分布式锁
	 * 
	 * @param lockName
	 *            竞争获取锁key
	 * @param acquireTimeoutInMS
	 *            获取锁超时时间 单位 毫秒
	 * @param lockTimeoutInMS
	 *            锁的超时时间 单位 毫秒 expire Time
	 * @return 获取锁标识
	 */
	public String acquireLockWithTimeout(final String lockName, final long acquireTimeoutInMS, final long lockTimeoutInMS);

	/**
	 * 释放锁
	 * 
	 * @param lockName
	 *            竞争获取锁key
	 * @param identifier
	 *            释放锁标识
	 * @return
	 */
	public boolean releaseLock(final String lockName, final String identifier);

	public String getkeys(final String keyId, final String fgf);

	/**
	 * 获取对应key的全部结果
	 * @param key
	 * @return
	 */
	public Set<String> getMembers(final String key);
	/**
	 * 设置值
	 * @param key
	 * @return
	 */
	public Long setMembers(final String key,final String... values);
}
