/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName MyRunnable.java
 * @author Eric
 * @date 2018年8月24日 下午7:23:59  
 */
package com.eric.comm.thread;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月24日 下午7:23:59  
 */
public class MyRunnable implements Runnable {
	
	private int i = 0;

	@Override
	public void run() {
		for (i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
