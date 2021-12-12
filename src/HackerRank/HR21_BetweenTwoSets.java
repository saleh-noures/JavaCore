package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//4/9 test cases failed :(
public class HR21_BetweenTwoSets {

    public static int getTotalX(List<Integer> a, List<Integer> b) {

        int count = 0;

        for (int i = 1; i <= 100; i++) {

            for (int j = 0; j < a.size(); j++) {

               int  aNum = a.get(j);
                if(i%aNum != 0)
                    break;
                if (j == a.size() - 1)
                {
                    for (int k = 0; k < b.size(); k++) {
                     int bNum = b.get(k);
                     if(bNum%i != 0)
                         break;
                     if(k == b.size() -1)
                         count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        int total = getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
