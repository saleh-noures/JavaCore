package Java8.a_lambda;
// Passing parameters

interface Executable3
{
	int execute(int a);
}

class Runner3
{
	public void run (Executable3 executable)
	{
		System.out.println("Runner was called");
		int x = executable.execute(12);
		System.out.println(x);
	}
}

public class Lambda3 {
	public static void main(String[] args) {

    	Runner3 runner3 = new Runner3();


     /*1-The below Lambda can be declared as (a) as Java 8 can infer the type
      *  or just "a" without bracket if you have one parameter only.
      *2-To pass more than one parameter you can do this (a,b)
      *3-It is important to note that in some cases you need to explicitly
      *  mention the type to avoid method call ambiguity.
      *4-Lambda does not have its own scope but it uses the same scope of the method
      *  where it's declared. Other words if you declare a variable in lambda expression
      *  with the same name as another variable in the method where a the lambda is declared
      *  that would be a syntax error. try!
      *5-you can use a variable form outside lambda only if it's final or effectively final,
      *  meaning you can declare the variable without using a final keyword
      *  but you can't change it later */

    	int x = 10;
    	// The below line will cause a compilation error if enabled.
    	//x = 20;


    	runner3.run((int a)->{
    		System.out.println("Hi There");
    		return 7 + a + x;
    	});

    	/* Another way of doing things, is dealing with lambda as an object */

    	Executable3 ex3 = a->{
    		System.out.println("Hi There from here");
    		return 8 + a + x;
    	};

    	runner3.run(ex3);

    	/* Also you can assign the object to super class but you need to use casting*/
    	Object exObject = (Executable3)(int a)->{
    		System.out.println("Hi There from exObject");
    		return 8 + a + x;
    	};


	}
}
