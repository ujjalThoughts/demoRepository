package javaPrograms;

import java.util.Scanner;

public class PalindromeString {

	public static void main(String[] args) {

			
			String reverse;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter a String");
			String n=sc.nextLine();
			
			reverse=new StringBuffer(n).reverse().toString();
			
			if(reverse.equals(n))
				System.out.println("String Palindrome");
			else
				System.out.println("Not String Palindrome");

	}

}
