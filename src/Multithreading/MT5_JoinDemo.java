package Multithreading;
/*
 * 1- Join is used in the situations when a task which should be completed before the current task is going to finish.
 * 2- Join method belongs to Thread object and not a static member. When join is invoked on a thread instance, this thread
 *    will tell currently executing thread to wait till the Joining thread completes.
 * 3- Just to give another example of how Join works, say we have a slow train on the track moving and another
 *    fast train should take the same track, so, we make way to the fast train and tell the slow train to join once after the fast one is left.
*/

import java.lang.Thread.State;

public class MT5_JoinDemo {

	 public static Thread firstThread;
	 public static Thread secondThread;

	 public static void main(String[] args)
	 {
		 JoinRunnable jr = new JoinRunnable();
		 firstThread = new Thread(jr,"First Thread");
		 secondThread = new Thread(jr, "Second Thread");
		 firstThread.start();

		 State firstThreadStatus;
		 State secondThreadStatus;
		 do
		 {
		     firstThreadStatus = firstThread.getState();
		     secondThreadStatus = secondThread.getState();
			 System.out.println(System.nanoTime()+" First Thread status:"+firstThreadStatus);
			 System.out.println(System.nanoTime()+" Second Thread Status :"+secondThreadStatus);
		 } while(!firstThreadStatus.equals(State.TERMINATED) && !secondThreadStatus.equals(State.TERMINATED));
	 }

}

class JoinRunnable implements Runnable {

@Override
 public void run()
{
	 System.out.println(System.nanoTime()+" Current Thread:" + Thread.currentThread().getName() + " is at the beginning");

	 if(Thread.currentThread().getName().equals("First Thread"))
	 {
		 try
		 {
			 System.out.println(System.nanoTime()+" Inside the join condition");
			 MT5_JoinDemo.secondThread.start();
			 MT5_JoinDemo.secondThread.join();
		 }
		 catch (InterruptedException e)
		 {
			 e.printStackTrace();
		 }
	 }
	 System.out.println(System.nanoTime() + " Current Thread:"+Thread.currentThread().getName() + " is at the end");
 }

}