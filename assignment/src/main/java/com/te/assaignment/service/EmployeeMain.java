package com.te.assaignment.service;

import java.util.Scanner;

import com.te.assignment.dao.EmployeeJdbcMethod;

public class EmployeeMain {
	public static void main(String[] args) {
		EmployeeJdbcMethod employeeJdbcMethod = new EmployeeJdbcMethod();
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"enter 1 to insert data\npress 2 to display the data\npress 3 to update\npress 4 to delete data");

		int userInput1 = scanner.nextInt();
		switch (userInput1) {
		case 1:
			employeeJdbcMethod.insertData();
			break;
		case 2:
			employeeJdbcMethod.allData();			
			break;
		case 3:
			employeeJdbcMethod.updateData();
			break;
		case 4:
			employeeJdbcMethod.deleteData();
			break;
		default:
			System.err.println("invalid input please enter only the above inputs");

		}
		scanner.close();

	}

}
