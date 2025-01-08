package Multithreading.UdemyCourse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Joining Threads
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class L7_ThreadCoordination_Join {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(3435L, 35435L, 100000L, 2324L, 4656L, 23L, 5556L);

        List<FactorialThread> threads = new ArrayList<>();

        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        for (Thread thread : threads) {
            //thread.setDaemon(true);
            thread.start();
        }

        //This block will force the main block to wait until all threads finish their work
        //Without this block the "Race Condition" will occur, where all threads race to their goals independently
        //Comment out and see the result
        for (Thread thread : threads) {
            //thread.join(2000) means: Waits at most 2000 millis milliseconds for this thread to terminate.
            //and if not finished within the 2000 millis then return. A timeout of 0 means to wait forever.
            //Note that the main thread will not terminate until 100000L thread (take long to finish) terminates
            //or make threads Daemon if you want the main thread to terminate without waiting the other threads
            thread.join(2000);
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is "
                        + String.valueOf(factorialThread.getResult()).substring(0,5) + "...");
            } else {
                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
            }
        }
    }

    public static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;

            for (long i = n; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
            }
            return tempResult;
        }

        public BigInteger getResult() {
            return result;
        }

        public boolean isFinished() {
            return isFinished;
        }
    }
}
