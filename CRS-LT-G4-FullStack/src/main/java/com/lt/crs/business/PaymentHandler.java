package com.lt.crs.business;

import java.util.List;

import com.lt.crs.bean.CardDetails;

public interface PaymentHandler {

	/**
	 * @param studentUsername
	 */
	public void checkPaymentStatus(String studentUsername);

	/**
	 * @param studentUsername
	 * @param amount
	 */
	public void makePayment(String studentUsername, float amount);
	
	/**
	 * @param studentUsername
	 * @param totalAmount
	 */
	public List<CardDetails> cardDetails(String studentUsername, float totalAmount);
	
}
