/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName PageResponse.java
 * @author Eric
 * @date 2018年8月23日 下午10:30:52  
 */
package com.eric.accbooks.dto.response;

import java.util.List;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月23日 下午10:30:52  
 */
public class PageResponse {
	
	private List<DailyAccountResponse> dailyList;
	
	private int dataCount;

	public List<DailyAccountResponse> getDailyList() {
		return dailyList;
	}

	public void setDailyList(List<DailyAccountResponse> dailyList) {
		this.dailyList = dailyList;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

}
