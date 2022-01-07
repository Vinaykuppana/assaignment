package com.te.javabasics.assaignment;

import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		int array[] = new int[20];
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the size of the array");
		int size = scanner.nextInt();
		System.out.println("enter the elements");
		for (int i = 0; i < size; i++) {
			array[i]=scanner.nextInt();			
		}
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				if(array[i]>array[j]) {
					int temp = array[i];
					array[i]=array[j];
					array[j]=temp;
				}
				
			}
			
		}
		for (int i = 0; i < size; i++) {
			System.out.println("sorted array is :"+" "+array[i]);
			
		}
	}
	
}
