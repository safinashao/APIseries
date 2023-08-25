package com.qa.base;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isPPalindrome("aba"));

		
	}
	
	public static boolean isPPalindrome(String str) {
		if(str == null)
		return false;
		
		StringBuilder strBld = new StringBuilder(str);
		
		strBld.reverse();
		
		return strBld.toString().equals(str);
		
		
	}

}
