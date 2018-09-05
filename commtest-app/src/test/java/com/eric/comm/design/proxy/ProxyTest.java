/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName ProxyTest.java
 * @author Eric
 * @date 2018年8月31日 下午5:48:56  
 */
package com.eric.comm.design.proxy;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月31日 下午5:48:56  
 */
public class ProxyTest {
	
	public static void main(String[] args) {
		
		MyInvocationHandler handler = new MyInvocationHandler();
		ILove love = (ILove)handler.bind(new LoveImpl());
		love.marry();
		
	}

}
