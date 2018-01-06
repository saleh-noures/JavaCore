package HackerRank;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
//import java.util.stream.Collectors;


//https://www.hackerrank.com/challenges/manasa-and-stones

public class ManasaAndStones {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
        int tests = stdin.nextInt();
        for(int i = 0; i < tests; i++) {
            int n = stdin.nextInt();
            int a = stdin.nextInt();
            int b = stdin.nextInt();

            Set<Integer> stones = new TreeSet<>();
            stones.add(0);

            for (int j=1; j<n; j++)
            {
            	Set<Integer> newStones = new TreeSet<>();
            	for (Integer st : stones)
            	{
            		newStones.add(st+a);
            		newStones.add(st+b);
            	}
            	stones = newStones;
            }

            for (Integer st : stones)
            {
            	System.out.print(st.intValue()+ " ");
            }
            System.out.print("\n");
        }
	}
}
