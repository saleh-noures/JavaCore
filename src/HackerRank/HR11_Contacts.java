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

    public static void main(String[] args) {

        int n = 0;
        List<List<String>> queriesList = new ArrayList<>();
        List<String> queryEntry = new ArrayList<>();
        String query;
        List<Integer> res = new ArrayList<>();


        Scanner  in = new Scanner(System.in).useDelimiter("\n");;
        n = in.nextInt();

        for (int i = 0; i < n; i++) {
            query = in.next();
            if(query.substring(0,1).equalsIgnoreCase("a"))
            {
                queryEntry.add(query.substring(0,3));
                queryEntry.add(query.substring(4));
            }else{
                queryEntry.add(query.substring(0,4));
                queryEntry.add(query.substring(5));
            }
            queriesList.add(queryEntry);
            queryEntry = new ArrayList<>();
        }
        res= contacts(queriesList);
        res.forEach(i-> System.out.println(i));
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        List<Integer> results = new ArrayList<>();
        Map<String,Integer> namesMap = new HashMap<>();
        String partialStr;

        for (List<String> entry: queries) {
            String operation = entry.get(0);
            String name = entry.get(1);
            Integer recur;

            if (operation.equalsIgnoreCase("add"))
            {
                for (int i = 0; i < name.length(); i++) {
                    partialStr = name.substring(0,i+1);
                    recur = namesMap.get(partialStr);
                    if (recur != null)
                    {
                        namesMap.put(partialStr, ++recur);
                    } else {
                        namesMap.put(partialStr,1);
                    }
                }
            } else if (operation.equalsIgnoreCase("find"))
            {
                results.add((namesMap.get(name)!=null?namesMap.get(name):0));

            }
        }


        return results;
    }


}