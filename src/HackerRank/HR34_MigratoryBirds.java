package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// Migratory Birds Solution
//https://www.hackerrank.com/challenges/migratory-birds/problem?isFullScreen=false
//Rank: 309348
public class HR34_MigratoryBirds {

    public static int migratoryBirds(List<Integer> arr) {
        int mostSightedBirds = 0;

        int [] birdTypeArr = new int[6];

        for (int i = 0; i < arr.size(); i++) {
            birdTypeArr[arr.get(i)] = ++birdTypeArr[arr.get(i)];
        }

        mostSightedBirds = birdTypeArr[0];

        for (int i = 1; i < birdTypeArr.length; i++) {
            if (mostSightedBirds < birdTypeArr[i])
                mostSightedBirds = birdTypeArr[i];
        }

        for (int i = 1; i < birdTypeArr.length; i++) {
            if(birdTypeArr[i] == mostSightedBirds)
                return i;
        }

        return 0;
    }


    public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
}
}
