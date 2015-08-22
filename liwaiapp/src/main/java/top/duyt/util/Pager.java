package top.duyt.util;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {
	
	/**
	 * 页下标
	 */
	private int pageIndex;
	
	/**
	 * 查询起始记录
	 */
	private int pageOffset;
	
	/**
	 * 每页大小
	 */
	private int pageSize;
	
	/**
	 * 总页数
	 */
	private int totalPageCount;
	
	/**
	 * 总记录数
	 */
	private int totalPageRecord;

	/**
	 * 数据
	 */
	private List<T> datas = new ArrayList<T>();
	
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getTotalPageRecord() {
		return totalPageRecord;
	}

	public void setTotalPageRecord(int totalPageRecord) {
		this.totalPageRecord = totalPageRecord;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

}
