package com.lt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.StudentDao;
import com.lt.entity.Student;

@Service
public class AdminService {
	
	@Autowired
	StudentDao studentDao;

	public List<Student> getStudentList() {
		return (List<Student>) studentDao.findAll();
	}

}
