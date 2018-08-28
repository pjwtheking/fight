/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName RedisService.java
 * @author Eric
 * @date 2018年8月16日 下午9:08:22  
 */
package com.redis.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

/** 
 * @Description: Redis服务接口

 * @author Eric
 * @date 2018年8月16日 下午9:08:22  
 */
public interface RedisService {
	
	//=====================普通缓存==========================
	/**
	 * 放入缓存
	 */
	void set(String key,Object value);
	/**
	 * 获取缓存
	 */
	Object get(String key);
	/**
	 * 缓存放入并设置时间
	 * @param key 键
	 * @param value 值
	 * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
	 */
	public void set(String key,Object value,long time);
	/**
	 * 指定key的有效时间
	 * @param key
	 * @param time 秒
	 */
	void setExpire(String key,long time);
	/**
	 * 删除缓存
	 */
	void del(String key);
	/**
	 * 追加缓存（未实现）
	 */
	void append(String key,String value);
	/**
	 * 递增
	 * @param key
	 * @param inrc 要增加几(大于0
	 * @return long
	 */
	long incr(String key, long inrc);
	/**
	 * 递减
	 * @param key 键
	 * @param by 要减少几(小于0)
	 * @return
	 */
	public long decr(String key, long decr);	
	/**
	 * 获取key的有效时间
	 * @return long 秒
	 */
	long getExpireTime(String key);
	/**
	 * 判断key是否存在
	 * @param key
	 * @return boolean
	 */
	boolean isExist(String key);
	
	//==========================set==========================
	/**
	 * 将Set放入缓存
	 */
	long sset(String key, Object...values);
	/**
	 * 将Set放入缓存   并设置时间
	 * @param key 键
	 * @param time 时间(秒)
	 * @param values 值 可以是多个
	 * @return 成功个数
	 */
	long sset(String key,long time,Object...values);
	/**
	 * 获取Set
	 */
	Set<Object> sget(String key);
	/**
	 * 从Set中移除值为value的元素
	 * @param key 键
	 * @param values 值 可以是多个
	 * @return 移除的个数
	 */
	public long sdel(String key, Object ...values);
	/**
	 * 获取Set的长度
	 */
	Long slen(String key);
	/**
	 * 判断value是否存在Set当中
	 */
	boolean sexist(String key,Object value);
	
	//========================== Hash or Map ==========================
	/**
	 * 向一张Hash表中放入数据,如果不存在将创建
	 * @param key 键
	 * @param item 项
	 * @param value 值
	 */
	public void hset(String key,String item,Object value);
	/**
	 * 向一张hash表中放入数据,如果不存在将创建
	 * @param key 键
	 * @param item 项
	 * @param value 值
	 * @param time 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
	 */
	public void hset(String key,String item,Object value,long time);
	/**
	 * 获取Hash
	 * @param key 键 不能为null
	 * @param item 项 不能为null
	 * @return 值
	 */
	public Object hget(String key, String item);
	/**
	 * 删除hash表中的值
	 * @param key 键 不能为null
	 * @param item 项 可以使多个 不能为null
	 */
    public void hdel(String key, Object... item);
	/**
	 * 将Map放入缓存
	 */
	void hmset(String key, Map<String, String> map);
	/**
	 * 将Map放入缓存   并设置时间
	 * @param key 键
	 * @param map 对应多个键值
	 * @param time 时间(秒)
	 */
	void hmset(String key, Map<String,Object> map, long time);
	/**
	 * 获取Map
	 */
	Map<Object,Object> hmget(String key);
	/**
	 * 获取Map中所有key
	 */
	Set<Object> hmkeys(String key);
	
	//==========================list==========================
	/**
	 * 将List放入缓存
	 */
	public void lset(String key, List<Object> value);
	/**
	 * 将List放入缓存    并设置时间
	 * @param key 键
	 * @param value 值
	 * @param time 时间(秒)
	 * @return
	 */
	public void lset(String key, List<Object> value, long time);
	/**
	 * 向List的头部添加元素（从左往右添加元素）
	 */
	void lpush(String key, Object value);
	/**
	 * 向List的尾部添加元素（从右到左添加元素）
	 */
	void rpush(String key, Object value);
	/**
	 * 获取List
	 * @param key 键
	 * @param start 开始
	 * @param end 结束  0 到 -1代表所有值
	 */
	List<Object> lget(String key,Long start,Long end);
	/**
	 * 获取List的长度
	 * @param key 键
	 * @return
	 */
	public long lsize(String key);
	/**
	 * 通过索引 获取List中的值
	 * @param key 键
	 * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
	 * @return
	 */
	public Object lGetIndex(String key,long index);
	/**
	 * 根据索引修改List中的某条数据
	 * @param key 键
	 * @param index 索引
	 * @param value 值
	 * @return
	 */
	public void lUpdateIndex(String key, long index, Object value);
	/**
	 * 从左边列表移除第一个元素并返回这个元素
	 * @param key 键
	 */
	void lpop(String key);
	/**
	 * 从右边列表移除第一个元素并返回这个元素
	 * @param key 键
	 */
	void rpop(String key);
	/**
	 * 移除N个值为value的元素
	 * @param key 键
	 * @param count 移除多少个
	 * @param value 值
	 * @return 移除的个数
	 */
	public long lrem(String key, long count, Object value);
	
	
	//===========================通用===========================
	/***
	 * 获取锁
	 * @param key 锁键
	 * @return 锁值
	 */
	boolean lock(String key);

}
