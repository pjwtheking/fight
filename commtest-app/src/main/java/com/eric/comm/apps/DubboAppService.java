/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName DubboAppService.java
 * @author Eric
 * @date 2018年8月21日 上午12:40:54  
 */
package com.eric.comm.apps;

import java.util.List;

import com.eric.accbooks.dto.request.DailyAccountRequest;
import com.eric.accbooks.dto.response.DailyAccountResponse;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月21日 上午12:40:54  
 */
public interface DubboAppService {
	
	List<DailyAccountResponse> queryDailyAccountInfo(DailyAccountRequest request) throws Exception;

}
