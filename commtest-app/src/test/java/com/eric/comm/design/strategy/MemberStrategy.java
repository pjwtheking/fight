/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName MemberStrategy.java
 * @author Eric
 * @date 2018年8月25日 下午9:35:29  
 */
package com.eric.comm.design.strategy;

/** 
 * @Description: 会员折扣策略抽象

 * @author Eric
 * @date 2018年8月25日 下午9:35:29  
 */
public interface MemberStrategy {
	
	/**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double calcPrice(double booksPrice);

}
