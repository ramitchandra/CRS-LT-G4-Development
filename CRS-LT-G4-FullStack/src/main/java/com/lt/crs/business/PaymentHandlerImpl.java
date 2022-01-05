package com.lt.crs.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.lt.crs.bean.CardDetails;
import com.lt.crs.bean.Payment;
import com.lt.crs.bean.Student;

@Service
public class PaymentHandlerImpl implements PaymentHandler {

	Scanner sc = new Scanner(System.in);

	@Override
	public void checkPaymentStatus(String studentUsername) {
		// TODO Auto-generated method stub

	}

	@Override
	public void makePayment(String studentUsername, float amount) {
		// TODO Auto-generated method stub
		System.out.println("Please Enter the Amount to be paid: ");
		String amountToPaid = sc.next();
		if (amountToPaid != null) {
			System.out.println("Payment is successful for the student:" + studentUsername);
		} else {
			System.out.println("Payment is declined for the student:" + studentUsername);
		}

	}

	@Override
	public List<CardDetails> cardDetails(String studentUsername, float totalAmount) {
		// TODO Auto-generated method stub
		List<CardDetails> cd = new ArrayList<>();

		CardDetails cardDetails1 = new CardDetails();
		cardDetails1.setStudentUsername("ABC");
		cardDetails1.setCardNumber("1234");
		cardDetails1.setCardHolderName("Sai");
		cardDetails1.setExpiryDate("209");
		cd.add(cardDetails1);

		CardDetails cardDetails2 = new CardDetails();
		cardDetails2.setStudentUsername("DGF");
		cardDetails2.setCardNumber("4563");
		cardDetails2.setCardHolderName("Teja");
		cardDetails2.setExpiryDate("478");
		cd.add(cardDetails2);
		return cd;

	}

}