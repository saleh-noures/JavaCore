package HackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
URL: https://www.hackerrank.com/challenges/contacts/problem
It is very important to understand constrains before solving
any problem, For example, form this challenge constraints we can work out to important points:
        1- In term of performance, it is better to loop over each contact string (max 28 char) than to loop over the list
        of operations (10^5)
        2- It not mentioned that the add and find operations are NOT intervening so we could have a scenario like add add find add ..
*/

/*
This solution uses Tree data structure:
https://github.com/RodneyShag/HackerRank_solutions/blob/master/Data%20Structures/Trie/Contacts/Solution.java
My rank after solving the challenge is 387078
*/



public class HR11_Contacts {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c://saleh//HR"));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }


    static int[] contacts(String[][] queries) {


        List<Integer> result = new ArrayList<Integer>();
        Map<String,Integer> patternMap = new HashMap<String,Integer>();
        String operation = "";
        String pattern = "";
        String contact = "";
        int tmp = 0;
        Integer patternValue = 0;


        for (int i = 0; i < queries.length ; i++) {

            operation = queries[i][0];
            contact = queries[i][1];


            if (operation.equalsIgnoreCase("add"))
            {

                for (int j = 1; j <= contact.length(); j++) {
                    pattern = contact.substring(0,j);
                    patternValue = patternMap.get(pattern);
                    if (patternValue == null)
                    {
                        patternMap.put(pattern,1);
                    }
                    else
                    {
                        tmp = patternValue.intValue();
                        patternMap.remove(pattern);
                        patternMap.put(pattern,tmp + 1);
                    }
                }
            }
            else if (operation.equalsIgnoreCase("find"))
            {
                if (patternMap.get(contact) == null)
                {
                    result.add(new Integer(0));
                }
                else
                {
                    result.add(patternMap.get(contact));
                }
            }
        }

        return result.stream().mapToInt(i->i).toArray();

    }
}
