/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName ProxyTest.java
 * @author Eric
 * @date 2018年8月24日 下午10:09:32  
 */
package com.eric.comm.reflect.proxy;

import org.junit.Test;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月24日 下午10:09:32  
 */
public class ProxyTest {
	
	/**
	 * 静态代理
	 * @author Eric
	 */
	@Test
	public void StaticProxy(){
		OrderImpl orderImpl = new OrderImpl(); 
        OrderProxy proxy = new OrderProxy(orderImpl); 
        proxy.query();
	}
	
	/**
	 * 动态代理
	 * @author Eric
	 */
	@Test
	public void DynamicProxy(){
		
		MyInvocationHandler handler = new MyInvocationHandler();
		
		Order order = (Order) handler.bind(new OrderImpl());
		order.query();
		
		Student student = (Student) handler.bind(new StudentImpl());
		student.doSomething("studying");
		
	}
	
}
