package HackerRank;

import java.util.Scanner;

public class HR7_BeautifulTriplets {

	//https://www.hackerrank.com/challenges/beautiful-triplets
	// the below is my solution
	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int d = stdin.nextInt();
        int [] arr = new int[n]; 
        int count = 0;

        for (int i=0; i<n ; i++)
        {
        	arr[i] = stdin.nextInt();
        }

        
        for (int i=arr.length-1; i>=0; i--)
        { 
        	
        	for (int j=i; j>=0; j--)
        	{
        		if (arr[i]-arr[j] == d)
        		{
        			for (int k=j; k>=0; k--)
        			{
        				if(arr[j]-arr[k]==d)
        				{
        					count++;
        					k = -1;
        					j= -1;
        				}
        			}
        		}
        	}
        	
        }
        System.out.println(count);   

	}

}
