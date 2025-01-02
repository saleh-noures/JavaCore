package Multithreading;

public class MT8_Java8 {
	
     static int	counter = 1;
     
	 public static void main(String[] args)
	 {
		 // Notice that we create two runnable objects using Lambda
		 // Also notice how Lambda can access methods of the enclosing scope
         // as it does not have its own scope
		 Runnable r1 = () -> {System.out.println("The Id of r1 is: "+ getId());};
		 Runnable r2 = () -> {System.out.println("The Id of r2 is: "+ getId());};
		 
		// Also notice that each thread is using different Runnable object 
		 Thread t1 = new Thread(r1, "FirstThread");
		 Thread t2 = new Thread(r2, "SecondThread");
		 
		 t1.start();
		 t2.start();
	 }
	 
	 // If you remove the synchronized you might end up getting the same ID for the two threads
	 public  static int getId()
	 {
		/* 
		   This includes:
		   (1)reading the counter value
		   (2)adding one to it
		   (3)storing the new value of counter
		   so it is likely that the first thread entered the block to be stopped by the CPU while it is in
		   the first step (reading the value) then second thread enters and reads the same value!
		 */ 
		 return counter++;
	 }

}
