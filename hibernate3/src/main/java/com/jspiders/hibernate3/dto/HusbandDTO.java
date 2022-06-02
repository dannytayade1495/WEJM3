package com.jspiders.hibernate3.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "husband_details")
public class HusbandDTO {

	@Id
	@Column(name = "husband_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "husband_name")
	private String name;

	@Column(name = "husband_age")
	private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	private WifeDTO wife;

}
