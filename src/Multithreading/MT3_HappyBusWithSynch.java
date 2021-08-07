package Multithreading; /*
  * 1- Code Synchronization helps in preventing threads working on the same code at the same time. The synchronization works based on the locking concept.
  * 2- Threads that work on the synchronized code should acquire the lock of the object or class file respectively.
  * 3- Remember, there is only one lock per object or loaded class file.
  * 4- Synchronization can only be applied for method or block of code. But not for classes or variables.
  * 5- Very interesting! remove the synchronized form bookTickets method and see the result.
  * For more details see here : http://java9s.com/core-java/thread-safety-and-code-synchronization-in-java
 */

/**********************************HappyBus Class*******************************************/
public class MT3_HappyBusWithSynch {

	public static void main(String[] args)
	{
		BusReservation br = new BusReservation();
		PassengerThread pt1 = new PassengerThread(3,br,"SAM");
		PassengerThread pt2 = new PassengerThread(3, br, "Jack");

		pt1.start();
		pt2.start();
	}
}

/**********************************PassengerThread Class************************************/
class PassengerThread extends Thread{

	private int seatsNeeded;

	public PassengerThread(int seats, Runnable target, String name) {
		super(target,name);
		this.seatsNeeded = seats;
	}

	public int getSeatsNeeded() {
		return seatsNeeded;
	}
}

/**********************************BusReservation Class************************************/
class BusReservation implements Runnable{

	private int totalSeatsAvailable = 5;

	public void run() {

		PassengerThread pt = (PassengerThread) Thread.currentThread();

		boolean ticketsBooked = this.bookTickets(pt.getSeatsNeeded(), pt.getName());

		if(ticketsBooked){
			System.out.println("CONGRATS "+Thread.currentThread().getName() + " .. The number of seats requested(" + pt.getSeatsNeeded() + ")  are BOOKED");
		}else{
			System.out.println("Sorry "+Thread.currentThread().getName()+ " .. The number of seats requested(" + pt.getSeatsNeeded() + ")  are not available");
		}
	}

  public synchronized boolean bookTickets(int seatsNeeded,String name){

	  System.out.println("Welcome to HappyBus " + name + " Number of Tickets Available are:"+this.getTotalSeatsAvailable());

		if (seatsNeeded > this.getTotalSeatsAvailable()) {
			return false;
		} else {
			totalSeatsAvailable = totalSeatsAvailable - seatsNeeded;
			return true;
		}
	}

	private int getTotalSeatsAvailable() {
		return totalSeatsAvailable;
	}
}


