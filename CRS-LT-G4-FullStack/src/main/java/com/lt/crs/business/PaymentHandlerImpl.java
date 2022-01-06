package com.lt.crs.business;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.crs.bean.CardDetails;
import com.lt.crs.bean.Course;
import com.lt.crs.bean.Payment;
import com.lt.crs.bean.Student;


@Service
public class PaymentHandlerImpl implements PaymentHandler {

	@Autowired
	StudentHandler studentHandlerImpl;
	
	@Autowired
	CourseHandler courseHandlerImpl;

	@Override
	public String makePayment(int studentId) {
		List<String> courseList = studentHandlerImpl.getAddedCourses().get(studentId);
		int finalCost =0;
		for(Course c : courseHandlerImpl.getCourseList())
		{
			if(courseList.contains(c.getCourseName()))
				finalCost += c.getOnlineFees();
		}
		if (finalCost != 0) {
			return "Payment is successful for the student:" + finalCost;
		} else {
			return "Payment is declined for the student:" + finalCost;
		}

	}

	@Override
	public List<CardDetails> cardDetails() {
		// TODO Auto-generated method stub
		List<CardDetails> cd = new ArrayList<>();

		CardDetails cardDetails1 = new CardDetails();
		cardDetails1.setStudentUsername("Stud1");
		cardDetails1.setCardNumber("1234");
		cardDetails1.setCardHolderName("Stud1");
		cardDetails1.setExpiryDate("209");
		cd.add(cardDetails1);

		CardDetails cardDetails2 = new CardDetails();
		cardDetails2.setStudentUsername("Stud2");
		cardDetails2.setCardNumber("4563");
		cardDetails2.setCardHolderName("Stud2");
		cardDetails2.setExpiryDate("478");
		cd.add(cardDetails2);
		return cd;

	}

}