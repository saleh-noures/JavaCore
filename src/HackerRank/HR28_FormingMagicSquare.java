package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// Forming a Magic Square solution
//https://www.hackerrank.com/challenges/magic-square-forming/problem
//Rank: 377,547

public class HR28_FormingMagicSquare {

    public static int formingMagicSquare(List<List<Integer>> s) {

        int cost = 0;
        int minCost = 0;

        int[][][] allPermutations = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},// 1
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},// 2
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},// 3
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},// 4
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},// 5
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},// 6
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},// 7
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},// 8
        };

        for (int i = 0; i < allPermutations.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cost = cost + Math.abs(allPermutations[i][j][k] - s.get(j).get(k));
                }
            }
            if( i == 0)
            {
                minCost = cost;
            }
            if (cost < minCost)
                minCost = cost;
            cost = 0;
        }

        return minCost;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
