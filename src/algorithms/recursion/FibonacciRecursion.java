package algorithms.recursion;

/*

The Fibonacci sequence is a set of numbers that starts with a one or a zero, followed by a one, and proceeds based on the rule that each number (called a Fibonacci number)
 is equal to the sum of the preceding two numbers Fn = Fn-1 + Fn-2.
1,1,2,3,5,8,13,21,34,55,89,144

* */
public class FibonacciRecursion {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    private static int fib(int n) {
        if (n<=0) {return 0;}
        else if (n ==1) {return 1;}
        else { return fib(n-1) + fib(n-2);}
    }

}
