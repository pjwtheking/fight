/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName Ticket.java
 * @author Eric
 * @date 2018年8月25日 下午6:04:04  
 */
package com.eric.comm.thread.synchronize;

/** 
 * @Description: 模拟高并发售票使用同步锁

 * @author Eric
 * @date 2018年8月25日 下午6:04:04  
 */
public class Ticket extends Thread {
	
	// 通过构造方法给线程名字赋值
    public Ticket(String name) {
         super(name);
    }
     
    // 为了保持票数的一致，票数要静态
    static int tick = 20;
    // 创建一个静态钥匙
    static Object lock = "lock";//同步锁
     
    // 重写run方法，实现买票操作
    @Override
    public void run() {
        while (tick > 0) {
        	System.out.println(getName() + "进来拿票了");
            synchronized (lock) {//进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
                if (tick > 0) {
                    System.out.println(getName() + "卖出了第" + tick + "张票");
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }
            }
            try {
                 sleep(1000);//休息
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "拿到票了");
        }
    }

}
