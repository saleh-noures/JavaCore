package Nasdaq;

import java.math.BigInteger;


public class Assignment {
    public static void main(String[] args) {

        long n = 1000000;
        long c = 200;
        BigInteger sum = BigInteger.ZERO;
        BigInteger product = BigInteger.ONE;
        BigInteger Big_i;
        
        for (int i = 2; i <= n ; i++) {

            //Calculate the last element in c rang
            Big_i =  new BigInteger( Integer.toString(i - 1));
            if (c >= i - 1)
            {
                //Multiply by the last element in c range
                product = product.multiply(Big_i);
            }
            else
            {
                //Calculate the first element in c range
                BigInteger numerator = new BigInteger(Long.toString(i - c - 1));
                //Multiply by the last element in c range then divide by the first element in c range
                product = product.multiply(Big_i).divide(numerator);
            }
            sum = sum.add(product);
        }
        System.out.println("The result is " + sum);

    }
}