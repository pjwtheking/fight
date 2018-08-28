/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName Bank.java
 * @author Eric
 * @date 2018年8月25日 下午7:46:53  
 */
package com.eric.comm.thread.account;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月25日 下午7:46:53  
 */
public class Bank {
	
	// 假设一个账户有1000块钱
    static int money = 1000;
     
    // 柜台Counter取钱的方法
    public void Counter(int money) {// 参数是每次取走的钱
        Bank.money -= money;//取钱后总数减少
        System.out.println("A从柜台取走了" + money + "还剩下" + (Bank.money));
    }
     
    // ATM取钱的方法
    public void ATM(int money) {// 参数是每次取走的钱
        Bank.money -= money;//取钱后总数减少
        System.out.println("B从ATM取走了" + money + "还剩下" + (Bank.money));
    }

}
