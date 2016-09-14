package com.learn.sairam;

public class SubString {

	//Subsequence means string may not be continuous
	//but ordering of characters should be same as original string.
	public static void main(String[] args) {
		
				SubString.findSubSequence("srm", "sairam");
			}
			
			public static void findSubSequence(String s1 ,String s2) {
				
				int i = 0;
				int j = 0;
				
			    char stringArray1[] = s1.toCharArray();
			    char stringArray2[] = s2.toCharArray();
				
				
				while (i < s1.length() && j < s2.length() ) {
				
					
					if(stringArray1[i] == stringArray2[j]) {
						
						i++;
						j++;
					}else {
						
						j++;
					}
					
				}
				
				if(i == s1.length()) {
					
					System.out.println("SubSequence Found");
				}else {
					
					System.out.println("SubSequence Not Found");
				}
			}	
		
	}

