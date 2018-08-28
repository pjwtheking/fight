/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName Price.java
 * @author Eric
 * @date 2018年8月25日 下午9:40:27  
 */
package com.eric.comm.design.strategy;

/** 
 * @Description: 价格类

 * @author Eric
 * @date 2018年8月25日 下午9:40:27  
 */
public class Price {
	
	//持有一个Strategy的引用
    private MemberStrategy strategy;
    /**
     * 构造函数，传入一个具体的策略对象
     */
    public Price(MemberStrategy strategy){
        this.strategy = strategy;
    }
    
    /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double calculate(double booksPrice){
        return this.strategy.calcPrice(booksPrice);
    }
	
}
