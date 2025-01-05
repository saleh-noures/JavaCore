package Multithreading;

/*
 *  Threads are independent paths of code execution that run concurrently in a Java program. Your application can use threads to multitask: perform time-intensive tasks and run them in the background.
 *  This allows the application to remain responsive to users.
 * 1- A thread is a light-weight smallest part of a process that can run concurrently with the other parts(other threads) of the same process.
 * 2- Threads are independent because they all have separate path of execution that is the reason if an exception occurs in one thread, it doesn't affect the execution of other threads.
 * 3- All threads of a process share the common memory.
 * 4- The process of executing multiple threads simultaneously is known as multithreading
 * 5- The main purpose of multithreading is to provide simultaneous execution of two or more parts of a program to maximum utilize the CPU time
 * 6- A thread can be in one of the following states: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED. See thread States image
 * 7- Thread scheduler in the JVM negotiates threads execution with the CPU and nothing can be guaranteed about which thread should be executed at a particular point of time.
 * 8- By default threads share same objects (Not Sure!! but probably this is true with Runnable objects and false when overriding the run method in Thread class )
 *    This Example From http://java9s.com/?s=Multithreading
 * 9- The difference between Callable and Runnable classes
 * 		Callable is introduced in JDK 5.0 but Runnable is introduced in JDK 1.0
 * 		Callable has call() method but Runnable has run() method.
 * 		Callable has call method which returns value but Runnable has run method which doesn't return any value.
 * 		call method can throw checked exception but run method can't throw checked exception.
 * 		Callable use submit() method to put in task queue but Runnable use execute() method to put in the task queue.
 * 10- Threads can execute same target (Runnable Object) or different targets (Runnable Objects)
 * 11- There are two ways to create threads execute run method:
 *     1- This method is used if you want to re-use the same runnable object across different threads
 *        you implement the runnable interface and pass an object of that class into a newly created thread object
 *        Thread Thread = new Thread(Runnable runnable);
 *        Thread.start();
 *     2- Thread class implements Runnable interface so easily implement the run:
 *        class MyThread extends Thread {
 *        ...
 *        @Override
 *         public void run() { ...}
 *         }
 *         ...
 *         MyThread myThread = new MyThread();
 *         myThread.start();
 * 11- Some Thread methods
 *     1- Thread Object methods:
 *        - threadObj.setName();
 *        - threadObj.setUncaughtExceptionHandler();  --> used to log additional data or clean up resources
 *        - threadObj.start();
 *        - threadObj.join();
 *        -threadObj.interrupt();
 *     2- Thread Static Methods
 *        - Thread.sleep();
 *        - Thread.yield();
 */
// **************This example execute two threads form the same class*************
public class MT1_RaceDemo
	{
		public static void main(String[] args)
		{
			Racer racer = new Racer();

		    Thread tortoiseThread = new Thread(racer, "Tortoise");
		    Thread hareThread = new Thread(racer, "Hare");

		    tortoiseThread.start();
		    hareThread.start();
		}
	}


class Racer implements Runnable {

	/*This instance variable is shared among all threads*/
    public String winner;

    public void run()
		{
			for(int distance=1;distance<=1000;distance++)
			{
				System.out.println("Distance Covered by " + Thread.currentThread().getName()+ " is: " + distance + "meters");
				
			  // Interesting, uncomment to so how one exception in one thread does not affect the other.
              /*if (Thread.currentThread().getName().equalsIgnoreCase("Hare") && distance == 700 )
				{
					throw new RuntimeException("Hare is Tired");
				}*/
			   
				//Check if race is complete in case someone has already won
				boolean isRaceWon = this.isRaceWon(distance);
				if(isRaceWon)
				{
					break;
				}
			}
		}

    private boolean isRaceWon(int totalDistanceCovered)
		{
			boolean isRaceWon = false;
			if((totalDistanceCovered == 1000) && (winner == null))
			{
				String winnerName = Thread.currentThread().getName();
				winner = winnerName;
				System.out.println("Winner is :" + winner);
				isRaceWon = true;
			}
		    else if(winner != null)
			{ // need this to stop the racer(the running thread) if one racer won
			    isRaceWon = true;
			}
			return isRaceWon;
		}
	}



