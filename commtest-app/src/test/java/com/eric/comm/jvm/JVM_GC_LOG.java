/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName JVM_GC_LOG.java
 * @author Eric
 * @date 2018年8月24日 下午4:57:23  
 */
package com.eric.comm.jvm;

import org.junit.Test;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月24日 下午4:57:23  
 */
public class JVM_GC_LOG {
	
	/**
	 * 发生GC时打印出信息  
	 * 打印简要信息：-XX:+PrintGC或-verbose:gc
	 * 打印详细信息：-XX:+PrintGCDetails
	 * @author Eric
	 */
	@Test
	public void print_gc(){
		@SuppressWarnings("unused")
		byte[] bytes =null; 
		for(int i=0;i<100;i++){ 
			bytes = new byte[1 * 1024 * 1024]; 
		}
	}
	
	/**
	 * 打印出目前内存（java堆）使用的情况
	 * @author Eric
	 */
	@Test
	public void print_gc_memory(){
		System.out.println("最大堆："+Runtime.getRuntime().maxMemory()/1024/1024+"M"); 
		System.out.println("空闲堆："+Runtime.getRuntime().freeMemory()/1024/1024+"M"); 
		System.out.println("总的堆："+Runtime.getRuntime().totalMemory()/1024/1024+"M");
	}	

}
