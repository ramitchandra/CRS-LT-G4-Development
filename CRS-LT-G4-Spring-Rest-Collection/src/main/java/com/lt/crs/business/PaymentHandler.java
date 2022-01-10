package com.lt.crs.business;

import java.util.List;

import com.lt.crs.bean.CardDetails;

public interface PaymentHandler {

	/**
	 * @param studentUsername
	 * @param amount
	 */
	public String makePayment(int studentId);
	
}
