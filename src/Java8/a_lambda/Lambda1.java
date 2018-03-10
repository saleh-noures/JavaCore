package Java8.a_lambda;

/*    Main Java 8 Features
 * 1- It's not only OOP but also functional style programming
 * 2- Lambda Expressions --> Passing a functionality or a block of code as an argument to another method (a method in a functional interface only!)
 * 3- Method references --> passing a reference of a method to another method
 * 4- Functional interface --> one abstract method in an interface using @FunctionalInterface
 * 5- Default Method (non-abstract!) in interface
 * 6- Optional Class --> handles Null pointer Exception
 * 7- Stream API --> helps processing large chunk of data in parallel without multithreading code (Performance benefits)
 * */

/*
 * Important Rules:
 *  1-You can not use Lambda Expressions or Method references without a functional interface
 *  2-The development process is, If the required Functional Interface exist use it, otherwise, create one, give it an implementation (LAMBDA *OR* METHOD REFERENCE) then use it!
 *  3-Instead of using AN ANONYMOUS CLASS you can use A LAMBDA EXPRESSION and if this just calls one method, you can use  METHOD REFERENCES or CONSTRUCTOR REFERENCES
 *  4-You can't mix Lambda with method references in the same expression 
 */

/*https://www.youtube.com/watch?v=q5i_O4Uj_O8*/

@FunctionalInterface
interface Executable
{
	void execute();
}

class Runner
{
	public void run(Executable executable)
	{
		System.out.println("Runner was called");
		executable.execute();
	}
}

public class Lambda1
{
    public static void main(String args[])
    {
        /*There are many ways to pass the actual functionality of execute method in Executable interface
         * 1- Creating a class that implements Executable then passing an object of that class to the run method
         * 2- Using Anonymous Inner Class
         * 3- Using Lambda expression - Java 8
         * 4- Using method references - Java 8
         */

        Runner runner = new Runner();

        System.out.println("===========Using Anynomous Inner Class=========");
        runner.run(new Executable() {
			public void execute() {
				System.out.println("Execute method is running by Java 6/7 syntax / Anonymous Inner Class");
			}
		});

        System.out.println("===========Using Lambda in Java 8=========");
        
        /* 1-One line of code, No need for the bracket! */
        runner.run(() -> System.out.println("Execute method is running by Java 6/7 syntax / Anonymous Inner Class"));

        /* 2-Multiple lines */
        runner.run(() -> {
        	              System.out.println("Execute method is running by Java 8 syntax / Lambda expression Line1");
                          System.out.println("Execute method is running by Java 8 syntax / Lambda expression Line2");
        	              });
        
    }
}
