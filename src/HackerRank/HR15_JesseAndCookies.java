package HackerRank;

//https://www.hackerrank.com/challenges/jesse-and-cookies/problem
//https://www.educative.io/blog/data-structures-stack-queue-java-tutorial

//Time limit exceeded. Got 20 points form this challenge.

import java.util.*;

public class HR15_JesseAndCookies {


    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {

        int num1, num2, num3, counter = 0;

        Collections.sort(A);

         //A.stream().forEach(num-> System.out.print(num +" "));
        // System.out.println("\n");


        while(A.get(0) < k )
        {
            if (A.size() < 2)
            {
                return -1;
            }
            num1 = A.remove(0);
            num2 = A.remove(0);
            num3 = num1 + (num2 * 2);

            if (A.size() < 2)
                A.add(num3);
            else if (num3 >= A.get(A.size()-1))
                A.add(A.size(),num3);
            else if (num3 <= A.get(0))
                A.add(0,num3);
            else{
                for (int i = 0; i < A.size() -1; i++) {  //1 2 3 9 10 12
                    if (num3 >= A.get(i) && num3 < A.get(i+1)){
                        A.add(i+1,num3);
                        break;
                    }
                }

            }

           // A.stream().forEach(num-> System.out.print(num +" "));
           // System.out.println("\n");
            //A.add(0, num3);
           // Collections.sort(A);
            ++counter;
        }

        return counter;
    }
        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            List<Integer> arr = new ArrayList<>();

            int n, k;
            System.out.println("Enter n & k: ");
            n = in.nextInt();
            k = in.nextInt();

            System.out.println("Enter arr: ");
            for (int i = 0; i < n; i++) {
                arr.add(in.nextInt());
            }
            System.out.println(cookies(k,arr));
            in.close();
        }


    }


