/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName IntermediateMemberStrategy.java
 * @author Eric
 * @date 2018年8月25日 下午9:38:48  
 */
package com.eric.comm.design.strategy;

/** 
 * @Description: 中级会员折扣策略

 * @author Eric
 * @date 2018年8月25日 下午9:38:49  
 */
public class IntermediateMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
	}

}
