/**
 * 
 */
package com.lt.entity;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 * Bean of exception to store exception details
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
	
	/**
	 * @return
	 * The timestamp of the exception
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp
	 * @return 
	 * Set the timestamp for the exception
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return
	 * To get the status code of exception
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status
	 * @return 
	 * To set Exception status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return
	 *  To get the Exception Error.
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error
	 * @return
	 * To set the Exception error.
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return
	 * To get the exception message.
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message
	 * @return 
	 * To the set the exception message.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "timestamp=" + timestamp + ",\n status=" + status + ",\n error=" + error + ",\n message="
				+ message;
	}
	
}
