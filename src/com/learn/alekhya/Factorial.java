package com.learn.alekhya;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

	public static void main(String args[])
	  {
	    int n, c;
	    BigInteger inc = new BigInteger("1");
	    BigInteger fact = new BigInteger("1");
	 
	    @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
	 
	    System.out.println("Input an integer");
	    n = input.nextInt();
	 
	    for (c = 1; c <= n; c++) {
	      fact = fact.multiply(inc);
	      inc = inc.add(BigInteger.ONE);
	    }
	 
	    System.out.println(n + "! = " + fact);
	  }
}
