/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName Client.java
 * @author Eric
 * @date 2018年8月25日 下午9:42:10  
 */
package com.eric.comm.design.strategy;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月25日 下午9:42:10  
 */
public class Client {
	
	public static void main(String[] args) {
        //选择并创建需要使用的策略对象
        MemberStrategy strategy = new PrimaryMemberStrategy();
        //MemberStrategy strategy = new IntermediateMemberStrategy();
        //MemberStrategy strategy = new AdvancedMemberStrategy();
        //创建环境
        Price price = new Price(strategy);
        //计算价格
        double quote = price.calculate(300);
        System.out.println("图书的最终价格为：" + quote);
    }
	
}
