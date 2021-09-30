package Collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;


public class mainClass_List {

	public static void main(String[] args) {

		System.out.println("\nArrayList, LinkedLIst & Vector:\n"
				+ " 1- Allow duplicates\n"
				+ " 2- Maintain insertion order\n"
				+ " 3- Allow many nulls\n"
				+ " 4- LinkedList is more suitable for frequently adding and removing elements from List.\n"
				+ " 5- Vector is synchronized counterpart of ArrayList.\n");

		/*************************Swap the implementation between ArrayList, linkedList and Vector and see the result   *********************************************/
		List<Box<Integer,String>> boxList =  new ArrayList<>();
		System.out.println("Populating (2,Box2)(1,Box1)(3,Box3)(3,Box3) null null (5,Box5)(4,Box4)  .....");
		populateList(boxList);
		System.out.println("Printing boxHashSet .....");
		printList(boxList);
		
		/*************************Reversing the Order Using Collection class Reverse Static Method*********************************************/
		System.out.println("\nReversing the Order Using Collection class Reverse Static Method");
		Collections.reverse(boxList);
		printList(boxList);
		/*************************Sorting the list after removing nulls Using Collection class sort Static Method*********************************************/
		System.out.println("\nSorting the list after removing nulls Using Collection class sort Static Method");
		// First you need to remove null objects form the list in order not to throw null pointer exception 
		// list.removeIf(Objects::isNull); --Java8
		boxList.removeAll(Collections.singleton(null)); 
		//Sort naturally through comparable interface
		Collections.sort(boxList);
		//Or using Comparator
		//Collections.sort(boxList, new BoxComparator<>());
		printList(boxList);

		listPlay();
		
	}

	public static void populateList(List<Box<Integer,String>> boxList)
	{
		boxList.add(new Box<>(2,"Box2"));
		boxList.add(new Box<>(1,"Box1"));
		Box<Integer, String > b3 = new Box<>(3,"Box3");
		boxList.add(b3);
		boxList.add(b3);
		boxList.add(new Box<>(3,"Box3"));
		boxList.add(null);
		boxList.add(null);
		boxList.add(new Box<>(5,"Box5"));
		boxList.add(new Box<>(4,"Box4"));
		boxList.add(2, new Box<>(7,"Box4"));
	}

	public static void printList(List<Box<Integer,String>> boxList)
	{
		for (Box<Integer,String> b : boxList)
		{
			System.out.println(b);
		}
	}

	public static void listPlay(){

		int num1 = 9;
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(7);
		list.add(11);
		list.add(18);

		list.add(0,1);
		list.add(list.size(),25);

		for (int i = 0; i < list.size() ; i++) {
			if (num1 >= list.get(i) && num1< list.get(i+1) )
			{
				list.add( i+1 ,num1);
				break;
			}
		}

		int num2 = list.remove(list.size() - 2);

		System.out.println("Printing form Play List:");
		list.stream().forEach(item -> System.out.print(item + " "));
	}

}
