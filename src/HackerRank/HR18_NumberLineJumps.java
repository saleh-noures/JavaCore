package HackerRank;
//https://www.hackerrank.com/challenges/kangaroo/problem
import java.io.*;

public class HR18_NumberLineJumps {

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        String result = "NO";
        int nl1 = x1;
        int nl2 = x2;

        if (v2 >= v1)
        return result;

        while(nl1<nl2)
        {
            nl1 = nl1 + v1;
            nl2 = nl2 + v2;

            if (nl1 == nl2)
            return "YES";
        }

        return result;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
