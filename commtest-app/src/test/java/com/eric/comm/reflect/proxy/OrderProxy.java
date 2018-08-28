/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName OrderProxy.java
 * @author Eric
 * @date 2018年8月24日 下午10:05:59  
 */
package com.eric.comm.reflect.proxy;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月24日 下午10:05:59  
 */
public class OrderProxy implements Order {
	
	private OrderImpl orderImpl;   
    public OrderProxy(OrderImpl orderImpl) { 
        this.orderImpl = orderImpl; 
    }

	@Override
	public void query() {
		System.out.println("事务处理之前");           
		orderImpl.query(); // 调用委托类的方法;
        System.out.println("事务处理之后");
	}

}
