package HackerRank;


import java.io.*;
import java.math.BigInteger;

//https://www.hackerrank.com/challenges/extra-long-factorials/problem
//My Rank:393666

public class HR27_ExtraLongFactorials {

    public static void extraLongFactorials(int n) {
        System.out.println(calcFactorial(new BigInteger(String.valueOf(n))));

    }

    public static BigInteger calcFactorial(BigInteger num)
    {
        if(num.equals(new BigInteger("1")))
            return new BigInteger("1");
        return num.multiply(calcFactorial(num.subtract(new BigInteger("1"))));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        extraLongFactorials(n);

        bufferedReader.close();
    }
}
