/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName PersonA.java
 * @author Eric
 * @date 2018年8月25日 下午7:48:46  
 */
package com.eric.comm.thread.account;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月25日 下午7:48:46  
 */
public class PersonA extends Thread {
	
	// 创建银行对象
    Bank bank;
     
    // 通过构造器传入银行对象，确保两个人进入的是一个银行
    public PersonA(Bank bank) {
         this.bank = bank;
    }
    
    //重写run方法，在里面实现使用柜台取钱
    @Override
        public void run() {
            while (Bank.money >= 100) {
                bank.Counter(100);// 每次取100块
            try {
                sleep(1000);// 取完休息2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
