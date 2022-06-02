package com.jspider.springannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jspider.springannotations.beans.DoctorBean;

@Configuration
@ComponentScan(basePackages = {"com.jspider.springannotations"})
public class DoctorConfig {

	@Bean("doctor")
	public DoctorBean getDoctor() {
		return new DoctorBean();
	}
}
