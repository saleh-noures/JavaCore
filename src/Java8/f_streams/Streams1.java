package Java8.f_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * Stream is a new abstract layer introduced in Java 8. Using stream, you can process data in a declarative way similar to SQL statements.
 * Using collections framework in Java, a developer has to use loops and make repeated checks. Another concern is efficiency;
 * as multi-core processors are available at ease, a Java developer has to write parallel code processing that can be pretty error-prone.
 * To resolve such issues, Java 8 introduced the concept of stream that lets the developer to process data declaratively and leverage multicore
 * architecture without the need to write any specific code for it.

****What is Stream?****
*Stream represents a sequence of objects from a source, which supports aggregate operations. Following are the characteristics of a Stream:
*   -Sequence of elements: A stream provides a set of elements of specific type in a sequential manner. A stream gets/computes elements on demand. It never stores the elements.
*	-Source: Stream takes Collections, Arrays, or I/O resources as input source.
*	-Aggregate operations: Stream supports aggregate operations like filter, map, limit, skip, match, sorted, and so on
*	-Pipelining: Most of the stream operations return stream itself so that their result can be pipelined. These operations are called intermediate operations
*			     and their function is to take input, process them, and return output to the target. collect(),anyMatch()... methods are a terminal operation which is normally
*			     present at the end of the pipelining operation to mark the end of the stream.
*   -Automatic iterations: Stream operations do the iterations internally over the source elements provided, in contrast to Collections where explicit iteration is required.

****Generating Streams****
*With Java 8, Collection interface has two methods to generate a Stream
*     -stream(): Returns a sequential stream considering collection as its source.
*     -parallelStream(): Returns a parallel Stream considering collection as its source. Parallel streams are capable of operating on multiple threads.

* 1-forEach: Iterate each element of the stream and execute the "accept" method of the "Consumer" interface
* 2-map: lets you convert an object to something else or used to map each element to its corresponding result by executing the "apply" method of the "Function" interface
* 3-filter: used to eliminate elements based on a criteria by excuting the "test" method of the "Predicate" interface
* 4-collect: Collect is an extremely useful terminal operation to transform the elements of the stream into a different kind of result, e.g. a List, Set or Map.
*            Collect accepts a Collector which consists of four different operations: a supplier, an accumulator, a combiner and a finisher.
*            More Details, read here http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
*
*https://www.tutorialspoint.com/java8/java8_streams.htm
*
*/

public class Streams1 {

	public static void main(String[] args) {
		
		List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl", "axy");

		List<Integer> integerList = Arrays.asList(7,2,5,6,3);

		/****************stream().filter(Predicate predicate)******************/

		Long count = stringList.stream().filter(string -> string.isEmpty()).count();
		System.out.println("The number of empty elements is: "+ count.longValue());

		List<String> nonEmptyStringList = stringList.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Non Empty String List: " + nonEmptyStringList);

		String mergedString = stringList.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);

		/****************stream().map(Function mapper)******************/

		List<String> mapToUpper = stringList.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("mapToUpper: "+ mapToUpper);

		List<Integer> mapSquareIntegers = integerList.stream().map((x)->x*x).collect(Collectors.toList());
		System.out.println(mapSquareIntegers);

		List<Person> peopleList = Arrays.asList(new Person("Saleh", 38, "Seven Hills"), new Person("Omar", 5, "Bondi"), new Person("Adam", 1, "New Town"));

		//List of objects -> List of String
		List<String> peopleNamesList = peopleList.parallelStream().map(Person::getName).collect(Collectors.toList());
		System.out.println(peopleNamesList);

		//List of objects -> List of other objects
		//https://www.mkyong.com/java8/java-8-streams-map-examples/

		List<Employee> empsList =  peopleList.parallelStream().map(p -> {
		    Employee e = new Employee();
		    e.setName(p.getName());
		    e.setAddress(p.getAddress());
			return e;
		}).collect(Collectors.toList());

		/****************stream().forEach(Consumer consumer)******************/
		empsList.stream().forEach(e -> System.out.println("Name: " + e.getName()+" Address: "+ e.getAddress()));
	}
}

class Person
{
	private String name;
	private int age;
	private String address;

    public Person(String name, int age, String address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getAddress()
    {
        return address;
    }
}

class Employee
{
	private String name;
	private String address;
	private int salary;

	public Employee()
    {

    }

	public Employee(String name, String address, int salary)
    {
        this.name = name;
        this.address = address;
        this.salary= salary;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getSalary()
    {
		return salary;
	}
}
