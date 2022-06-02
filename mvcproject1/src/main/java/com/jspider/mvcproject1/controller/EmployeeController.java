package com.jspider.mvcproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

	@GetMapping("/insert")
	public String insertEmployee() {
		return "insertEmployee";
	}

}
