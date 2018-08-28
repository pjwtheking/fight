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

import java.security.MessageDigest;

/**
 * <p>
 * 
 * Md5加密工具
 * 
 * </p>
 * 
 * @author jiangzuku
 * @date 2016年6月6日 下午3:30:44
 * @version
 */
public class Md5Util {

    /***
     * MD5加密 生成32位md5码
     * 
     * @param 待加密字符串
     * @return 返回32位md5码
     */
    public static String md5Encode(String inStr) throws Exception {
	MessageDigest md5 = null;
	try {
	    md5 = MessageDigest.getInstance("MD5");
	} catch (Exception e) {
	    System.out.println(e.toString());
	    e.printStackTrace();
	    return "";
	}

	byte[] byteArray = inStr.getBytes("UTF-8");
	byte[] md5Bytes = md5.digest(byteArray);
	StringBuffer hexValue = new StringBuffer();
	for (int i = 0; i < md5Bytes.length; i++) {
	    int val = ((int) md5Bytes[i]) & 0xff;
	    if (val < 16) {
		hexValue.append("0");
	    }
	    hexValue.append(Integer.toHexString(val));
	}
	return hexValue.toString();
    }
    
    public static void main(String[] args) throws Exception {
	StringBuffer sb=new StringBuffer();
	long seconds=System.currentTimeMillis()/1000;
	sb.append("crs.test").append(seconds).append("crs.test.pass12");
//	sb.append("crs.fangcang").append(seconds).append("uYws^ass89");
	System.out.println(seconds);
	System.out.println(md5Encode(sb.toString()));
    }
}
