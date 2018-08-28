/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName Page.java
 * @author Eric
 * @date 2018年8月23日 下午8:41:27  
 */
package com.eric.accbooks.dto.request;

/** 
 * @Description: TODO

 * @author Eric
 * @date 2018年8月23日 下午8:41:27  
 */
public class Page {
	
	private int pageNo; //页码
	private int start; //查询开始
	private int pageSize; //每页显示的行数
	private int tatolPage; //总页数
	private int dataCount; //数据条数
	private Integer nextPage; //下一页
	private Integer prePage; //上一页
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getStart() {
		//return start;
		return (this.getPageNo() -1)*this.getPageSize();
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTatolPage() {
		//return tatolPage;
		return dataCount % getPageSize() == 0 ? dataCount / getPageSize() :
			dataCount/ getPageSize() + 1;
	}
	public void setTatolPage(int tatolPage) {
		this.tatolPage = tatolPage;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public Integer getNextPage() {
		//return nextPage;
		return pageNo +1;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getPrePage() {
		//return prepage;
		return pageNo -1;
	}
	public void setPrepage(Integer prePage) {
		this.prePage = prePage;
	}

}
