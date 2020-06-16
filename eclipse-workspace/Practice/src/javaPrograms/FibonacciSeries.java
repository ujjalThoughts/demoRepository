package javaPrograms;

import java.util.Scanner;

//1	1	2	3	5	8	13	21.....n
public class FibonacciSeries {

	public static void main(String args[])
	{
		int i=1,j=1,sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int n=sc.nextInt();
		
		System.out.print(i+ " " +j);
		while(sum<n)
		{
			sum=i+j;
			i=j;
			j=sum;
			System.out.print(" "+sum);
		}
	}
}
