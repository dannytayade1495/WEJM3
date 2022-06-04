package com.jspider.mvcproject1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspider.mvcproject1.dto.EmployeeDTO;
import com.jspider.mvcproject1.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/insert")
	public String insertPage() {
		return "insertEmployee";
	}

	@PostMapping("/insert")
	public String insertData(@RequestParam String name, @RequestParam String email, @RequestParam String designation,
			@RequestParam String userName, @RequestParam String password, ModelMap map) {
		EmployeeDTO employee = service.insert(name, email, designation, userName, password);
		if (employee != null) {
			map.addAttribute("employee", employee);
			return "insertData";
		}
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
