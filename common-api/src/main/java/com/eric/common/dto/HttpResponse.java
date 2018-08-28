/**
 * Copyright (c) 2006-2015 Fangcang Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Fangcang. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Fangcang,http://www.fangcang.com.
 *  
 */
package com.eric.common.dto;

/**
 * <p>
 * 
 *
 *
 * </p>
 * 
 * @author liuyunquan
 * @date 2017年6月22日 下午3:42:22
 * @version
 */
public class HttpResponse {

    public static enum STATUS {

	SUCCESS, CONNECT_TIME_OUT, READ_TIME_OUT, SYSTEM_ERROR;
    }

    private String content;

    public STATUS status;

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public void setStatus(STATUS status) {
	this.status = status;
    }

}
