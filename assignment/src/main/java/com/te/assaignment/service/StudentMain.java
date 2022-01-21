package com.te.assaignment.service;

import java.util.Scanner;

import com.te.assignment.dao.StudentMethods;
import com.te.assignment.dto.Student;

public class StudentMain {
	public static void main(String[] args) {
		StudentMethods methods = new StudentMethods();
		Scanner scanner1 = new Scanner(System.in);
		System.out.println(
				"________WELCOME_______\npress 1 to enter ur details\npress 2 to dislpay "
				+ "your id's\npress 3 to display name of student\npress 4 to"
				+ " update your records\npress 5 to display student list\npress 6 to delete record");
		int userInput = scanner1.nextInt();
		switch (userInput) {
		case 1:
			methods.add();
			break;
		case 2 :
			methods.getStudentId();
			break;
		case 3:
			methods.getName();
			break;
		case 4 :
			methods.toUpdate();
			break;
		case 5 :
			methods.allList();
			break;
		case 6:
			methods.toDelete();
			break;
		default:
		 System.err.println("invalid input please enter only above mentioned inputs");
		}

	}
}
