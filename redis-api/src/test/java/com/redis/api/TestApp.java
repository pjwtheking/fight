/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName TestApp.java
 * @author Eric
 * @date 2018年8月16日 下午10:21:26  
 */
package com.redis.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月16日 下午10:21:26  
 */
public class TestApp {
	
	public Jedis getJedis(){
		//连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+ jedis.ping());
        return jedis;
	}
	
	@Test
	public void lpush(){
		Jedis jedis = getJedis();
		jedis.lpush("list01", "aaa");
		jedis.lpush("list01", "bbb");
		System.out.println("jedis lpush success");
		List<String> list = jedis.lrange("list01", 0, -1);
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	@Test
	public void lpop(){
		Jedis jedis = getJedis();
		System.out.println("从左边移除并返回列表的第一个元素：" + jedis.lpop("list01"));
	}
	
	@Test
	public void showList(){
		Jedis jedis = getJedis();
		List<String> list = jedis.lrange("list01", 0, -1);
		for (String string : list) {
			System.out.println(string);
		}
	}

}
