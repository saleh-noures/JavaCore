package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HR19_BirthdayCakeCandles {

    public static int birthdayCakeCandles(List<Integer> candles) {

        int max = candles.get(0);
        int count = 1;

        for (int i = 1; i < candles.size(); i++) {

            int candleH = candles.get(i);

            if (candleH > max){
                max = candleH;
                count = 1;
            }
            else if (candleH == max)
                count++;

        }

        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] candlesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> candles = new ArrayList<>();

        for (int i = 0; i < candlesCount; i++) {
            int candlesItem = Integer.parseInt(candlesTemp[i]);
            candles.add(candlesItem);
        }

        int result = birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
