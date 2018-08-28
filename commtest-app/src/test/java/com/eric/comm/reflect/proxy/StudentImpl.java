/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName StudentImpl.java
 * @author Eric
 * @date 2018年8月24日 下午10:57:20  
 */
package com.eric.comm.reflect.proxy;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月24日 下午10:57:20  
 */
public class StudentImpl implements Student {

	@Override
	public void doSomething(String something) {
		System.out.println("student is " + something + "...");
	}

}
