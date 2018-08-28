/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName AdvancedMemberStrategy.java
 * @author Eric
 * @date 2018年8月25日 下午9:39:24  
 */
package com.eric.comm.design.strategy;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月25日 下午9:39:24  
 */
public class AdvancedMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
	}

}
