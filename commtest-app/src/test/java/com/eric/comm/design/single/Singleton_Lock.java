/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName Singleton2.java
 * @author Eric
 * @date 2018年8月25日 下午9:57:30  
 */
package com.eric.comm.design.single;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * @Description: 使用线程锁解决单例模式的安全问题

 * @author Eric
 * @date 2018年8月25日 下午9:57:30  
 */
public class Singleton_Lock {
	
	private static Singleton_Lock instance;
	private static Lock lock = new ReentrantLock();// 锁

    private Singleton_Lock(){ } //无参构造

    public static Singleton_Lock getInstance(Thread thread) {
    	if (instance == null) {
    		lock.lock();
    		try {
				if (instance == null) {
					instance = new Singleton_Lock();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
                lock.unlock();
			}
		} 
		return instance;
    }

}
