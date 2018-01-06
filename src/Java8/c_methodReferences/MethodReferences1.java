package Java8.c_methodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;


/*
 * A method reference is the shorthand syntax for a lambda expression that executes just ONE method
 * It is a feature which is related to Lambda Expression. It allows us to reference constructors or
 * methods without executing them. Method references and Lambda are similar in that they both require
 * a target type that consist of a compatible functional interface.
 *
 * Types of Method References
 * There are four types of method reference, the table below summarizes them.
 * 1. Reference to a static method ---> Class::staticMethodName (ContainingClass::staticMethodName)
 * 2. Reference to an instance method of a particular object                      ---> object::instanceMethodName (containingObject::instanceMethodName)
 * 3. Reference to an instance method of an arbitrary object of a particular type ---> Class::instanceMethodName (ContainingType::methodName)
 * 4. Reference to a constructor   ---> ClassName::new
 *
 * In general, we don't have to pass arguments to method references. However, arguments are treated depending on the type of method reference.
 * In this Example, any arguments (if any) taken by the method are passed automatically behind the curtains.
 *
 * In Java 8, Predicate is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.
 * You can use them anywhere where you need to evaluate a condition on group/collection of similar objects such that evaluation can result
 * either in true or false.
 * */

/*Reference to a Static Method*/
/*This example will iterate over an integer list and return
a new list contains the numbers that if 10 is added to will be more than 50 */

/*
 * https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
*/
public class MethodReferences1 {

	public static void main (String [] args)
	{
		List<Integer> list = Arrays.asList(42,12,5,45,18, 41); // This is Auto-boxing  int to Integer

		System.out.println("===========Using Anynomous Inner Class=========");
		// Using an anonymous class
		List<Integer> list1 = Numbers.findNumbers(list, new BiPredicate<Integer, Integer>() {
		  public boolean test(Integer i1, Integer i2) {
		    return Numbers.isMoreThanFifty(i1, i2);
		  }
		});
		System.out.println(list1);
		System.out.println("===========Using Lambda=========");
		// Using a lambda expression
		List<Integer> list2 = Numbers.findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));
		System.out.println(list2);
		System.out.println("===========Using Methiod References================");
		// Using a method reference
		List<Integer> list3 = Numbers.findNumbers(list, Numbers::isMoreThanFifty);
		System.out.println(list3);

	}
}

class Numbers
{
	public static boolean isMoreThanFifty(int n1, int n2)
	{
		return (n1 + n2) > 50;
	}

	public static List<Integer> findNumbers(List<Integer> numList, BiPredicate<Integer, Integer> p)
	{
		      List<Integer> newList = new ArrayList<>();
		      for(Integer i : numList)
		      {
		        if(p.test(i, i + 10))
		        {
		          newList.add(i);
		        }
		      }
		      return newList;
	}
}
