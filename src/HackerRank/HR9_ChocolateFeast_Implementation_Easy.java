package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/chocolate-feast/problem*/

public class HR9_ChocolateFeast_Implementation_Easy {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = in.nextInt();
        int n = 0;
        int c = 0;
        int m = 0;
        for (int i = 0; i < t ; i++) {
            System.out.println("Enter n, c, m");
            n = in.nextInt();
            c = in.nextInt();
            m = in.nextInt();
            System.out.println(chocolateFeast(n, c, m));
        }
        in.close();
    }
    // n: They represent money to spend, c: cost of a chocolate, m: the number of wrappers he can turn in for a free chocolate.
    static int chocolateFeast(int n, int c, int m) {

        int  noOfChoc = n/c;
        int  w = noOfChoc;

        while (w >= m)
        {
            noOfChoc = noOfChoc + w/m;
            w = (w/m) + (w%m);
        }
        return noOfChoc;
    }

}
