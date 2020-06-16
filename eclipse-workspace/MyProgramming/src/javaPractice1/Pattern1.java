package javaPractice1;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String args[])
	{
	int num=1;
	Scanner sc=new Scanner(System.in);
	System.out.println("How many rows you want in this pattern?");
	int rows = sc.nextInt();
	for(int i=1;i<=rows;i++)
	{
		for(int j=1;j<=i;j++)
		{
			System.out.print(num+" ");
			num++;
		}
		System.out.println();
		num++;
	}
	sc.close();
}
}