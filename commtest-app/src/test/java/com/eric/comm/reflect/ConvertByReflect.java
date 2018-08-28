/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName MyConvert.java
 * @author Eric
 * @date 2018年8月24日 下午7:59:48  
 */
package com.eric.comm.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月24日 下午7:59:48  
 */
public class ConvertByReflect {
	
	private final static Logger logger = LoggerFactory.getLogger(ConvertByReflect.class);
	
	/**
	 * 用反射获取对象的属性转成用&相连的字符串<br>
	 * 属性为引用对象时，转为json格式
	 * @author Eric
	 * @date 2018年8月24日 下午8:01:42
	 */
	public static String ConvertObject2String (Object object) {
		try {
		    //基本类型、包装类型、String类型  
			String[] types = {"java.lang.Integer",  
		        "java.lang.Double",  
		        "java.lang.Float",  
		        "java.lang.Long",  
		        "java.lang.Short",  
		        "java.lang.Byte",  
		        "java.lang.Boolean",  
		        "java.lang.Character",  
		        "java.lang.String",  
		        "int","double","long","short","byte","boolean","char","float"};
			List<String> list = Arrays.asList(types);
			
			StringBuffer param = new StringBuffer();
			@SuppressWarnings("rawtypes")
			Class cls = object.getClass();
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
			    field.setAccessible(true);
			    //if(!String.valueOf(field.get(object)).equals("null") && !String.valueOf(field.get(object)).equals("")){
			    	if(list.contains(field.getType().getName())){
			    		param.append(field.getName() + "=" + field.get(object)+"&");
			    	}else{
			    		param.append(field.getName() + "=" + JSON.toJSONString(field.get(object))+"&");
			    	}
			    //}
			}
			for (Field field : cls.getSuperclass().getDeclaredFields()) {
				field.setAccessible(true);
			    //if(!String.valueOf(field.get(object)).equals("null") && !String.valueOf(field.get(object)).equals("")){
			    	if(list.contains(field.getType().getName())){
			    		param.append(field.getName() + "=" + field.get(object)+"&");
			    	}else{
			    		param.append(field.getName() + "=" + JSON.toJSONString(field.get(object))+"&");
			    	}
			    //}
			}
			return param.toString().substring(0, param.toString().length() - 1);
		} catch (Exception e) {
			logger.error("异常：", e);
			return "";
		}
    }

}
