package HackerRank;

//https://www.hackerrank.com/challenges/day-of-the-programmer/problem
// Rank is 487,034
import java.io.*;

public class HR22_DayOfTheProgrammer {

    public static String dayOfProgrammer(int year) {
        StringBuilder sb = new StringBuilder();
        //Julian calendar
        if (year >= 1700 && year <= 1917) {

            if (year%4 == 0) // Leap year
                sb.append("12.09.").append(year);
            else
                sb.append("13.09.").append(year);
        }
            else if (year == 1918) // not leap year
        {
            sb.append("26.09.").append(year);
            //The transition from the Julian to Gregorian calendar system occurred in 1918, when the next day after January 31st was February 14th.
            // This means that in 1918, February 14th was the 32nd day of the year in Russia.
        } else if (year >= 1919 && year <= 2700) //Gregorian calendar
        {
            if (year%400 == 0 || (year%4 == 0 && year%100 != 0)) // Leap year
                sb.append("12.09.").append(year);
            else
                sb.append("13.09.").append(year);

        }

        return sb.toString();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
