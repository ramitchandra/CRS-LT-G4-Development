package com.lt.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;



@RestController
public class ProfessorConsumerController {
	
	@Autowired
	DiscoveryClass discoveryClass;
	
	@RequestMapping(value = "/professor/listStudent", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> getStudentList() throws RestClientException, IOException {
		return discoveryClass.discoveryResult("professor-producer","/professor/getStudentList", HttpMethod.GET);
	}
	
	@RequestMapping(value = "/professor/addGrades", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addGrades(@RequestBody Map<String,Object> gradeMap) throws RestClientException, IOException {
		return discoveryClass.discoveryResult("professor-producer","/professor/addGrades", HttpMethod.POST, gradeMap);
	}
	
}
