package com.microservices.limits.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limits.service.configuration.LimitsServiceConfig;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsController {

	@Autowired
	private LimitsServiceConfig config;
	
	@GetMapping("/limits")
	public String getLimits() {
		return "Minimum : " + config.getMinimum() + "\t Maximum : " + config.getMaximum();
	}
	
	@GetMapping("/limits2")
	@HystrixCommand(fallbackMethod="fallbackLimits")
	public String getLimits2() {
		throw new RuntimeException("Exception occured iun Limits2 service");
	}
	
	public String fallbackLimits() {
		return "Minimum : " + Integer.MIN_VALUE + "\t Maximum : " + Integer.MAX_VALUE;
	}
	
}
