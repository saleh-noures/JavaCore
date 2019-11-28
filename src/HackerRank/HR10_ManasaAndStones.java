package HackerRank;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
//import java.util.stream.Collectors;


//https://www.hackerrank.com/challenges/manasa-and-stones

public class HR10_ManasaAndStones {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
        int tests = stdin.nextInt();
        for(int i = 0; i < tests; i++) {
            int n = stdin.nextInt();
            int a = stdin.nextInt();
            int b = stdin.nextInt();
            int [] stones = stones(n, a, b);
            for (Integer st : stones)
            {
            	System.out.print(st.intValue()+ " ");
            }
            System.out.print("\n");

        }
	}
    static int[] stones(int n, int a, int b) {

        Set<Integer> stones = new TreeSet<Integer>();
        stones.add(new Integer(0));

        for (int i = 1; i < n ; i++) {
            Set<Integer> stonesLayer = new TreeSet<>(); // You have to do this in order not to get ConcurrentModificationException
            for (Integer stone : stones) {
                stonesLayer.add(stone + a);
                stonesLayer.add(stone + b);
            }
            stones = stonesLayer;
        }

        int[] array = stones.stream().mapToInt(i->i).toArray();

        return array;
    }
}
