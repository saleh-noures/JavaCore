package HackerRank;


import java.util.*;



public class HR0_PlayGround {

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

    private static int[] stones(int n, int a, int b) {
        
        Set<Integer> stonesLayer = new TreeSet<>();
        stonesLayer.add(0);

        for (int i = 0; i < n -1 ; i++) {

            Set<Integer> tempStonesLayer = new TreeSet<>();

            for (Integer stone: stonesLayer) {
                tempStonesLayer.add(stone + a);
                tempStonesLayer.add(stone + b);
            }
            stonesLayer = tempStonesLayer;
        }

        for (Integer stone :stonesLayer) {
            System.out.print(stone.intValue() + " ");
        }
        return new int[0];
    }
}