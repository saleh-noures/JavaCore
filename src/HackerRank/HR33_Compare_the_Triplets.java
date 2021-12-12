package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=false
//Rank: 315273
public class HR33_Compare_the_Triplets {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        ArrayList<Integer> list = new ArrayList<>();
        int aScore = 0;
        int bScore = 0;

        for (int i = 0; i < 3; i++) {
            if(a.get(i) > b.get(i))
                aScore++;
            else if (a.get(i) < b.get(i))
                bScore++;
        }
        list.add(aScore);
        list.add(bScore);
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
