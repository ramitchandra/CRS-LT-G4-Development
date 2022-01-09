package com.lt.bean;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh 
 * Bean of cardDetails to store cardDetails
 */
public class CardDetails {
	
	private String studentUsername;
	private String cardNumber;
	private String cardHolderName;
	private String expiryDate;
	
	/**
	 * @return the studentUsername
	 */
	public String getStudentUsername() {
		return studentUsername;
	}
	
	/**
	 * @param studentUsername the studentUsername to set
	 */
	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}
	
	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	
	/**
	 * @param setCardNumber the setCardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	/**
	 * @return the cardHolderName
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}
	
	/**
	 * @param setCardHolderName the setCardHolderName to set
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	
	/**
	 * @return the getExpiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	
	/**
	 * @param setExpiryDate the setExpiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

}
