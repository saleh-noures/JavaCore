package Java8.e_optional;

import java.util.Optional;


/*
 * Optional is a container object used to contain not-null objects.
 * Optional object is used to represent null with absent value.
 * This class has various utility methods to facilitate code to handle values as �available� or �not available� instead of checking null values.
 * It is introduced in Java 8 and is similar to what Optional is in Guava.
 */

public class Optional1 {

	public static void main(String args[]) {

		  Optional1 optional1 = new Optional1();
	      Integer value1 = null;
	      Integer value2 = new Integer(10);

	      //Optional.ofNullable - allows passed parameter to be null.
	      Optional<Integer> o1 = Optional.ofNullable(value1);

	      //Optional.of - throws NullPointerException if passed parameter is null
	      Optional<Integer> o2 = Optional.of(value2);

          ////Optional.ifPresent - If a value is present, invoke the specified consumer with the value, otherwise do nothing.
	      o1.ifPresent((value)->System.out.println("Value from the Consumer of ifPresent: " + value));
	      o2.ifPresent((value)->System.out.println("Value from the Consumer of ifPresent: " + value));

	      System.out.println(optional1.sum(o1,o2));
	   }

	   public Integer sum(Optional<Integer> o1, Optional<Integer> o2) {

	      //Optional.isPresent - checks the value is present or not
	      System.out.println("First parameter is present: " + o1.isPresent());
	      System.out.println("Second parameter is present: " + o2.isPresent());

	      //Optional.get - If a value is present in this Optional, returns the value, otherwise throws NoSuchElementException.
	      Integer value2 = o2.get();

	      //Optional.orElse - returns the value if present otherwise returns the default value passed.
	      Integer value1 = o1.orElse(new Integer(0));

	      return new Integer(value1.intValue() + value2.intValue());

	   }
}
