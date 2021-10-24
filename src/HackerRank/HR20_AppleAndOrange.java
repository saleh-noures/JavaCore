package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HR20_AppleAndOrange {


    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
       int appleCount = 0, orangeCount = 0;

        for (int i = 0; i < apples.size(); i++) {
            int appleLoc = apples.get(i) + a;
            if(appleLoc >= s && appleLoc <= t )
                appleCount++;
        }
        System.out.println(appleCount);

        for (int i = 0; i < oranges.size(); i++) {
            int orangeLoc = oranges.get(i) + b;
            if(orangeLoc >= s && orangeLoc <= t )
                orangeCount++;
        }

        System.out.println(orangeCount);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        String[] applesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> apples = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesTemp[i]);
            apples.add(applesItem);
        }

        String[] orangesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> oranges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesTemp[i]);
            oranges.add(orangesItem);
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
}
