package HackerRank;


public class HR0_PlayGround {



    public static void main(String[] args) {

        int cnt = 100;

        for (int i = 1; i <= cnt; i++) {

            int noOfSpaceChar = cnt - i;
            int noOfStarChar = i;

            for (int j = 1; j <= noOfSpaceChar; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= noOfStarChar; j++) {
                System.out.print("*");
            }

            System.out.print("\n");
        }
    }
}

