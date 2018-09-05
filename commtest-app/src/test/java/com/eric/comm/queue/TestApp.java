/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName TestApp.java
 * @author Eric
 * @date 2018年9月1日 下午3:21:10  
 */
package com.eric.comm.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/** 
 * @Description: 队列

 * @author Eric
 * @date 2018年9月1日 下午3:21:10  
 */
public class TestApp {
	
	/**
	 * 优先级非阻塞队列-非线程安全
	 * @author Eric
	 */
	@Test
	public void testPriorityQueue(){
		
		//匿名Comparator实现
	    Comparator<Integer> myComparator = new Comparator<Integer>(){
	        @Override
	        public int compare(Integer num1, Integer num2) {
	            return num2.compareTo(num1);
	        }
	    };
		
		Queue<Integer> priorityQueue = new PriorityQueue<Integer>(myComparator);
		priorityQueue.add(1);
		priorityQueue.add(3);
		priorityQueue.add(2);
		priorityQueue.add(4);
		priorityQueue.add(6);
		priorityQueue.add(7);
		priorityQueue.offer(5);//add 和offer效果一样。
		priorityQueue.offer(8);//add 方法实现，其实就是调用了offer
		
		//按myComparator优先级取出
		while(!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.poll());
        }
		
	}
	
	
	/**
	 * 链表非阻塞队列-线程安全
	 * @author Eric
	 */
	@Test
	public void testConcurrentLinkedQueue(){
		
		Queue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();
		concurrentLinkedQueue.add("张三");
		concurrentLinkedQueue.add("李四");
		concurrentLinkedQueue.add("王五");
		
		//先进先出
		while(!concurrentLinkedQueue.isEmpty()){
            System.out.println(concurrentLinkedQueue.poll());
        }
		
	}
	
	
	/**
	 * 有界阻塞队列-线程安全
	 * @author Eric
	 * @throws InterruptedException 
	 */
	@Test
	public void testArrayBlockingQueue() throws InterruptedException{
		
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);
		
		for (int i = 0; i < 10; i++) {
			boolean flag = arrayBlockingQueue.offer("array_"+i);
			if(!flag){
				System.out.println("队列已满，开始取出");
				while(!arrayBlockingQueue.isEmpty()){
		            System.out.println(arrayBlockingQueue.poll());
		        }
				System.out.println("取出完毕，开始放入下一批数据");
				i--;
			}
			if(i == 9){
				System.out.println("最后一批数据取出");
				while(!arrayBlockingQueue.isEmpty()){
		            System.out.println(arrayBlockingQueue.poll());
		        }
			}
		}
		
	}
	
	
	/**
	 * 无界链表阻塞队列-线程安全
	 * @author Eric
	 * @throws InterruptedException 
	 */
	@Test
	public void testLinkedBlockingQueue() throws InterruptedException{
		
		LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();
		
		for (int i = 0; i < 10; i++) {
			boolean flag = linkedBlockingQueue.offer("link_"+i, 10000, TimeUnit.SECONDS);
			if(!flag){
				System.out.println("队列已满，开始取出");
				while(!linkedBlockingQueue.isEmpty()){
		            System.out.println(linkedBlockingQueue.poll());
		        }
			}
			if(i == 9){
				System.out.println("数据已全部放入，开始取出");
				while(!linkedBlockingQueue.isEmpty()){
		            System.out.println(linkedBlockingQueue.poll());
		        }
			}
		}
		
	}
	

}
