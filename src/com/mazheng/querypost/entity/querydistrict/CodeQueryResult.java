package com.mazheng.querypost.entity.querydistrict;

import java.util.List;


public class CodeQueryResult {

	private String reason;
	private CodeResult result;
	private int error_code;

	public CodeQueryResult(String reason, CodeResult result, int error_code) {
		super();
		this.reason = reason;
		this.result = result;
		this.error_code = error_code;
	}

	public CodeQueryResult() {
		super();
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public CodeResult getResult() {
		return result;
	}

	public void setResult(CodeResult result) {
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
		return "QueryResult [reason=" + reason + ", result=" + result
				+ ", error_code=" + error_code + "]";
	}

}
