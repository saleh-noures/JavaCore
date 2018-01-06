package HackerRank;

import java.util.Scanner;

public class HR0_PlyGround 
{
	public static void main(String[] args) 
	{
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int d = in.nextInt();
        int[] ar = new int[n];
        
        for(int ar_i = 0; ar_i < n; ar_i++){
        	
            ar[ar_i] = in.nextInt();
            
        }
        
        int result = beautifulTriplets(n, d, ar);
        System.out.println(result);
		
	}
	
	private static int beautifulTriplets(int n, int d, int[] arr)
	{
		int count = 0;
		boolean x = false;
		boolean y = false;
		
        //1 2 4 5 7 8 10
		
		//8 2
		//1 4 6 8 10 11 12 15
		
		for (int i=0; i<n; i++)
		{
			for( int j=i; j<n; j++)
			{
			  if(arr[j]-arr[i]==d)
			  {
				  x = true;
				  break;
			  }
			}
			
			for (int k=i; k>=0; k--)
			{
				  if(arr[i]-arr[k]==d)
				  {
					  y = true;
					  break;
				  }
			}	
			
			if (x && y)
			{
				count++;
				x = false;
				y = false;
			}
				
			
		}
		
		return count;
		
	}
}
