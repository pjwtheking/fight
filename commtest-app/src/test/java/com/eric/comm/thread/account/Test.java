/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName Test.java
 * @author Eric
 * @date 2018年8月25日 下午7:50:32  
 */
package com.eric.comm.thread.account;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月25日 下午7:50:32  
 */
public class Test {

	/**
	 * @author Eric
	 * @date 2018年8月25日 下午7:50:32 
	 * @param args
	 * void 
	 */
	public static void main(String[] args) {
		
		// 实例化一个银行对象
        Bank bank = new Bank();
        // 实例化两个人，传入同一个银行的对象
        PersonA pA = new PersonA(bank);
        PersonB pB = new PersonB(bank);
        // 两个人开始取钱
        pA.start();
        pB.start();
		
	}

}
