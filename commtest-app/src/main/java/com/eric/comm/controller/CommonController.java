/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName CommonController.java
 * @author Eric
 * @date 2018年8月22日 下午6:03:20  
 */
package com.eric.comm.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.eric.accbooks.dto.request.DailyAccountRequest;
import com.eric.accbooks.dto.response.DailyAccountResponse;
import com.eric.comm.apps.DubboAppService;
import com.eric.common.util.DateUtils;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月22日 下午6:03:20  
 */
@Controller
@RequestMapping("/comm")
public class CommonController {
	
	private final static Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Resource
	private DubboAppService dubboAppService;
	
	@RequestMapping("/dailyInfo")
	@ResponseBody
	public List<DailyAccountResponse> queryDailyAccountInfo(DailyAccountRequest request){
		

		List<DailyAccountResponse> list = null;
		try {
			
			String query = DateUtils.getShotDate(new Date());
			if(StringUtils.isEmpty(request.getCreatetime())){
				request.setCreatetime(query);
			}else{
				query = request.getCreatetime();
			}
			try {
				list = dubboAppService.queryDailyAccountInfo(request);
			} catch (Exception e) {
				logger.error("查询每日记账明细发生异常：", e);
			}
			
		} catch (Exception e) {
			
			logger.error("查询每日记账明细发生异常：", e);
		}
		
		return list;
		
	}

}
