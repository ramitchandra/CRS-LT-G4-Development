package com.lt.crs.business;

import java.util.List;

import com.lt.bean.CardDetails;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 * 
 *         Interface for Payment Operations
 */
public interface PaymentHandler {

	/**
	 * Method to make Payment
	 * 
	 * @param studentId
	 */
	public String makePayment(int studentId);

}
