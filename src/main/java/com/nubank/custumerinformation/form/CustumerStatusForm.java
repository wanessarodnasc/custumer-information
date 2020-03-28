package com.nubank.custumerinformation.form;

public class CustumerStatusForm {
	
	private String code;
	
	private Boolean status;
	
	public CustumerStatusForm() {
	}

	public CustumerStatusForm(String code, boolean status) {
		this.code = code;
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
