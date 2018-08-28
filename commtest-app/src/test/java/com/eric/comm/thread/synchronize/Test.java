/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName Test.java
 * @author Eric
 * @date 2018年8月25日 下午6:11:29  
 */
package com.eric.comm.thread.synchronize;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月25日 下午6:11:29  
 */
public class Test {

	/**
	 * @author Eric
	 * @date 2018年8月25日 下午6:11:29
	 */
	public static void main(String[] args) {
		
		//实例化买票窗口对象，并为每一个窗口取名字
		Ticket ticket1 = new Ticket("窗口1");
		Ticket ticket2 = new Ticket("窗口2");
		Ticket ticket3 = new Ticket("窗口3");
    
        //让每一个窗口对象各自开始工作
		ticket1.start();
		ticket2.start();
		ticket3.start();
		
	}

}
