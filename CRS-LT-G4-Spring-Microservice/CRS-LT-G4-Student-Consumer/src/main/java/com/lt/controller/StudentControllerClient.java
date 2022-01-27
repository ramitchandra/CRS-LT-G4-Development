package com.lt.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

/**
 * @author Naman, Radha, Ramit, Purnima, Sai, Vignesh
 *
 */
@RestController
public class StudentControllerClient {

	/**
	 * This is used to autowire discoveryClass
	 */
	@Autowired
	DiscoveryClass discoveryClass;

	@RequestMapping(value = "/getMessage", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> getMessage() throws RestClientException, IOException {
		return discoveryClass.discoveryResult("student-producer", "/getMessage", HttpMethod.GET);
	}

	/**
	 * @param student
	 * @return this is used for student self register
	 */
	@RequestMapping(value = "/addStudent", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addStudent(@RequestBody Map<String, Object> studentMap)
			throws RestClientException, IOException {
		return discoveryClass.discoveryResult("student-producer", "/addStudent", HttpMethod.POST, studentMap);
	}

	/**
	 * @param Course
	 * @param id
	 * @return Students select course implementation
	 */
	@RequestMapping(value = "/student/addCourse/{id}/{Course}", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addCourse(@PathVariable String Course, @PathVariable int id)
			throws RestClientException, IOException {
		Map<String, Object> courseMap = new HashMap<String, Object>();
		courseMap.put("Course", Course);
		courseMap.put("Id", String.valueOf(id));

		return discoveryClass.discoveryResult("student-producer", "/student/addCourse", HttpMethod.POST,
				courseMap);
	}

	/**
	 * @param Course
	 * @param id
	 * @return This method is used for deleting course from selected courses
	 */
	@RequestMapping(value = "/student/dropCourse/{id}/{Course}", produces = "plain/text", method = RequestMethod.DELETE)
	public ResponseEntity<String> dropCourse(@PathVariable String Course, @PathVariable int id)
			throws RestClientException, IOException {
		Map<String, Object> delCourseMap = new HashMap<String, Object>();
		delCourseMap.put("Course", Course);
		delCourseMap.put("Id", String.valueOf(id));
		return discoveryClass.discoveryResult("student-producer", "/student/dropCourse",
				HttpMethod.DELETE, delCourseMap);
	}

	/**
	 * @param id
	 * @return This method is register for course
	 */
	@RequestMapping(value = "/student/registerCourse/{id}", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> registerCourse(@PathVariable int id) throws RestClientException, IOException {
		Map<String, Object> regCourseMap = new HashMap<String, Object>();
		regCourseMap.put("Id", String.valueOf(id));
		return discoveryClass.discoveryResult("student-producer", "/student/registerCourse", HttpMethod.POST,
				regCourseMap);
	}

	/**
	 * @param studentId
	 * @return This method is used for making payment for the enrolled courses
	 */
	@RequestMapping(value = "/payment/{studentId}", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> payment(@PathVariable int studentId) throws RestClientException, IOException {
		return discoveryClass.discoveryResult("student-producer", "/payment/{studentId}", HttpMethod.GET);
	}

}
