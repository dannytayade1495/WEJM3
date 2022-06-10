package com.jspiders.springbootproject1.repository;

import org.springframework.data.repository.CrudRepository;

import com.jspiders.springbootproject1.dto.EmployeeDTO;

public interface EmployeeRepository extends CrudRepository<EmployeeDTO, Integer> {

}
