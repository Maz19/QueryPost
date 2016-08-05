package com.mazheng.querypost.entity.querydistrict;

import java.util.List;


public class CodeResult {

	private List<CodeLists> list;
	private int totalcount;
	private int totalpage;
	private int currentpage;
	private int pagesize;

	public CodeResult(List<CodeLists> list, int totalcount, int totalpage,
			int currentpage, int pagesize) {
		super();
		this.list = list;
		this.totalcount = totalcount;
		this.totalpage = totalpage;
		this.currentpage = currentpage;
		this.pagesize = pagesize;
	}

	public CodeResult() {
		super();
	}

	public List<CodeLists> getList() {
		return list;
	}

	public void setList(List<CodeLists> list) {
		this.list = list;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	@Override
	public String toString() {
		return "Result [list=" + list + ", totalcount=" + totalcount
				+ ", totalpage=" + totalpage + ", currentpage=" + currentpage
				+ ", pagesize=" + pagesize + "]";
	}

}
