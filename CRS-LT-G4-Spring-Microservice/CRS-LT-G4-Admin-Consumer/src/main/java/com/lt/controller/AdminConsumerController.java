package com.lt.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 * Communicates with server and producer to perform admin functionalities
 *
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminConsumerController {
	
	/**
	 * Discovery class to handle the communication with server and produceer client
	 */
	@Autowired
	DiscoveryClass discoveryClass;
	
	/**
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * Connects with producer to fetch all student details
	 */
	@RequestMapping(value = "/getAllStudent", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> getAllStudent() throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/getAllStudent", HttpMethod.GET);
	}
	
	/**
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * Connects with producer to get list of students pending for approval
	 */
	@RequestMapping(value = "/getStudent", produces =MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<String> getListStudent() throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/getStudent", HttpMethod.GET);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * Sends request to producer to approve the provided student
	 */
	@RequestMapping(value = "/validateStudent/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<String> validateStudent(@PathVariable int id) throws RestClientException, IOException {
		System.out.println("Inside Consumer Validate Student:---->"+id);
		return discoveryClass.discoveryResult("admin-producer","/admin/validateStudent", HttpMethod.PUT,Collections.singletonMap("Id", id));
	}

	/**
	 * @param courseMap
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * Send the course details to the producer to store in database
	 */
	@RequestMapping(value = "/addCourse", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<String> addCourse(@RequestBody Map<String,Object> courseMap) throws RestClientException, IOException {
		//String jsonString= new ObjectMapper().writeValueAsString(courseMap);
		return discoveryClass.discoveryResult("admin-producer","/admin/addCourse", HttpMethod.POST,courseMap);
	}
	
	/**
	 * @param courseId
	 * @param courseName
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * Send the course details to the producer to delete from database
	 */
	@RequestMapping(value = "/deleteCourse/{courseId}/{courseName}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCourse(@PathVariable int courseId, @PathVariable String courseName) throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/deleteCourse", HttpMethod.DELETE, Collections.singletonMap(String.valueOf(courseId), courseName));
	}
	
	/**
	 * @param professorMap
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * Add the provided professor to database by sending request to producer
	 * 
	 */
	@RequestMapping(value = "/addProfessor", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addProfessor(@RequestBody Map<String,Object> professorMap) throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/addProfesor", HttpMethod.POST, professorMap);
	}
	
	/**
	 * @param professorId
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * Delete the provided professor to database by sending request to producer
	 */
	@RequestMapping(value = "/deleteProfessor/{professorId}", produces = "plain/text", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProfessor(@PathVariable int professorId) throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/deleteProfessor", HttpMethod.DELETE, Collections.singletonMap("Id", (Integer) professorId));
	}
	
	/**
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * Fetch the details of students whose grades are pending for approval
	 */
	@RequestMapping(value = "/generateReportCard", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<String> generateReportCard() throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/gererateReportCard", HttpMethod.GET);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * Generate the report card for provided student id.
	 */
	@RequestMapping(value = "/validateReportCard/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<String> approveReportCard(@PathVariable int id) throws RestClientException, IOException {
		System.out.println("inside approveReportCard" + id);
		return discoveryClass.discoveryResult("admin-producer","/admin/validateReportCard", HttpMethod.PUT, Collections.singletonMap("Id", id));
	}
	
}
