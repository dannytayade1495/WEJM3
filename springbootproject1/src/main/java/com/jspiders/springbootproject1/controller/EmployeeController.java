package com.jspiders.springbootproject1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springbootproject1.dto.EmployeeDTO;
import com.jspiders.springbootproject1.response.EmployeeResponse;
import com.jspiders.springbootproject1.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/insert")
	public ResponseEntity<EmployeeResponse> insert(@RequestBody EmployeeDTO employee) {
		EmployeeDTO dto = service.insert(employee);
		if (dto != null) {
			return new ResponseEntity<EmployeeResponse>(new EmployeeResponse(false, "Employee inserted. ", dto),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<EmployeeResponse>(new EmployeeResponse(true, "Employee not inserted. "),
				HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/search{id}")
	public ResponseEntity<EmployeeResponse> search(@PathVariable int id) {
		return new ResponseEntity<EmployeeResponse>(new EmployeeResponse(false, "Employee found. "),
				HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<EmployeeResponse> update(@RequestBody EmployeeDTO dto) {
		return new ResponseEntity<EmployeeResponse>(new EmployeeResponse(false, "Employee updated. "),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<EmployeeResponse> delete(@RequestParam int id) {
		return new ResponseEntity<EmployeeResponse>(new EmployeeResponse(false, "Employee deleted. "),
				HttpStatus.ACCEPTED);
	}

}
