package HackerRank;
import java.io.*;


//Counting Valleys Solution
//https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=true
//Rank: 366171
public class HR29_CountingValleys {

    public static int countingValleys(int steps, String path) {
        int valleysCount = 0;
        int postion = 0;

        char[] arrSteps = path.toCharArray();


        if(arrSteps[0] == 'U')
            postion++;
        else if (arrSteps[0] == 'D')
            postion--;

        for (int i = 1; i < arrSteps.length; i++) {

            if(arrSteps[i] == 'U')
                postion++;
            else if (arrSteps[i] == 'D')
                postion--;

            if (postion == 0 && arrSteps[i] == 'U')
                valleysCount++;

        }

        return valleysCount;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

