/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName MyInvocationHandler.java
 * @author Eric
 * @date 2018年8月31日 下午5:45:38  
 */
package com.eric.comm.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
 * @Description: 结婚代理

 * @author Eric
 * @date 2018年8月31日 下午5:45:38  
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

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("处理结婚之前的事务...");
        Object object = method.invoke(target, args);
        System.out.println("处理结婚之后的事务...");
        return object;
	}

}
