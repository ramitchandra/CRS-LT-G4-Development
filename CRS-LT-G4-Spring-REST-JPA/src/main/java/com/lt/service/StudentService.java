package com.lt.service;

import com.lt.dao.StudentDao;
import com.lt.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentdao; 
	
	public void addStudent(Student Student)
	{  
		studentdao.save(Student);  
	}  

}
