package com.nubank.custumerinformation.enumeration;

public enum StatusEnum {
	
	ENABLED("Enabled"),
	DISABLED("Disabled"),
	DOES_NOT_EXIST("Custumer does not exists.");
	
	private String description;

	private StatusEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
