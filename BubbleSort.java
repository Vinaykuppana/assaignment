package com.te.javabasics.assaignment;

import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		String[] name = new String[5];
		String str ;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the names to be sorted");		
		for (int i = 0; i < name.length; i++) {
			name[i]=scanner.nextLine();	
		}
		for (int i = 0; i < name.length-1; i++) {
			for (int j = 0; j < (name.length-i)-1; j++) {
				if(name[j].compareTo(name[j+1]) > 0) {
					str =name[j];
					name[j]=name[j+1];
					name[j+1]=str;
				}
				
			}
			
		}
		for (int i = 0; i < name.length; i++) {
			System.out.println("sorted names are :"+" "+name[i]);
		}
		
	}

}
