/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName DailyAccountServiceImpl.java
 * @author Eric
 * @date 2018年8月14日 下午5:48:29  
 */
package com.eric.accbooks.services;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.eric.accbooks.api.DailyAccountService;
import com.eric.accbooks.dao.DailyAccountDao;
import com.eric.accbooks.dto.request.DailyAccountRequest;
import com.eric.accbooks.dto.request.Page;
import com.eric.accbooks.dto.response.DailyAccountResponse;
import com.eric.accbooks.dto.response.PageResponse;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月14日 下午5:48:29  
 */
@Service("dailyAccountService")
public class DailyAccountServiceImpl implements DailyAccountService {
	
	@Resource
	private DailyAccountDao dailyAccountDao;

	@Override
	public List<DailyAccountResponse> queryDailyAccount(DailyAccountRequest dailyAccountRequest) throws Exception {
		return dailyAccountDao.queryDailyAccount(dailyAccountRequest);
	}

	@Override
	public int insert(DailyAccountRequest dailyAccountRequest) throws Exception {
		return dailyAccountDao.insert(dailyAccountRequest);
	}
	
	@Override
	public PageResponse selectPage(Page page) {
		PageResponse pageResponse = new PageResponse();
		pageResponse.setDailyList(dailyAccountDao.selectPage(page));
		pageResponse.setDataCount(dailyAccountDao.selectCount());
		return pageResponse;
	}

}
