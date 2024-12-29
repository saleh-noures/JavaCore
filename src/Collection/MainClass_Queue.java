package Collection;

import java.util.PriorityQueue;
import java.util.Queue;

/*
The java.util.Queue interface is a subtype of the java.util.Collection interface.
It represents an ordered list of objects just like a List, but its intended use is slightly different.
A queue is designed to have elements inserted at the end of the queue, and elements removed from the beginning of the queue.
Just like a queue in a supermarket.
*/

public class MainClass_Queue {

	public static void main(String[] args) {

		Queue<Box<Integer,String>> boxQueue = new PriorityQueue<Box<Integer,String>>();
		System.out.println("Populating (1,Box1)(2,Box2)(3,Box3)(3,Box3) (3,Box3) (5,Box5)(4,Box4)  .....");
		populateQueue(boxQueue);

		System.out.println("Printing boxQueue .....");
		printQueue(boxQueue);

		boxQueue.remove();
		boxQueue.remove();
		boxQueue.add(new Box<>(6,"Box6"));

		System.out.println("Printing boxQueue after removing two Elements .....");
		printQueue(boxQueue);

		//"peek" Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
		System.out.println("Peek: " + boxQueue.peek());

	}
	
	public static void populateQueue(Queue<Box<Integer,String>> boxQueue)
	{
		boxQueue.add(new Box<>(1,"Box1"));
		boxQueue.add(new Box<>(2,"Box2"));
		Box<Integer, String > b3 = new Box<>(3,"Box3");
		boxQueue.add(b3);
		boxQueue.add(b3);
		boxQueue.add(new Box<>(3,"Box3"));
		//can't add null to a queue 
/*		boxQueue.add(null);
		boxQueue.add(null);*/
		boxQueue.add(new Box<>(5,"Box5"));
		boxQueue.add(new Box<>(4,"Box4"));
	}

	public static void printQueue(Queue<Box<Integer,String>> boxQueue)
	{
		for (Box<Integer,String> b : boxQueue)
		{
			System.out.println(b);
		}
	}

}
