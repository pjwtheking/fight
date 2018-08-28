/**
 * CopyRright ©2018 Eric All Right Reserved.
 * 
 * @fileName DailyAccountDao.java
 * @author Eric
 * @date 2018年6月30日 下午2:30:42  
 */
package com.eric.accbooks.dao;

import java.util.List;

import com.eric.accbooks.dto.request.DailyAccountRequest;
import com.eric.accbooks.dto.request.Page;
import com.eric.accbooks.dto.response.DailyAccountResponse;
public interface DailyAccountDao {
	
	public List<DailyAccountResponse> queryDailyAccount(DailyAccountRequest dailyAccountRequest);
	
	public int insert(DailyAccountRequest dailyAccountRequest);
	
	public List<DailyAccountResponse> selectPage(Page page);
	
	public int selectCount();

}
