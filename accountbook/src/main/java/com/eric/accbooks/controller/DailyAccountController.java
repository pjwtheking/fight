/**
 * CopyRright ©2018 Eric All Right Reserved.
 * 
 * @fileName DailyAccountController.java
 * @author Eric
 * @date 2018年6月30日 下午2:30:42  
 */
package com.eric.accbooks.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eric.accbooks.api.DailyAccountService;
import com.eric.accbooks.dto.request.DailyAccountRequest;
import com.eric.accbooks.dto.request.Page;
import com.eric.accbooks.dto.response.DailyAccountResponse;
import com.eric.accbooks.dto.response.PageResponse;
import com.eric.common.util.DateUtils;

/** 
 * 每日记账明细
 * @author Eric
 * @date 2018年5月29日 下午3:32:54  
 */
@Controller
@RequestMapping("/daily")
public class DailyAccountController {
	
	private final static Logger logger = LoggerFactory.getLogger(DailyAccountController.class);
	
	@Resource
	private DailyAccountService dailyAccountService;
	
	/**
	 * 显示每日记账明细
	 * @author Eric
	 * @date 2018年5月29日 下午4:58:22 
	 * @return String
	 */
	@RequestMapping(value="/show")
	public String showAccountBooks(DailyAccountRequest request, Model model){
		try {
			
			logger.info("查询每日记账明，查询日期：{}", request.getCreatetime());
			String query = DateUtils.getShotDate(new Date());
			if(StringUtils.isEmpty(request.getCreatetime())){
				request.setCreatetime(query);
				logger.info("设置默认查询日期：{}", query);
			}else{
				query = request.getCreatetime();
			}
			
			List<DailyAccountResponse> list = null;
			try {
				list = dailyAccountService.queryDailyAccount(request);
			} catch (Exception e) {
				logger.error("查询每日记账明细发生异常：", e);
			}
			model.addAttribute("list", list);
			model.addAttribute("query", query);
			
		} catch (Exception e) {
			
			logger.error("查询每日记账明细发生异常：", e);
		}
		return "daily/show";
	}
	
	
	/**
	 * 测试分页
	 * @author Eric
	 * @date 2018年8月23日 下午9:01:49
	 */
	@RequestMapping(value="/page")
	public String pageList(Page page, Model model){
		PageResponse pageResponse = null;
		try {
			logger.info("===>>分页查询：pageNo={}，pageSize={}", page.getPageNo(), page.getPageSize());
			//page.setStart((page.getPageNo() -1)*page.getPageSize());
			try {
				pageResponse = dailyAccountService.selectPage(page);
			} catch (Exception e) {
				logger.error("分页查询发生异常：", e);
			}
			page.setDataCount(pageResponse.getDataCount());
			model.addAttribute("list", pageResponse.getDailyList());
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error("分页查询发生异常：", e);
		}
		return "daily/page";
	}
	
	
	/**
	 * @Description: 保存每日记账明细
	 *
	 * @author Eric
	 * @date 2018年8月16日 下午3:37:33 
	 * @param @param dailyAccount
	 * @param @param model
	 * @param @return 
	 * @return String
	 */
	@RequestMapping(value="/save")
	public String save(DailyAccountRequest dailyAccount, Model model){
		try {
			
			String msg = "保存成功";
			try {
				int id = dailyAccountService.insert(dailyAccount);
				if(id <= 0){
					msg = "保存失败";
				}
			} catch (Exception e) {
				logger.error("保存每日记账明细发生异常：", e);
			}
			model.addAttribute("msg", msg);
			model.addAttribute("query", dailyAccount.getCreatetime());
			
		} catch (Exception e) {
			logger.error("保存每日记账明细发生异常：", e);
			
		}
		return "daily/show";
	}

}
