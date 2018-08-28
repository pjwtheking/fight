/**
 * Copyright (c) 2006-2015 Fangcang Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Fangcang. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Fangcang,http://www.fangcang.com.
 *  
 */   
package com.eric.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 
 *StringUtil 扩展类
 *当fangcang-core 中的StringUtil不满足的时候
 *扩展功能在此类中实现
 *
 * </p>
 * @author	jiangzuku 
 * @date	2016年7月19日 下午3:23:00
 * @version      
 */
public class StringUtilExtend {

    /**比较两个字符串是否相等（比较时忽略空字符）*/
    public static boolean equalsWithTrim(String str1,String str2){
	if(str1==null && str2==null){
	    return true;
	}
	if (str1==null){
		return false;
	}
	if (str2==null){
		return false;
	}
	String temp1=str1.replaceAll("\\s", "");
	String temp2=str2.replaceAll("\\s", "");
	return temp1.equals(temp2);
    }
    
    /**
     * 
     * <p>
     * 
     * 根据传入的关键属性以及分隔符生成key
     *
     * </p>
     * @param separator 分隔符
     * @param parameters 组成KEY的关键字
     * @return
     *  
     * @author	jiangzuku 
     * @date	2016年11月29日 下午3:03:56
     * @version
     */
    public static String getKey(String separator,String... parameters){
	StringBuffer stringBuffer=new StringBuffer();
	if(parameters!=null && parameters.length>0){
	    for(int i=0;i<parameters.length;i++){
		if(i!=parameters.length-1){
		    stringBuffer.append(parameters[i]).append(separator);
		}else{
		    stringBuffer.append(parameters[i]);
		}
	    }
	}
	return stringBuffer.toString();
    }

	public static boolean isValidString(String parameter){
		if (parameter==null || "".equals(parameter)){
			return false;
		}else {
			return true;
		}
	}

	public static String uniteString(Object... parameters){
		StringBuilder stringBuilder=new StringBuilder();
		if (parameters.length>0){
			for (Object temp:parameters){
				stringBuilder.append(temp);
			}
		}
		return stringBuilder.toString();
	}

	public static String delStringSpace(String oriStr){
		String regex="(\\s*|\t|\r|\n)";
		Pattern pattern=Pattern.compile(regex);
		Matcher m = pattern.matcher(oriStr);
		String result = m.replaceAll("");
		return result;
	}

	/**比较两个字符串是否相等（比较时忽略空格、大小写）*/
	public static boolean equalsIgnoreBlankAndCase(String str1,String str2){
		if(str1==null && str2==null){
			return true;
		}
		if (str1==null){
			return false;
		}
		if (str2==null){
			return false;
		}
		String temp1=str1.replaceAll("\\s", "").toLowerCase();
		String temp2=str2.replaceAll("\\s", "").toLowerCase();
		return temp1.equals(temp2);
	}
}
 