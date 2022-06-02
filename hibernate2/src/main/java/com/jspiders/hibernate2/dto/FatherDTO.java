package com.jspiders.hibernate2.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "father_details")
public class FatherDTO {

	@Id
	@Column(name = "father_name")
	private String name;

	@Column(name = "father_age")
	private int age;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "father_child", joinColumns = @JoinColumn(referencedColumnName = "father_name"), inverseJoinColumns = @JoinColumn(referencedColumnName = "child_name"))
	private ChildDTO child;
}
