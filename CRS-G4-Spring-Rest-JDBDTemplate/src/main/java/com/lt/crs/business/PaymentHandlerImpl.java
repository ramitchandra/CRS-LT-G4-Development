package com.lt.crs.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.CardDetails;
import com.lt.bean.Course;
import com.lt.bean.Payment;
import com.lt.bean.Student;

@Service
public class PaymentHandlerImpl implements PaymentHandler {

	@Autowired
	StudentHandler studentHandlerImpl;
	
	@Autowired
	CourseHandler courseHandlerImpl;
	
	@Override
	public String makePayment(int studentId) {
		
		List<String> courseList = studentHandlerImpl.getAddedCourses().get(studentId);
		int finalCost = 0;
		for(Course c : courseHandlerImpl.getCourseList())
		{
			if(courseList.contains(c.getOnlineFees()))
			{
				finalCost += c.getOnlineFees();
			}
		}
		if (finalCost != 0) {
			return "Payment is successful for the student:" + finalCost;
		} 
		else {
			return "Payment is declined for the student:" + finalCost;
		}

	}

}