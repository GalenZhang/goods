package com.sofans.entity;

import java.util.List;

import com.sofans.constant.Constatnt;

public class PageResult extends Result{
	
	private int totalSize;
	
	private int pagesize = Constatnt.PAGE_SIZE;
	
	private List<IBean> list;
	
	private int pages;
	
	public PageResult(boolean result, String desc) {
		super(result, desc);
	}

	public PageResult(boolean result, String desc, List<IBean> list) {
		super(result, desc);
		this.list = list;
	}

	
	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public List<IBean> getList() {
		return list;
	}

	public void setList(List<IBean> list) {
		this.list = list;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
}
