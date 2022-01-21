package com.te.assignment.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
@Table(name = "student")
@AllArgsConstructor
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private String name;
	private double marks;
	private String section;
	public Student() {
		
	}
	
	
	
	

}
