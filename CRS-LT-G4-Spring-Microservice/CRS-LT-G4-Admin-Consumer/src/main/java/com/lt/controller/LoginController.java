package com.lt.controller;

import java.io.IOException;
import java.util.HashMap;
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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
	@Autowired
	DiscoveryClass discoveryClass;
	
	@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<String> loginUser(@RequestBody Map<String,Object> loginMap) throws RestClientException, IOException {
		Map<String, Object> detailsMap = new HashMap<>();
		detailsMap.put("user", loginMap.get("userName").toString());
		detailsMap.put("pass", loginMap.get("password").toString());
		return discoveryClass.discoveryResult("admin-producer","/login", HttpMethod.POST, detailsMap);
	}
	
	@RequestMapping(value = "/logout", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> logout() throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/logout", HttpMethod.GET);
	}

}
