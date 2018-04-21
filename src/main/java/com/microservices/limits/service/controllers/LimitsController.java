package com.microservices.limits.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limits.service.configuration.LimitsServiceConfig;

@RestController
public class LimitsController {

	@Autowired
	private LimitsServiceConfig config;
	
	@GetMapping("/limits")
	public String getLimits() {
		return "Minimum : " + config.getMinimum() + "\t Maximum : " + config.getMaximum();
	}
	
}
