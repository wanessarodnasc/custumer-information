package com.nubank.custumerinformation.enumeration;

public enum StatusEnum {
	
	ENABLED("Enabled"),
	DISABLED("Disabled");
	
	private String description;

	private StatusEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
