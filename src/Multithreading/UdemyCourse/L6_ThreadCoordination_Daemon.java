package Multithreading.UdemyCourse;

import java.math.BigInteger;

/**
 * Thread Termination & Daemon Threads
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class L6_ThreadCoordination_Daemon {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2000"), new BigInteger("10000000")), "Daemon Thread");

         //Even though the long calculation in "LongComputationTask" has not finished,
        // just the fact that the main thread ended makes the entire app terminates
        thread.setDaemon(true);
        thread.start();

        //This will force the main thread to sleep for 5 seconds
        Thread.sleep(5000);

        System.out.println("\nMain thread is finished thus the entire app terminated");

    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }

            return result;
        }
    }
}
