package HackerRank;

import java.util.*;

/*https://www.hackerrank.com/faq*/

public class HR5_SolveMeFirst {

	static int addNumbers(int a, int b)
	{
		return a + b;
	}
	
	public static void main(String[] args)
	{	
        Scanner in = new Scanner(System.in);		
		int a;
		System.out.println("Enter a: ");
		a = in.nextInt();
		
		int b;
		System.out.println("Enter b: ");
		b = in.nextInt();
		
		String name;
		System.out.println("Enter name: ");
		name = in.next();
		
		System.out.println("Hi "+ name + " The Sum is: " + addNumbers(a,b));

		in.close();
	}
}
