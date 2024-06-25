package com.manan.crud.exception;

public class EmployeeErrorResponse {
	
	private Integer status;
	
	private String message;
	
	private String timeStamp;

	public EmployeeErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeErrorResponse(Integer status, String message, String timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "StudentErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	
	

}
