/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName PersonB.java
 * @author Eric
 * @date 2018年8月25日 下午7:49:45  
 */
package com.eric.comm.thread.account;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月25日 下午7:49:45  
 */
public class PersonB extends Thread {
	
    // 创建银行对象
    Bank bank;
     
    // 通过构造器传入银行对象，确保两个人进入的是一个银行
    public PersonB(Bank bank) {
        this.bank = bank;
    }
     
    // 重写run方法，在里面实现使用柜台取钱
    @Override
    public void run() {
        while (Bank.money >= 200) {
            bank.ATM(200);// 每次取200块
            try {
                sleep(3000);// 取完休息1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
         
    }

}
