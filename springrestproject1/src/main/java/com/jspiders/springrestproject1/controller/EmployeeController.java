package com.jspiders.springrestproject1.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrestproject1.response.EmployeeResponse;

@RestController
public class EmployeeController {

	@GetMapping(path = "/hello", produces = { MediaType.APPLICATION_JSON_VALUE })
	public EmployeeResponse hello() {
		EmployeeResponse response = new EmployeeResponse();
		response.setStatus_code(200);
		response.setMsg("OK");
		return response;
	}

}
