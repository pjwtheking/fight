/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName ThreadTest.java
 * @author Eric
 * @date 2018年8月24日 下午7:18:41  
 */
package com.eric.comm.thread;

import org.junit.Test;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月24日 下午7:18:41  
 */
public class ThreadTest {
	
	@Test
	public void testMyThread(){
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 3) {
				Thread myThread1 = new MyThread();
				Thread myThread2 = new MyThread();
				myThread1.start();// 调用start()方法使得线程进入就绪状态
				myThread2.start();
			}
		}
	}
	
	@Test
	public void testMyRunnable(){
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 3) {
				Runnable myRunnable = new MyRunnable();
				Thread thread1 = new Thread(myRunnable);
				Thread thread2 = new Thread(myRunnable);
				thread1.start();// 调用start()方法使得线程进入就绪状态
				thread2.start();
			}
		}
	}

}
