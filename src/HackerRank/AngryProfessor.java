package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AngryProfessor {

	public static void main(String[] args) {
		
		
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String [] output = new String[t];
        
        for(int a0 = 0; a0 < t; a0++){
        	
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            int goodAtten = 0;
            for(int a_i=0; a_i < n; a_i++){
            	
                a[a_i] = in.nextInt();
                
                if (a[a_i] <= 0)
                {
                	goodAtten++;
                }
            }
            
            if (goodAtten >= k)
            {
            	output[a0] = "NO";
            }
            else 
            {
            	output[a0] = "YES";
            }
	}
        
        for (String s : output)
        {
        	System.out.println(s);
        }
        
		
	}


}
