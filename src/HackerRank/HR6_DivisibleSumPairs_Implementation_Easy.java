package HackerRank;

import java.util.Scanner;

/*https://www.hackerrank.com/challenges/divisible-sum-pairs/problem*/

public class HR6_DivisibleSumPairs_Implementation_Easy {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println(" Enter 'n' then 'k'");
        int n = in.nextInt();
        int k = in.nextInt();

        int [] arr = new int[n];
        System.out.println("Enter arr of " + n + " elements");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(getDivisibleSumPair(n, k, arr));

        in.close();
    }

    public static int getDivisibleSumPair(int n, int k, int [] arr) {

        int DivisibleSumPair = 0;
        for (int i = 0; i < n -1 ; i++) {
            for (int j = i+1; j <n ; j++) {
                if ((arr[i] + arr[j])%k == 0 )
                {
                    DivisibleSumPair++;
                }
            }
        }
        return DivisibleSumPair;

    }

}
 