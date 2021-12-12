package HackerRank;

import java.io.*;
import java.util.Arrays;

public class HR24_BeautifulDaysAtTheMovies {

    public static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for (int l = i; l <= j; l++) {
            StringBuilder sb = new StringBuilder();
            if ((l-Integer.parseInt(sb.append(l).reverse().toString()))%k == 0)
                count++;
        }
    return count;
    }
    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
