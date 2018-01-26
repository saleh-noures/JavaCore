package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/chocolate-feast/problem*/

public class HR9_ChocolateFeast_Implementation_Easy {

    static int chocolateFeast(int n, int c, int m)
    {
        // 6 2 2 -> 5
        // 4 1 2 -> 7

        int noc = (n/c);
        int nocPeel = noc;

        while (nocPeel >= m)
        {
            noc =  noc + nocPeel/m;
            nocPeel = nocPeel/m + nocPeel%m ;
        }
        return noc;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            int result = chocolateFeast(n, c, m);
            System.out.println(result);
        }
        in.close();
    }
}
