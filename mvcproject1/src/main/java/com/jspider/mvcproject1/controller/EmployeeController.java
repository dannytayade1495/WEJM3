package com.jspider.mvcproject1.controller;

import java.util.List;

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
			map.addAttribute("msg", "Employee inserted successfully..!!");
			map.addAttribute("employee", employee);
			return "insertEmployee";
		}
		return "insertEmployee";
	}

	@GetMapping("/search")
	public String searchPage() {
		return "searchEmployee";
	}

	@PostMapping("/search")
	public String searchData(@RequestParam int id, ModelMap map) {
		EmployeeDTO employee = service.search(id);
		if (employee != null) {
			map.addAttribute("employee", employee);
		} else {
			map.addAttribute("msg", "Employee record not found..!!");
		}

		return "searchEmployee";

	}

	@GetMapping("/remove")
	public String removePage(ModelMap map) {
		List<EmployeeDTO> employees = service.findAllEmployees();
		map.addAttribute("employeeList", employees);

		return "removeEmployee";
	}

	@PostMapping("/remove")
	public String removeData(@RequestParam int id, ModelMap map) {
		service.remove(id);
		map.addAttribute("msg", "Employee removed successfully..!!");
		List<EmployeeDTO> employees = service.findAllEmployees();
		map.addAttribute("employeeList", employees);

		return "removeEmployee";
	}

	@GetMapping("/update")
	public String updatePage(ModelMap map) {
		return "updateEmployee";
	}

	@PostMapping("/update")
	public String updateData() {
		return "updateEmployee";
	}

	@GetMapping("/login")
	public String login() {
		return "loginPage";
	}

	@PostMapping("/login")
	public String loginData(@RequestParam String userName, @RequestParam String password, ModelMap map) {
		EmployeeDTO employee = service.login(userName, password);
		if (employee != null) {
			return "homePage";
		}
		map.addAttribute("msg", "Invalid username or password..!!");
		return "loginPage";
	}
}
