package HackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class HR7_BeautifulTriplets_Implementation_Easy {

	//https://www.hackerrank.com/challenges/beautiful-triplets
    // for better solution, See page 67 in cracking the coding interview - bottlenecks.
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter n and d");
        int n = in.nextInt();
        int d = in.nextInt();

        int [] arr = new int [n];
        System.out.println("Enter "+ n +" Integer numbers");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(beautifulTriplets(d, arr));

        in.close();
    }


    static int beautifulTriplets(int d, int[] arr) {
        int count = 0;
        HashSet<Integer> values = new HashSet<>();

        for (int num : arr) {
            values.add(num);
        }

        for (int num : arr) {
            if (values.contains(num + d) && values.contains(num + 2 * d)) {
                count++;
            }
        }

        return count;
    }


    static int beautifulTripletsBruteForce (int d, int[] arr) {
        int beautifulTripletsCount = 0;
        for (int i = 0; i < arr.length - 2 ; i++) {
            for (int j = i+1; j < arr.length -1; j++) {
                /*
                 This is brute force solution (will enumerate all combinations),
                 so for performance reasons check if arr[j]-arr[i] ==d as it
                 will reduce the combinations to a third
                */
                if(arr[j]-arr[i] ==d){
                    for (int k = j+1; k < arr.length; k++) {
                        //System.out.println(arr[i]+" "+ arr[j]+" "+arr[k]);
                        if ( arr[k]-arr[j] == d)
                        {
                            beautifulTripletsCount++;
                        }
                    }

                }
            }
        }
        return beautifulTripletsCount;
    }

}
