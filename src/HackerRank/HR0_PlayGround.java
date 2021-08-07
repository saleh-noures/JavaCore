package HackerRank;


import java.util.*;



public class HR0_PlayGround {

    public static void main(String[] args) {

    int x = 10;

        for (int i = 0; i < x; i++) {

            for (int j = 0; j < x-i-1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

