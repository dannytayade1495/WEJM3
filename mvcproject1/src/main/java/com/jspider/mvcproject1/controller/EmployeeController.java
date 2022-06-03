package com.jspider.mvcproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

	@GetMapping("/insert")
	public String insertPage() {
		return "insertEmployee";
	}

	@GetMapping("/search")
	public String searchPage() {
		return "searchEmployee";
	}

	@GetMapping("/remove")
	public String removePage() {
		return "removeEmployee";
	}

	@GetMapping("/update")
	public String updatePage() {
		return "updateEmployee";
	}

}
