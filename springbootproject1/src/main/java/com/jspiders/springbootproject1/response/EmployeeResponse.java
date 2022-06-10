package com.jspiders.springbootproject1.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.springbootproject1.dto.EmployeeDTO;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {

	private boolean error;

	private String msg;

	private EmployeeDTO data;

	private Iterable<EmployeeDTO> list;

	public EmployeeResponse(boolean error, String msg) {
		super();
		this.error = error;
		this.msg = msg;
	}

	public EmployeeResponse(boolean error, String msg, EmployeeDTO data) {
		super();
		this.error = error;
		this.msg = msg;
		this.data = data;
	}

	public EmployeeResponse(boolean error, String msg, Iterable<EmployeeDTO> list) {
		super();
		this.error = error;
		this.msg = msg;
		this.list = list;
	}

}
