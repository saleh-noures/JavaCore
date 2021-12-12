package HackerRank;
// Climbing the Leaderboard Solution
//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class HR25_ClimbingLeaderboard
{

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
         ArrayList<Integer> playerRanks = new ArrayList<>();
        ArrayList<Integer> rankedList = new ArrayList<>();

        removeDuplicateAndReverse(ranked, rankedList);

        for (int i = 0; i < player.size(); i++) {
            playerRanks.add(getRankBinarySearch(rankedList,player.get(i),0,rankedList.size()-1));
        }
         return playerRanks;
    }


    public static void removeDuplicateAndReverse(List<Integer> ranked,List<Integer> rankedDistinctList)
    {
        rankedDistinctList.add(ranked.get(0));
        for (int i = 1; i < ranked.size(); i++) {
            if ( ranked.get(i-1).intValue() != ranked.get(i).intValue())
            {
                rankedDistinctList.add(ranked.get(i));
            }
        }
        //Collections.reverse(rankedDistinctList);
        rankedDistinctList.stream().forEach(i-> System.out.print(i + ", "));
    }

    private static Integer getRankBinarySearch(ArrayList<Integer> rankedDistinctList, Integer score,int first, int last) {

        if (score < rankedDistinctList.get(rankedDistinctList.size() - 1))
            return rankedDistinctList.size() + 1;

        if (score >= rankedDistinctList.get(0))
            return 1;

        int mid = (last + first)/2;

        if (score.equals(rankedDistinctList.get(mid)))
            return mid + 1;

        if(first >= last)
        {
            if (score < rankedDistinctList.get(last))
                return last + 2;
            else
                return last + 1;
        }

        if(score < rankedDistinctList.get(mid))
            return getRankBinarySearch(rankedDistinctList, score, mid + 1, last);
        else if(score > rankedDistinctList.get(mid))
            return getRankBinarySearch(rankedDistinctList, score, first, mid -1);

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
