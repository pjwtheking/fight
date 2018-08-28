/**
 * 
 */
package com.eric.common.dto;

/**
 * @author zxw
 *
 */
public class HttpQueryResponse
{
	private String responseStr;
	
	private boolean timeOut;
	
	
	public boolean getTimeOut()
	{
		return timeOut;
	}

	public void setTimeOut(boolean timeOut)
	{
		this.timeOut = timeOut;
	}

	public String getResponseStr()
	{
		return responseStr;
	}

	public void setResponseStr(String responseStr)
	{
		this.responseStr = responseStr;
	}
	
	
}
