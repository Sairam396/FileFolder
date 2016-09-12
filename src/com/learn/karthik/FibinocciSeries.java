package com.learn.karthik;

import java.util.Scanner;

public class FibinocciSeries {
	
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	
	System.out.println("How many numbers woud you want in the fibinocci series");
	int n=scan.nextInt();
	
	int a,b,c;
	a=1;
	b=2;
	
	int flag=1;
	while(flag<=n){
		System.out.println(a+",");
		c=a+b;
		a=b;
		b=c;
		flag++;
		
	}	
	
}
}
																																																																																																																																																																																																																																																																																																																																																																																																																																		