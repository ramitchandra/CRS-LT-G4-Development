package com.lt.crs.business;

import java.util.List;

import com.lt.bean.CardDetails;

public interface PaymentHandler {

	/**
	 * @param studentUsername
	 * @param amount
	 */
	public String makePayment(int studentId);
	
}
