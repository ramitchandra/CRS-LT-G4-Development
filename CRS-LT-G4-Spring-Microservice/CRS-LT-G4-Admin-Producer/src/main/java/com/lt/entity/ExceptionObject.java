/**
 * 
 */
package com.lt.entity;

/**
 * @author user112
 *
 */
public class ExceptionObject {
	
	private String timestamp;
	private String status;
	private String error;
	private String message;
	
	/**
	 * @param timestamp
	 * @param status
	 * @param error
	 * @param message
	 */
	public ExceptionObject(String timestamp, String status, String error, String message) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
	}
	
	/**
	 * 
	 */
	public ExceptionObject() {
		super();
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "timestamp=" + timestamp + ",\n status=" + status + ",\n error=" + error + ",\n message="
				+ message;
	}
	
}
