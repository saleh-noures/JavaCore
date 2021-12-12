package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

//Solution for Non-Divisible Subset
//https://www.hackerrank.com/challenges/non-divisible-subset/problem
//Rank: 356323

import static java.util.stream.Collectors.toList;

public class HR30_NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        ArrayList<Integer> maxSubset = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> remainderMap = new HashMap<>();
        fillRemainderList(k,s,remainderMap);

       for (Map.Entry entry: remainderMap.entrySet()) {
            System.out.print(entry.getKey()+":");
            System.out.println(entry.getValue());
            System.out.println("\n");
        }

        if(remainderMap.containsKey(0))
            maxSubset.add(remainderMap.get(0).get(0));

        for (int i = 1; i <= k; i++) {

            if (i > k-i)
                break;

            if (i == k-i)
                maxSubset.add(remainderMap.get(i).get(0));
            else if (remainderMap.containsKey(i) && remainderMap.containsKey(k-i))
            {
                if (remainderMap.get(i).size() >= remainderMap.get(k-i).size())
                    maxSubset.addAll(remainderMap.get(i));
                else
                    maxSubset.addAll(remainderMap.get(k-i));
            }
            else if (remainderMap.containsKey(i))
            {
                maxSubset.addAll(remainderMap.get(i));
            }
            else if(remainderMap.containsKey(k-i))
            {
                maxSubset.addAll(remainderMap.get(k-i));
            }
        }
        System.out.println("Max Set:"+ maxSubset);
        return maxSubset.size();
    }

    public static void fillRemainderList(int k, List<Integer> s, HashMap<Integer, ArrayList<Integer>> map){

        for (int i = 0; i < s.size(); i++) {
          int rem = s.get(i)%k;
         if(map.containsKey(rem))
             map.get(rem).add(s.get(i));
         else
         {
             ArrayList<Integer> list = new ArrayList<>();
             list.add(s.get(i));
             map.put(rem, list);
         }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
