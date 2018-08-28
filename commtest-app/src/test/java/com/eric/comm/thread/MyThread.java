/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName MyThread.java
 * @author Eric
 * @date 2018年8月24日 下午7:17:12  
 */
package com.eric.comm.thread;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月24日 下午7:17:12  
 */
public class MyThread extends Thread {
	
	private int i = 0;
	
	@Override
	public void run() {
		for (i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
