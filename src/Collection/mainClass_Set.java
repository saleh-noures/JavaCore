package Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
public class mainClass_Set {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("\nHashSet:\n"
				+ " 1- HashSet does not allow duplicate but it replaces them\n"
				+ " 2- Does not maintain the insertion order & HashSet allows only one null");

		Set<Box<Integer,String>> boxHashSet =  new HashSet<>();
		System.out.println("Populating (1,Box1)(2,Box2)(3,Box3)(3,Box3) null null (5,Box5)(4,Box4)  .....");
		populateSet(boxHashSet);
		System.out.println("Printing boxHashSet .....");
		printSet(boxHashSet);


		System.out.println("\nLinkedHashSet:\n"
				+ " 1- LinkedHashSet does not allow duplicate but it replaces them\n"
				+ " 2- LinkedHashSet maintains the insertion order & LinkedHashSet allows only one null");

		Set<Box<Integer,String>> boxLinkedHashSet =  new LinkedHashSet<>();
		System.out.println("Populating (1,Box1)(2,Box2)(3,Box3)(3,Box3) null null (5,Box5)(4,Box4)  .....");
		populateSet(boxLinkedHashSet);
		System.out.println("Printing boxLinkedHashSet .....");
		printSet(boxLinkedHashSet);


		System.out.println("\nTreeSet:\n"
				+ " 1- It keep elements in a sorted order specified by Comparator.compare() or Comparable.compareTo() method\n"
				+ " 2- Box class needs to implement compareTo() -- have a look very interesting or create a Comparator class\n"
	            + " 3- Null values will throw null pointer exception as comparable will be invoked against a null object ");

		SortedSet<Box<Integer,String>> boxTreeSetUsingComparable =  new TreeSet<>();
		System.out.println("Populating (1,Box1)(2,Box2)(3,Box3)(3,Box3)(5,Box5)(4,Box4)  .....");
		populateSet(boxTreeSetUsingComparable);
		System.out.println("Printing boxTreeSetUsingComparable  (No NUll Values) .....");
		printSet(boxTreeSetUsingComparable);

		SortedSet<Box<Integer,String>> boxTreeSetUsingComparator = new TreeSet<>(new BoxComparator<>());
		System.out.println("\nPopulating (1,Box1)(2,Box2)(3,Box3)(3,Box3)(5,Box5)(4,Box4)  .....");
		populateSet(boxTreeSetUsingComparator);
		System.out.println("Printing boxTreeSetUsingComparator (No NUll Values) .....");
		printSet(boxTreeSetUsingComparator);


		System.out.println("\nCheck containsAll (uses equal & hashCode methods): "+boxLinkedHashSet.containsAll(boxHashSet));
		System.out.println("Check contains (uses equal & hashCode methods): "+boxHashSet.contains(new Box<>(1,"Box1")));
	}

	public static void populateSet(Set<Box<Integer,String>> boxSet)
	{
		boxSet.add(new Box<>(1,"Box1"));
		boxSet.add(new Box<>(2,"Box2"));
		Box<Integer, String > b3 = new Box<>(3,"Box3");
		boxSet.add(b3);
		boxSet.add(b3);
		boxSet.add(new Box<>(3,"Box3"));
		if (!(boxSet instanceof  SortedSet))
		{
			boxSet.add(null);
			boxSet.add(null);
		}
		boxSet.add(new Box<>(5,"Box5"));
		boxSet.add(new Box<>(4,"Box4"));
	}

	public static void printSet(Set<Box<Integer,String>> boxSet)
	{
		for (Box<Integer,String> b : boxSet)
		{
			System.out.println(b);
		}
	}

}
