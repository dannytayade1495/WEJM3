package com.jspiders.hibernate3.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "customer_details")
public class CustomerDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int id;
	
	@Column(name = "customer_name")
	private String name;
	
	@Column(name = "customer_contact")
	private long phoneNumber;
	
	@Column(name = "customer_address")
	private String address;
	
	@ManyToMany
	private List<ProductDTO> products;

}
