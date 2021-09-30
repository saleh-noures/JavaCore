/*
https://www.hackerrank.com/challenges/balanced-brackets/problem
Rank is : 349204
*/

package HackerRank;

import java.util.Scanner;
import java.util.Stack;


public class HR12_BalancedBrackets {
    public static void main(String[] args) {

        int n = 0;
        String brackets;

        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        for (int i = 0; i < n; i++) {
            brackets = in.next();
            System.out.println(isBalanced(brackets));
        }
    }

    public static String isBalanced(String s) {
        Stack<String> openBrackStack = new Stack<>();
        String bracket;

        for (int i = 0; i < s.length(); i++) {
            bracket = String.valueOf(s.charAt(i));
            if (isOpenning(bracket)){
                openBrackStack.push(bracket);
            }
            else{
                if (openBrackStack.isEmpty())
                    return "NO";
                if(!getOpenning(bracket).equals(openBrackStack.pop())) // openBrackStack.peek() to check the top of the stack
                    return "NO";
            }
        }
        if (!openBrackStack.isEmpty())
            return "NO";

        return "YES";
    }

    public static boolean isOpenning(String s) {
        if (s.equals("[") || s.equals("{") || s.equals("("))
            return true;
        else
            return false;
    }

    public static String getOpenning(String s) {

        if (s.equals(")"))
            return "(";
        else if (s.equals("}"))
            return "{";
        else
            return "[";

    }
}
