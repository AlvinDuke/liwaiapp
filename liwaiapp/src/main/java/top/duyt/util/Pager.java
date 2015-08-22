package top.duyt.util;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {
	
	/**
	 * ҳ�±�
	 */
	private int pageIndex;
	
	/**
	 * ��ѯ��ʼ��¼
	 */
	private int pageOffset;
	
	/**
	 * ÿҳ��С
	 */
	private int pageSize;
	
	/**
	 * ��ҳ��
	 */
	private int totalPageCount;
	
	/**
	 * �ܼ�¼��
	 */
	private int totalPageRecord;

	/**
	 * ����
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
