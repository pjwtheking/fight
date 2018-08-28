/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName Test.java
 * @author Eric
 * @date 2018年8月24日 下午8:36:25  
 */
package com.eric.comm.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import com.eric.comm.reflect.bean.Fruit;
import com.eric.comm.reflect.bean.Person;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月24日 下午8:36:25  
 */
public class TestReflect {
	
	Class clazz = Person.class;
	
	/**
	 * 反射的简单使用
	 * @author Eric
	 */
	@Test
	public void testFactory(){
		Fruit f = Factory.getInstance("com.eric.comm.reflect.bean.Apple");  
        if(f!=null){  
            f.eat();  
        }
	}
	
	/**
	 * 获得类完整的名字
	 * @author Eric
	 */
	@Test
	public void getName(){
		System.out.println(clazz.getName());
	}
	
	/**
	 * 获得类的public类型的属性
	 * @author Eric
	 */
	@Test
	public void getFields(){
		Field[] fields = clazz.getFields();
		for(Field field : fields){
			System.out.println(field.getName());
		}
	}
	
	/**
	 * 获得类的所有属性，包括私有的
	 * @author Eric
	 */
	@Test
	public void getDeclaredFields(){
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			System.out.println(field.getName());
		}
	}
	
	/**
	 * 获得类的public类型的方法。这里包括 Object 类的一些方法
	 * @author Eric
	 */
	@Test
	public void getMethods(){
		Method [] methods = clazz.getMethods();
		for(Method method : methods){
			System.out.println(method.getName());
		}
	}
	
	/**
	 * 获得类的所有方法
	 * @author Eric
	 */
	@Test
	public void getDeclaredMethods(){
		Method [] methods = clazz.getDeclaredMethods();
		for(Method method : methods){
			System.out.println(method.getName());
		}
	}
	
	/**
	 * 获得指定的公有属性
	 * @author Eric
	 */
	@Test
	public void getField() throws Exception{
		Field f1 = clazz.getField("age");
		System.out.println(f1);
	}
	
	/**
	 * 获得指定的私有属性
	 * @author Eric
	 */
	@Test
	public void getDeclaredField() throws Exception{
		Field f1 = clazz.getDeclaredField("name");
		System.out.println(f1);
	}
	
	/**
	 * 创建这个类的实例，为属性赋值，获取属性值
	 * setAccessible：启用和禁用访问安全检查的开关，值为 true，则表示反射的对象在使用时应该取消 java 语言的访问检查；反之不取消
	 * @author Eric
	 */
	@Test
	public void newInstance() throws Exception{
		Object object = clazz.newInstance();
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(object, "Bob");
		//使用反射机制可以打破封装性，导致了java对象的属性不安全
		System.out.println(field.get(object));
	}
	
	/**
	 * 获取构造方法
	 * @author Eric
	 */
	@Test
	public void getConstructors() {
		Constructor [] constructors = clazz.getConstructors();
		for(Constructor constructor : constructors){
			System.out.println(constructor.toString());//public com.ys.reflex.Person()
		}
	}
	
	
	public static class Factory {
		public static Fruit getInstance(String ClassName){  
			Fruit f=null;  
	        try{  
	            f=(Fruit)Class.forName(ClassName).newInstance();  
	        }catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return f;  
	    }
	}

}
