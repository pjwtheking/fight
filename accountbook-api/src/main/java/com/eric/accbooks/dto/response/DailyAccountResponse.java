/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName DailyAccountResponse.java
 * @author Eric
 * @date 2018年8月15日 下午9:32:45  
 */
package com.eric.accbooks.dto.response;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月15日 下午9:32:45  
 */
public class DailyAccountResponse extends BaseResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4260339226928490474L;
	private Integer dailyId;
	private String accbookTypeCode;
	private String accbookTypeName;
	private String keeperCode;
	private String itemTypeCode;
	private String itemTypeName;
	private Float amount;
	private String remark;
	private String createtime;
	private String modifyDate;
	
	/**
	 * @return the dailyId
	 */
	public Integer getDailyId() {
		return dailyId;
	}
	/**
	 * @param dailyId the dailyId to set
	 */
	public void setDailyId(Integer dailyId) {
		this.dailyId = dailyId;
	}
	/**
	 * @return the accbookTypeCode
	 */
	public String getAccbookTypeCode() {
		return accbookTypeCode;
	}
	/**
	 * @param accbookTypeCode the accbookTypeCode to set
	 */
	public void setAccbookTypeCode(String accbookTypeCode) {
		this.accbookTypeCode = accbookTypeCode;
	}
	public String getAccbookTypeName() {
		return accbookTypeName;
	}
	public void setAccbookTypeName(String accbookTypeName) {
		this.accbookTypeName = accbookTypeName;
	}
	/**
	 * @return the keeperCode
	 */
	public String getKeeperCode() {
		return keeperCode;
	}
	/**
	 * @param keeperCode the keeperCode to set
	 */
	public void setKeeperCode(String keeperCode) {
		this.keeperCode = keeperCode;
	}
	/**
	 * @return the itemTypeCode
	 */
	public String getItemTypeCode() {
		return itemTypeCode;
	}
	/**
	 * @param itemTypeCode the itemTypeCode to set
	 */
	public void setItemTypeCode(String itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	}
	/**
	 * @return the itemTypeName
	 */
	public String getItemTypeName() {
		return itemTypeName;
	}
	/**
	 * @param itemTypeName the itemTypeName to set
	 */
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	/**
	 * @return the amount
	 */
	public Float getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the createtime
	 */
	public String getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	/**
	 * @return the modifyDate
	 */
	public String getModifyDate() {
		return modifyDate;
	}
	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

}
