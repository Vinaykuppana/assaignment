package com.te.assignment.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeJdbc implements Serializable{
	private int id;
	private String name;
	private int deptno;
}
