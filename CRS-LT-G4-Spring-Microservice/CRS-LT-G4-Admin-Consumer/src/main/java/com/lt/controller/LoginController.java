package com.lt.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
public class LoginController {
	
	@Autowired
	DiscoveryClass discoveryClass;
	
	@RequestMapping(value = "/login/{userName}/{userPassword}", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> loginUser(@PathVariable String userName, @PathVariable String userPassword) throws RestClientException, IOException {
		Map<String, Object> detailsMap = new HashMap<>();
		detailsMap.put("user", userName);
		detailsMap.put("pass", userPassword);
		return discoveryClass.discoveryResult("admin-producer","/login", HttpMethod.POST, detailsMap);
	}
	
	@RequestMapping(value = "/logout", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> logout() throws RestClientException, IOException {
		return discoveryClass.discoveryResult("admin-producer","/logout", HttpMethod.GET);
	}

}
