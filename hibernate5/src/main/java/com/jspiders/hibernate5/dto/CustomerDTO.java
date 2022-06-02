package com.jspiders.hibernate5.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "customer_details")
public class CustomerDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private long phoneNumber;

	private String address;

	@ManyToMany
	@JoinTable(name = "customers_products", 
	joinColumns = @JoinColumn
	(referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn
	(referencedColumnName = "id"))
	private List<ProductDTO> products;

}
