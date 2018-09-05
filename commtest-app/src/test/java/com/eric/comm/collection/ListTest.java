/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName ListTest.java
 * @author Eric
 * @date 2018年9月2日 下午3:11:34  
 */
package com.eric.comm.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年9月2日 下午3:11:34  
 */
public class ListTest {
	
	static final int count = 50000;
	
	@Test
	public void testArrayList(){
		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			//动态集合，总是添加在第一位，先前添加的往后挪
			list.add(0, "str_"+i);
		}
		for (String str : list) {
			System.out.println(str);
		}
		
	}
	
	@Test
	public void arrayCompare2Linked(){
		
		List<Object> list1 = addList(new ArrayList<>());
		List<Object> list2 = addList(new LinkedList<>());
		System.out.println("ArrayList添加" + count + "条耗时：" + insetTime(list1));
		System.out.println("LinkedList添加" + count + "条耗时：" + insetTime(list2));
		
		List<Object> list3 = addList(new ArrayList<>());
		List<Object> list4 = addList(new LinkedList<>());
		System.out.println("ArrayList查找" + count + "条耗时：" + readList(list3));
		System.out.println("LinkedList查找" + count + "条耗时：" + readList(list4));
		
	}
	
	private long insetTime(List list){
		long start = System.currentTimeMillis();
		Object o = new Object();
		for (int i = 0; i < count; i++) {
			list.add(0, o);
		}
		return System.currentTimeMillis() - start;
	}
	private long readList(List<Object> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}
		return System.currentTimeMillis() - start;
	}
	private List<Object> addList(List<Object> list) {
		Object o = new Object();
		for (int i = 0; i < count; i++) {
			list.add(0, o);
		}
		return list;
	}

}
