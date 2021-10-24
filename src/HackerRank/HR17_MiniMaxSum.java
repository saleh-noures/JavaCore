package HackerRank;

//https://www.hackerrank.com/challenges/mini-max-sum/problem

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HR17_MiniMaxSum {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 5 numbers: ");
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }
        miniMaxSum(list);
        in.close();
    }

    public static void miniMaxSum(List<Integer> arr) {

        BigInteger min = new BigInteger("0");
        BigInteger max = new BigInteger("0");
        Collections.sort(arr);
        min = min.add(new BigInteger(arr.get(0).toString())).add(new BigInteger(arr.get(1).toString()))
                .add(new BigInteger(arr.get(2).toString())).add(new BigInteger(arr.get(3).toString()));
        max = max.add(new BigInteger(arr.get(1).toString())).add(new BigInteger(arr.get(2).toString()))
                .add(new BigInteger(arr.get(3).toString())).add(new BigInteger(arr.get(4).toString()));
        System.out.println(min +" "+ max);
    }
}
