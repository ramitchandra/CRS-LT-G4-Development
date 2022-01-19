/**
 * 
 */
package com.lt.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.entity.Student;
import com.lt.service.AdminService;

/**
 * @author user112
 *
 */
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/admin/getStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudent() {
		log.info("Inside getStudent method");
		return new ResponseEntity<List<Student>>(adminService.getStudentList(),HttpStatus.OK);
	}
}
