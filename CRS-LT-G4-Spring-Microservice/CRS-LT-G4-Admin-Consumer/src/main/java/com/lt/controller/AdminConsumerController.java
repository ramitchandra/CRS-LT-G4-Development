package com.lt.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class AdminConsumerController {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@RequestMapping(value = "/adminClient", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> getEmployee() throws RestClientException, IOException {
		return discoveryResult("admin-producer","/admin/getStudent");
	}
	
	private ResponseEntity<String> discoveryResult(String clientName, String producerUrl){
		
		List<ServiceInstance> instances=discoveryClient.getInstances(clientName);

		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+producerUrl;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try {
			response=restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(),String.class);
		} catch (Exception ex) {
			//TODO
		}
		
		return response;
	}
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
