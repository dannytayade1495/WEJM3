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
@Table(name = "wife_details")
public class WifeDTO {

	@Id
	@Column(name = "wife_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "wife_name")
	private String name;

	@Column(name = "wife_age")
	private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	private HusbandDTO husband;

}
