package Java8.c_methodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/*
 *ClassName::new  equivalent to  (args) -> new ClassName(args)
 *Like in the other cases, arguments (if any) are not passed in the method reference.
 */

/*Constructor method references*/
public class MethodReferences4 {

	public static void main(String[] args)
	{
		/*
		 * Most of the time, we can use this syntax with two (or three) interfaces of the java.util.function package.
		 * Think of an example when you want ONE functional interface that create objects from different types.
		 */

		/**********************************************************************************************
		 * 1-If the constructor takes no arguments, a Supplier will do the job:
		 **********************************************************************************************/
		System.out.println("===========Using Anonymous Inner Class=========");
		Supplier<List<String>> supplier1 = new Supplier<List<String>>() {
		  public List<String> get() {
		    return new ArrayList<String>();
		  }
		};
		List<String> list1 = supplier1.get();
		System.out.println("===========Using a lambda expression=========");
		Supplier<List<String>> supplier2 = () -> new ArrayList<>();
		List<String> list2 = supplier2.get();
		System.out.println("===========Using Method References================");
		Supplier<List<String>> supplier3 = ArrayList::new;
		List<String> list3 = supplier3.get();
		/* Remember! You can not use Lambda Expressions or Method references without functional interface. So, That's why "ArrayList::new" needs Supplier interface */

		 /**********************************************************************************************
		 * 2-If the constructor takes an argument, we can use the Function interface:
		 * Functional interface "Function" Represents a function that accepts one argument and produces a result.
		 ************************************************************************************************/
		System.out.println("===========Using Anynomous Inner Class=========");
		Function<String, Integer> f1 = new Function<String, Integer>() {
		    public Integer apply(String s) {
		      return new Integer(s);
		    }
		};
		Integer i1 = f1.apply("100");
		System.out.println("===========Using a lambda expression=========");
		Function<String, Integer> f2 = s -> new Integer(s);
		Integer i2 = f2.apply("100");
		System.out.println("===========Using Method References================");
		Function<String, Integer> f3 = Integer::new;
		Integer i3 = f3.apply("100");


		/**********************************************************************************************
		 * 3-If the constructor takes two arguments, we use the BiFunction interface:
		 **********************************************************************************************/
		System.out.println("===========Using Anonymous Inner Class=========");
		BiFunction<String ,Double, Employee> empFactory1 = new BiFunction<String ,Double, Employee>(){
			public Employee apply(String t, Double u) {
				return new Employee(t,u);
			}
		};
		Employee e1 = empFactory1.apply("Saleh", 60000d);

		System.out.println("===========Using a lambda expression=========");
        BiFunction<String, Double, Employee> empFactory2 = (n,s)-> new Employee(n,s);
        Employee e2 = empFactory2.apply("Omar", 100000d);

		System.out.println("===========Using Method References================");
		BiFunction <String, Double, Employee> empFactory3 = Employee::new;
		Employee e3 = empFactory3.apply("Adam", 100000d);

		/**********************************************************************************************
		 * 4- If you have a constructor with three or more arguments,  you would have to create your own functional interface.
		 **********************************************************************************************/
	}
}

class Employee
{
	String name;
	Double salary;

	public Employee(String name, Double salary )
	{
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
