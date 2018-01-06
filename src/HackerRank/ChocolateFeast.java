package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**** Not complete *****/
public class ChocolateFeast {

	public static void main(String[] args) {

		
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int [] output = new int[t];
        int noOfCh = 0;
        for(int a0 = 0; a0 < t; a0++){
        	
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            
            int noOfWr = (n/c);
            noOfCh = (n/c) + (noOfWr/m);

            
            while (noOfWr > m)
            {
            	noOfWr = noOfWr/m;
            	noOfCh = noOfCh + (noOfWr/m) ;
            	
            }
            
            output[a0] =  noOfCh;
        }

        for (int o : output)
        {
        	System.out.println(o);
        }
	}

}
