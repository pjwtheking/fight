/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName PrimaryMemberStrategy.java
 * @author Eric
 * @date 2018年8月25日 下午9:36:36  
 */
package com.eric.comm.design.strategy;

/** 
 * @Description: 初级会员折扣策略

 * @author Eric
 * @date 2018年8月25日 下午9:36:36  
 */
public class PrimaryMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("对于初级会员的没有折扣");
        return booksPrice;
	}

}
