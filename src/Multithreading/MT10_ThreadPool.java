package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MT10_ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        int numTasks = 1000; // Total number of tasks
        int numThreads = 10; // Number of threads in the pool

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        long startTime = System.nanoTime();

        for (int i = 0; i < numTasks; i++) {
            executor.submit(() -> {
                // Simulate a task
                try {
                    Thread.sleep(10); // Each task takes 10 ms
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long endTime = System.nanoTime();

        long totalTime = endTime - startTime; // Total time in nanoseconds
        System.out.println("Total Time (Latency for all tasks): " + (totalTime / 1_000_000) + " ms");
        System.out.println("Throughput: " + (numTasks * 1_000_000_000L / totalTime) + " tasks/sec");
    }
}
