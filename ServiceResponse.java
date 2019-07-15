package com.example.tinyUrl;

public class ServiceResponse {
	
	public ServiceResponse(String status, String value) {
		this.status = status;
		this.value = value;
	}
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	private String value;

}
