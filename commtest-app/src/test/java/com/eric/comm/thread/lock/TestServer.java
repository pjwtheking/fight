/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName TestServer.java
 * @author Eric
 * @date 2018年8月27日 下午6:40:36  
 */
package com.eric.comm.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月27日 下午6:40:36  
 */
public class TestServer {
	
	private static Lock lock = new ReentrantLock();// 锁
	
	public static void testLock(Thread thread){
		if(lock.tryLock()){
			try {
				System.out.println("线程"+thread.getName() + "获得了锁");
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
	            lock.unlock();
				System.out.println("线程"+ thread.getName() + "释放了锁");
			}
		}else{
			System.out.println("我是线程"+Thread.currentThread().getName()+"，有人占着锁，我就不要了");
		}
		
	}

}
