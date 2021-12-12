package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

//Solution for The Grid Search
//https://www.hackerrank.com/challenges/the-grid-search/problem?isFullScreen=false
//Rank: 321791

import static java.util.stream.Collectors.toList;

public class HR32_TheGridSearch {

    public static String gridSearch(List<String> G, List<String> P) {
        HashMap<Integer, ArrayList<Integer>> indxs = new HashMap<>();
        int SearchInd = 0;
        int foundInd;
        String isFound = "NO";


        for (int i = 0; i < G.size(); i++) {
            StringBuilder gRow = new StringBuilder(G.get(i));
            while((gRow.length() - SearchInd) >= P.get(0).length())
            {
                foundInd = gRow.indexOf(P.get(0),SearchInd);
                if(foundInd != -1)
                {
                    if(!indxs.containsKey(i))
                    {
                        ArrayList<Integer> indList =  new ArrayList<>();
                        indList.add(foundInd);
                        indxs.put(i,indList);
                    } else {
                        ArrayList<Integer> indList = indxs.get(i);
                        indList.add(foundInd);
                        indxs.put(i,indList);
                    }
                    SearchInd = foundInd + 1;
                } else {
                    break;
                }
            }
            SearchInd = 0;
        }

        if (indxs.isEmpty())
            return "NO";
        else
        {
            outerloop:
            for (Map.Entry<Integer, ArrayList<Integer>> entry: indxs.entrySet()) {
                int gRowInd = entry.getKey();
                for (int i = 0; i < entry.getValue().size(); i++) {
                    int gColInd = entry.getValue().get(i);
                    if(searchPattern(G,P,gRowInd,gColInd))
                    {
                        isFound = "YES";
                        break outerloop;
                    }
                }
            }
        }
        return isFound;
    }
    public static boolean searchPattern(List<String> G, List<String> P, int gRowInd, int gColInd)
    {
        boolean isFound = true;
        int pLength = P.get(0).length();
        for (int j = 0; j < P.size(); j++) {
            if(!G.get(gRowInd + j).substring(gColInd, gColInd + pLength).equals(P.get(j)))
            {
                isFound =  false;
                break;
            }
        }
        return isFound;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = gridSearch(G, P);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
