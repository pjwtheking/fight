/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName Singleton.java
 * @author Eric
 * @date 2018年8月25日 下午9:46:48  
 */
package com.eric.comm.design.single;

/** 
 * @Description: 单例模式（线程不安全）

 * @author Eric
 * @date 2018年8月25日 下午9:46:48  
 */
public class Singleton_Simple {
	
	private static Singleton_Simple instance;
    private Singleton_Simple(){ } //私有无参构造，防止在其他地方被new出来

    public static Singleton_Simple getInstance(){
	    if(instance==null){//当有多个并发线程同时访问的时候，此时若对象为空，就会出现会多个线程同时产生多个Singleton对象
		    instance = new Singleton_Simple();
	    }
	    return instance;
    }

}
