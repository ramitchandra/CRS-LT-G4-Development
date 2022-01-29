package com.lt.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

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

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminConsumerController {
	
	@Autowired
	DiscoveryClass discoveryClass;
	
	@RequestMapping(value = "/getAllStudent", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> getAllStudent() throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/getAllStudent", HttpMethod.GET);
	}
	
	@RequestMapping(value = "/getStudent", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> getListStudent() throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/getStudent", HttpMethod.GET);
	}
	
	@RequestMapping(value = "/validateStudent/{id}", produces = "plain/text", method = RequestMethod.PUT)
	public ResponseEntity<String> validateStudent(@PathVariable int id) throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/validateStudent", HttpMethod.PUT,Collections.singletonMap("Id", (Integer) id));
	}

	@RequestMapping(value = "/addCourse", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addCourse(@RequestBody Map<String,Object> courseMap) throws RestClientException, IOException {
		//String jsonString= new ObjectMapper().writeValueAsString(courseMap);
		return discoveryClass.discoveryResult("admin-producer","/admin/addCourse", HttpMethod.POST,courseMap);
	}
	
	@RequestMapping(value = "/deleteCourse/{courseId}/{courseName}", produces = "plain/text", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCourse(@PathVariable int courseId, @PathVariable String courseName) throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/deleteCourse", HttpMethod.DELETE, Collections.singletonMap(String.valueOf(courseId), courseName));
	}
	
	@RequestMapping(value = "/addProfessor", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> getListStudent(@RequestBody Map<String,Object> professorMap) throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/addProfesor", HttpMethod.POST, professorMap);
	}
	
	@RequestMapping(value = "/deleteProfessor/{professorId}", produces = "plain/text", method = RequestMethod.DELETE)
	public ResponseEntity<String> getListStudent(@PathVariable int professorId) throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/admin/deleteProfessor", HttpMethod.DELETE, Collections.singletonMap("Id", (Integer) professorId));
	}
	
}
