/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName MyInvocationHandler.java
 * @author Eric
 * @date 2018年8月24日 下午10:31:39  
 */
package com.eric.comm.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月24日 下午10:31:39  
 */
public class MyInvocationHandler implements InvocationHandler {
	
	private Object target = null;
	/**
	 * 绑定委托对象并返回一个代理类
	 * 
	 * ClassLoader loader：类加载器 
	 * Class<?>[] interfaces：得到全部的接口 
	 * InvocationHandler h：得到InvocationHandler接口的子类实例 
	 */
	public Object bind(Object target) {
        this. target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
        		target.getClass().getInterfaces(), this);
    }

    /**
     * Object proxy：指被代理的对象。 
	 * Method method：要调用的方法 
	 * Object[] args：方法调用时所需要的参数 
     */
	@Override
	public Object invoke(Object arg, Method method, Object[] arg2) throws Throwable {
		System.out.println("事务处理之前");
        Object temp = method.invoke(target, arg2);
        System.out.println("事务处理之后");
        return temp;
	}

}
