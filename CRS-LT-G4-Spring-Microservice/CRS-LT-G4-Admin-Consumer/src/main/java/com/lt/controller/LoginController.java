package com.lt.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 * Handling login request and send to producer
 *
 */
@RestController
@CrossOrigin
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * Discovery class to handle the communication with server and producer client
	 */
	@Autowired
	DiscoveryClass discoveryClass;
	
	/**
	 * @param loginMap
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * Send details of user trying to login and get request validated from database
	 */
	@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<String> loginUser(@RequestBody Map<String,Object> loginMap) throws RestClientException, IOException {
		logger.info("Inside loginUser method.");
		Map<String, Object> detailsMap = new HashMap<>();
		detailsMap.put("user", loginMap.get("userName").toString());
		detailsMap.put("pass", loginMap.get("password").toString());
		return discoveryClass.discoveryResult("admin-producer","/login", HttpMethod.POST, detailsMap);
	}
	
	/**
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * logout the current admin logged in
	 */
	@RequestMapping(value = "/logout", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<String> logout() throws RestClientException, IOException {
		logger.info("Inside logout method.");
		return discoveryClass.discoveryResult("admin-producer","/logout", HttpMethod.GET);
	}

}
