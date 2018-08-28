/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName DubboAppServiceImpl.java
 * @author Eric
 * @date 2018年8月22日 下午5:59:35  
 */
package com.eric.comm.apps.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eric.accbooks.api.DailyAccountService;
import com.eric.accbooks.dto.request.DailyAccountRequest;
import com.eric.accbooks.dto.response.DailyAccountResponse;
import com.eric.comm.apps.DubboAppService;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月22日 下午5:59:35  
 */
@Service("dubboAppService")
public class DubboAppServiceImpl implements DubboAppService {
	
	@Resource
	DailyAccountService dailyAccountService;
	
	@Override
	public List<DailyAccountResponse> queryDailyAccountInfo(DailyAccountRequest request) throws Exception {
		
		return dailyAccountService.queryDailyAccount(request);
		
	}

}
