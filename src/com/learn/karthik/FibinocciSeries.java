//program for fibinocci series

package com.learn.karthik;

import java.util.Scanner;

public class FibinocciSeries {
	
public static void main(String[] args) {
	int first=10;
	int second=15;
	int next;
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the number of terms for fibinocci series");
	
	int numberOfTerms=scan.nextInt();
	
	System.out.println(first + "," + second);
	
	for (int count=3; count <= numberOfTerms; count++);
	
	next= first+second;
	System.out.println("," + next);
	
	first= second;
	second=next;
	
		
	}	
	
}
}
																																																																																																																																																																																																																																																																																																																																																																																																																																		