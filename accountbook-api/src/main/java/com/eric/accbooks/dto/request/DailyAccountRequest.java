/**
 * CopyRright ©2018 Eric All Right Reserved.
 * 
 * @fileName DailyAccount.java
 * @author Eric
 * @date 2018年7月3日 下午9:38:14  
 */
package com.eric.accbooks.dto.request;

/**
 * 每日记账对象
 * @author Eric
 * @date 2018年7月3日 下午9:40:14 
 */
public class DailyAccountRequest extends BaseRequest {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4669077585832337574L;
	private Integer dailyId;
	private String accbookTypeCode;
	private String keeperCode;
	private String itemTypeCode;
	private Float amount;
	private String remark;
	private String createtime;
	private String modifyDate;
	
	
	public Integer getDailyId() {
		return dailyId;
	}
	public void setDailyId(Integer dailyId) {
		this.dailyId = dailyId;
	}
	public String getAccbookTypeCode() {
		return accbookTypeCode;
	}
	public void setAccbookTypeCode(String accbookTypeCode) {
		this.accbookTypeCode = accbookTypeCode;
	}
	public String getKeeperCode() {
		return keeperCode;
	}
	public void setKeeperCode(String keeperCode) {
		this.keeperCode = keeperCode;
	}
	public String getItemTypeCode() {
		return itemTypeCode;
	}
	public void setItemTypeCode(String itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

}
