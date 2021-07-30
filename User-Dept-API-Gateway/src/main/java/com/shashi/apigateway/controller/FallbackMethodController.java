package com.shashi.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {
	
	@GetMapping("/fallbackUserService")
	public String userServiceFallbackMethod()
	{
		return "User Service is not responding. Please try letter.";
	}
	
	@GetMapping("/fallbackDepatmentService")
	public String departmentServiceFallbackMethod()
	{
		return "Department Service is not responding. Please try letter.";
	}

}
