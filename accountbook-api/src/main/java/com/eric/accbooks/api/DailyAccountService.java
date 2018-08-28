/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName DailyAccountService.java
 * @author Eric
 * @date 2018年8月14日 下午5:46:16  
 */
package com.eric.accbooks.api;

import java.util.List;

import com.eric.accbooks.dto.request.DailyAccountRequest;
import com.eric.accbooks.dto.request.Page;
import com.eric.accbooks.dto.response.DailyAccountResponse;
import com.eric.accbooks.dto.response.PageResponse;

/** 
 * @Description: 每日记账服务接口

 * @author Eric
 * @date 2018年8月14日 下午5:46:16  
 */
public interface DailyAccountService {
	
	public List<DailyAccountResponse> queryDailyAccount(DailyAccountRequest dailyAccountRequest) throws Exception;
	
	public int insert(DailyAccountRequest dailyAccount) throws Exception;
	
	public PageResponse selectPage(Page page);

}
