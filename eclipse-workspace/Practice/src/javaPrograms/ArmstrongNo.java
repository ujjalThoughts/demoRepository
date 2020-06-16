package javaPrograms;

import java.util.Scanner;

//153=1cube+5cube+3cube
public class ArmstrongNo {

	public static void main(String[] args) {
	int i,j,sum=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a number");
	int n=sc.nextInt();
	int org=n;
	while(n!=0)
	{
		i=n%10;
		n=n/10;
		sum=sum+(i*i*i);
		
	}
	if(sum==org) {
		System.out.println("Armstrong Number");
	}
	else
		System.out.println("Not an Armstrong number");
	}

}
