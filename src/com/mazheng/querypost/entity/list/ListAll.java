package com.mazheng.querypost.entity.list;

import java.util.List;

/**
 * 解析省份城市总类
 * @author Administrator
 *
 */

public class ListAll {

	private String reason;
	/**
	 * 列表
	 */
	private List<Province> result;
	private int error_code;

	public ListAll(String reason, List<Province> result, int error_code) {
		super();
		this.reason = reason;
		this.result = result;
		this.error_code = error_code;
	}

	public ListAll() {
		super();
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<Province> getResult() {
		return result;
	}

	public void setResult(List<Province> result) {
		this.result = result;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	@Override
	public String toString() {
		return "ListView [reason=" + reason + ", result=" + result + ", error_code=" + error_code + "]";
	}

}
