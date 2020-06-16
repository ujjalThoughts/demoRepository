package javaPrograms;

import java.util.Scanner;

// 141=141
public class PalindromeInt {

	public static void main(String[] args) {
		int i,j,sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int n=sc.nextInt();
		int temp=n;
		while(n>0) {
			i=n%10;
			n=n/10;
		
		sum=(sum*10)+i;
		}
		
		if(sum==temp)
			System.out.println("Palindrome Number");
		else 
			System.out.println("Not Palindrome");
	}
}
