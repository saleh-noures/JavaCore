package Multithreading;

/*
 *  Threads are independent paths of code execution that run concurrently in a Java program. Your application can use threads to multitask: perform time-intensive tasks and run them in the background.
 *  This allows the application to remain responsive to users.
 * 1- A thread is a light-weight smallest part of a process that can run concurrently with the other parts(other threads) of the same process.
 * 2- Threads are independent because they all have separate path of execution that is the reason if an exception occurs in one thread, it doesn�t affect the execution of other threads.
 * 3- All threads of a process share the common memory.
 * 4- The process of executing multiple threads simultaneously is known as multithreading
 * 5- The main purpose of multithreading is to provide simultaneous execution of two or more parts of a program to maximum utilize the CPU time
 * 6- A thread can be in one of the following states: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED. See thread States image
 * 7- Thread scheduler in the JVM negotiates threads execution with the CPU and nothing can be guarantee about which thread should be executed at a particular point of time.
 * 8- By default threads share same objects (Not Sure!! but probably this is true with Runnable objects and false when overriding the run method in Thread class )
 *    This Example From http://java9s.com/?s=Multithreading
 * 9- The difference between Callable and Runnable classes
 * 		Callable is introduced in JDK 5.0 but Runnable is introduced in JDK 1.0
 * 		Callable has call() method but Runnable has run() method.
 * 		Callable has call method which returns value but Runnable has run method which doesn't return any value.
 * 		call method can throw checked exception but run method can't throw checked exception.
 * 		Callable use submit() method to put in task queue but Runnable use execute() method to put in the task queue.
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
			   
				//Check if race is complete if some one has already won
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
			if((totalDistanceCovered == 1000) && (winner == null ))
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



