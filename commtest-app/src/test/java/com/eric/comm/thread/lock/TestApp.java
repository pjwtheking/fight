/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName TestApp.java
 * @author Eric
 * @date 2018年8月27日 下午6:42:18  
 */
package com.eric.comm.thread.lock;

import org.junit.Test;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月27日 下午6:42:18  
 */
public class TestApp {
	
	/**
	 * 测试线程锁
	 * @author Eric
	 * @date 2018年8月27日 下午7:37:15 
	 */
	@Test
	public void Test01(){
		
		//线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
            	TestServer.testLock(Thread.currentThread());
            }
        }, "A");
        //线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
            	TestServer.testLock(Thread.currentThread());
            }
        }, "B");
        
        t1.start();
        t2.start();
        
        //单元测试是守护线程，一旦结束，子线程会全部结束
        try {
        	System.out.println("用户线程全部启动，主线程睡眠...");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * main函数为非守护线程（用户线程）
	 * @author Eric
	 * @date 2018年8月27日 下午7:36:36 
	 */
	public static void main(String[] args) {
		
		//线程1
        Thread tA = new Thread(new Runnable() {
            @Override
            public void run() {
            	TestServer.testLock(Thread.currentThread());
            }
        }, "A");
        //线程2
        Thread tB = new Thread(new Runnable() {
            @Override
            public void run() {
            	TestServer.testLock(Thread.currentThread());
            }
        }, "B");
        
        /*
         * 虽然main函数是用户线程，但是当把它的子线程设置为守护线程时，main函数一结束，子线程也会全部结束
         */
        /*t1.setDaemon(true);
        t1.setDaemon(true);*/
        
        tA.start();
        tB.start();
        
        try {
        	System.out.println("main函数睡眠等待A线程释放锁...");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
