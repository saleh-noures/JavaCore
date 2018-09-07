package Java8.b_functionalInterface;
import java.util.function.Supplier;

/*
Any interface with a SAM (Single Abstract Method) is a functional interface, and its implementation
may be treated as lambda expressions or method references, it also could contains default methods.

All functional interfaces are recommended to have an informative @FunctionalInterface annotation.
This not only clearly communicates the purpose of this interface, but also allows a compiler to
generate an error if the annotated interface does not satisfy the conditions.

Examples of functional interfaces : java.lang.Runnable, java.util.concurrent.Callable, java.util.Comparator.

Java 8's functional interfaces are Supplier, Consumer, Function, and Predicate Interfaces

java.util.function.Supplier is a functional interface. As per the definition of functional interfaces,
it has one abstract functional method T get().

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

There are primitive specializations of the Supplier interface:
1- IntSupplier having one abstract method getAsInt()
2- LongSupplier having one abstract method getAsLong()
3- DoubleSupplier having one abstract method getAsDouble()
4- BooleanSupplier having one abstract method getAsBoolean()

Instances of functional interfaces can be created with lambda expressions, method references, or constructor references.
As a general rule you have to use the existing functional interfaces, otherwise create your own.

*/

/*Supplier Interface Example*/
public class FunctionalInterface1 {

	 public static void main(String[] args) {
	        Supplier<Person> personSupplier = () -> {
	        	                                   return new Person("Saleh", 30, "Programmer");
	                                          };
	        // Or like this:
            //Supplier<Person> personSupplier = () -> new Person("Saleh", 30, "Programmer");

	        Person p = personSupplier.get();
	        System.out.println("Person Detail:\n" + p.getName() + ", " + p.getAge() + ", " + p.getPosition());
	    }
}

/*Person.java is a bean class, which we will use to supply the data using Supplier in the FunctionalInterface1 class above.*/
class Person
{
	private String name;
	private int age;
	private String address;

    public Person(String name, int age, String position)
    {
        this.name = name;
        this.age = age;
        this.address = position;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getPosition()
    {
        return address;
    }
}