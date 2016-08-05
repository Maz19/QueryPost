package com.mazheng.querypost.entity.querynumber;

import java.util.List;

public class QueryResult {
	private int total;
	private List<AreasResult> result;
	private int error_code;
	private String reason;

	public QueryResult(int total, List<AreasResult> result, int error_code, String reason) {
		super();
		this.total = total;
		this.result = result;
		this.error_code = error_code;
		this.reason = reason;
	}

	public QueryResult() {
		super();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<AreasResult> getResult() {
		return result;
	}

	public void setResult(List<AreasResult> result) {
		this.result = result;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "QueryResult [total=" + total + ", result=" + result + ", error_code=" + error_code + ", reason="
				+ reason + "]";
	}

}
