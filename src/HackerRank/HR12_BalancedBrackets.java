/*
https://www.hackerrank.com/challenges/balanced-brackets/problem
Rank is : 349204
*/

package HackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class HR12_BalancedBrackets {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
    // {(([])[])[]]}
    static String isBalanced(String s) {

        char [] brackets = s.toCharArray();
        Stack<Character> openingBracketStack = new Stack<>();

        if (brackets.length%2 != 0 || brackets.length <= 1 ||  isClosingBracket(brackets[0]) ||  !isClosingBracket(brackets[brackets.length - 1]))
        {
            return "NO";
        }

        for (int i = 0; i < brackets.length; i++) {
            if (!isClosingBracket(brackets[i]))
            {
                openingBracketStack.push(brackets[i]);
            }
            else if (isClosingBracket(brackets[i]))
            {
                if (openingBracketStack.isEmpty())
                {
                    return "NO";
                }
                else if (isMatch(openingBracketStack.peek(),brackets[i]) )
                {
                    openingBracketStack.pop();
                }
                else // means brackets are unmatched
                {
                    return "NO";
                }
            }
        }

        if (openingBracketStack.isEmpty())
        {
            return "YES";
        } else {
            return "NO";
        }
    }

    static boolean isClosingBracket(Character c) {

        if (c.equals(')') || c.equals('}')  || c.equals(']') )
        {
            return true;
        }

        return false;
    }

    static boolean isMatch(Character c1, Character c2) {
        if(c1.equals('(') && c2.equals(')'))
        { return true;}
        else if(c1.equals('{') && c2.equals('}'))
        { return true;}
        else if(c1.equals('[') && c2.equals(']'))
        { return true;}
        else
            return false;
    }

}
