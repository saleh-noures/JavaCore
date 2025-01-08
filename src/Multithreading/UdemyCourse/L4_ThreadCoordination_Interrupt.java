package Multithreading.UdemyCourse;

/**
 * Thread Termination & Daemon Threads
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class L4_ThreadCoordination_Interrupt {
    public static void main(String [] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();

        thread.interrupt();
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            //do things

            //The sleep method is declared to throw the un-checked InterruptedException
            //This exception is going to be thrown when the current thread is interrupted externally by another thread .
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Existing blocking thread");
            }
        }
    }
}
