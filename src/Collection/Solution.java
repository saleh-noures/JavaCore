package Collection;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) 
	{
		
		/* Creating Scanners to read inputs */
		Scanner nmScan = new Scanner(System.in);
        Scanner tScan = new Scanner(System.in);
        Scanner stepsScan = new Scanner(System.in);
		
		/* Reading T */
        System.out.print("Enter T: ");
        int t = tScan.nextInt();
        
        /* Validating T */
        while (t < 1 || t > 5000)
        {
        	System.out.println("T should be between 1 and 5000\n");
        	System.out.print("Enter T: ");
        	t = tScan.nextInt();
        }
		
        System.out.println("\n");
        
        /* Creating Result Array (The Output) */
        String [] result = new String[t]; 
        
		for (int i=0; i< result.length ; i++)
		{
			/* Reading N & M */
			System.out.print("Enter n m: ");
			String nm = nmScan.nextLine();
			String[] nmArray = nm.split(" ");
			
			/* Validating N & M */
			while (Integer.parseInt(nmArray[0]) < 2 || Integer.parseInt(nmArray[0]) > 100 
					|| Integer.parseInt(nmArray[1]) < 0 || Integer.parseInt(nmArray[1]) > 100)
			{
				System.out.println("N should be between 2 and 100 \nM should be between 0 and 100\n");
				System.out.print("Enter n m: ");
				nm = nmScan.nextLine();
				nmArray = nm.split(" ");
			}
			
			/* Reading Steps */
			System.out.print("Enter Steps: ");
			String steps = stepsScan.nextLine();
			String[] stepsArray = steps.split(" ");
			
			/* Validating Steps */
			while (Integer.parseInt(stepsArray[0]) != 0)
			{
				System.out.println("The First step must be Zero\n");
				System.out.print("Enter Steps: ");
				steps = stepsScan.nextLine();
				stepsArray = steps.split(" ");
			}
			
			/* Getting Max Consecutive Ones in the steps array to use it to tell if the case wins or not*/
			int MaxConsecutiveOnes = getMaxConsecutiveOnes(stepsArray);
			
			System.out.println("\n");
			
			/* Telling if a case wins or not*/
			if (MaxConsecutiveOnes >= Integer.parseInt(nmArray[1]))
			{
				result[i] = "NO";
			}
			else 
			{
				result[i] = "YES";
			}

		}
		
		/* Printing output */
		
		for (int i=0; i< result.length ; i++)
		{
			System.out.println(result[i]);
		}
		
		/* Closing Scanners */
		nmScan.close();
		stepsScan.close();
		tScan.close();
	}
	
	public static int getMaxConsecutiveOnes (String[] stepsArray)
	{
		int cnt = 0,max=0;
		for(int i=0;i<stepsArray.length;i++)
		{
		   cnt=0;
		   while(i < stepsArray.length && stepsArray[i].equals("1"))
		   {
		      cnt++;
		      i++;
		   }
		   if(cnt>max) max=cnt;
		}
		return max;
	}

}


