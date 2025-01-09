package others;


/*

1-lockObject: The object on which the lock is applied. It can be any non-null object.
2-Only one thread can execute the code within the synchronized block for a particular lockObject at any given time.

synchronized (lockObject) {
      Code to be synchronized
        }

        */

public class SynchronizedBlockExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Create two threads
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Print the final count
        System.out.println("Final Count: " + counter.getCount());
    }
}
class Counter {
    private int count = 0;

    // Increment method with synchronized block
    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
