/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName RedisServiceImpl.java
 * @author Eric
 * @date 2018年8月19日 下午9:00:21  
 */
package com.redis.api.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;

import com.redis.api.RedisDistributedLock;
import com.redis.api.RedisService;

/** 
 * @Description: Redis服务实现

 * @author Eric
 * @date 2018年8月19日 下午9:00:21  
 */
public class RedisServiceImpl implements RedisService {
	
	@Resource(name="redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public void set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	public void set(String key, Object value, long time) {
		redisTemplate.opsForValue().set(key, value, time);
	}

	public void setExpire(String key, long time) {
		redisTemplate.expire(key, time, TimeUnit.SECONDS);
	}

	public void del(String key) {
		redisTemplate.delete(key);
	}

	public void append(String key, String value) {
		
	}

	public long incr(String key, long inrc) {
		if(inrc < 0){
			throw new RuntimeException("Redis递增元素必须大于0");
		}
		return redisTemplate.opsForValue().increment(key, inrc);
	}

	public long decr(String key, long decr) {
		if(decr < 0){
			throw new RuntimeException("Redis递减元素必须大于0");
		}
        return redisTemplate.opsForValue().increment(key, -decr); 
	}

	public long getExpireTime(String key) {
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}

	public boolean isExist(String key) {
		return redisTemplate.hasKey(key);
	}

	public long sset(String key, Object... values) {
		return redisTemplate.opsForSet().add(key, values);
	}

	public long sset(String key, long time, Object... values) {
		Long count = redisTemplate.opsForSet().add(key, values);
    	if(time>0) setExpire(key, time);
    	return count;
	}

	public Set<Object> sget(String key) {
		return redisTemplate.opsForSet().members(key);
	}

	public long sdel(String key, Object... values) {
		Long count = redisTemplate.opsForSet().remove(key, values);
        return count;
	}

	public Long slen(String key) {
		return redisTemplate.opsForSet().size(key);
	}

	public boolean sexist(String key, Object value) {
		return redisTemplate.opsForSet().isMember(key, value);
	}

	public void hset(String key, String item, Object value) {
		redisTemplate.opsForHash().put(key, item, value);
	}

	public void hset(String key, String item, Object value, long time) {
		redisTemplate.opsForHash().put(key, item, value);
		if(time>0){
			setExpire(key, time);
		}
	}

	public Object hget(String key, String item) {
		return redisTemplate.opsForHash().get(key, item);
	}
	
	public void hdel(String key, Object... item) {
		redisTemplate.opsForHash().delete(key,item);
	}

	public void hmset(String key, Map<String, String> map) {
		redisTemplate.opsForHash().putAll(key, map);
	}

	public void hmset(String key, Map<String, Object> map, long time) {
		redisTemplate.opsForHash().putAll(key, map);
		if(time>0){
			setExpire(key, time);
		}
	}

	public Map<Object, Object> hmget(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	public Set<Object> hmkeys(String key) {
		return redisTemplate.opsForHash().keys(key);
	}

	public void lset(String key, List<Object> value) {
		redisTemplate.opsForList().leftPushAll(key, value);
	}

	public void lset(String key, List<Object> value, long time) {
		redisTemplate.opsForList().leftPushAll(key, value);
		if (time > 0) setExpire(key, time);
	}

	public void lpush(String key, Object value) {
		redisTemplate.opsForList().leftPush(key, value);
	}

	public void rpush(String key, Object value) {
		redisTemplate.opsForList().rightPush(key, value);
	}

	public List<Object> lget(String key, Long start, Long end) {
		return redisTemplate.opsForList().range(key, start, end);
	}

	public long lsize(String key) {
		return redisTemplate.opsForList().size(key);
	}

	public Object lGetIndex(String key, long index) {
		return redisTemplate.opsForList().index(key, index);
	}

	public void lUpdateIndex(String key, long index, Object value) {
		redisTemplate.opsForList().set(key, index, value);
	}

	public void lpop(String key) {
		redisTemplate.opsForList().leftPop(key);
	}
	
	public void rpop(String key) {
		redisTemplate.opsForList().rightPop(key);
	}

	public long lrem(String key, long count, Object value) {
		return redisTemplate.opsForList().remove(key, count, value);
	}

	public boolean lock(String key) {
		RedisDistributedLock lock = new RedisDistributedLock(redisTemplate);
		return lock.lock(key);
	}

}
