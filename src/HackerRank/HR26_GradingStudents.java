package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//https://www.hackerrank.com/challenges/grading/problem
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class HR26_GradingStudents {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);
            if(grade < 38)
                resultList.add(grade);
            else
            {
                if (getNextMultOfFive(grade) - grade < 3)
                    resultList.add(getNextMultOfFive(grade));
                else
                    resultList.add(grade);
            }
        }
        return resultList;
    }

    public static int getNextMultOfFive(int grade){
        int nextMultipleOfFive;
        int l = String.valueOf(grade).length();
        int onePart =  Integer.parseInt(String.valueOf(grade).substring(l -1));
        if (onePart <= 5)
            nextMultipleOfFive = grade + 5 - onePart;
        else
            nextMultipleOfFive = grade + 10 - onePart;

        return nextMultipleOfFive;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
