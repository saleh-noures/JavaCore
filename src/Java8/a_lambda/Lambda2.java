package Java8.a_lambda;
//Lambda returns value

@FunctionalInterface
interface Executable2
{
	int execute();
}

class Runner2
{
	public void run (Executable2 executable)
	{
		System.out.println("Runner was called");
		int x = executable.execute();
		System.out.println(x);
	}
}

public class Lambda2
{
    public static void main(String args[])
    {
    	Runner2 runner2 = new Runner2();
    	runner2.run(()->{
    		System.out.println("Hi There");
    		return 8;
    	});

/* If the return value is just a single expression or a method call NO need for the return */
    	runner2.run(() -> 8);
    	runner2.run(() -> 8*2 );
    	// This also works if the method returns a String
    	//runner2.run(() -> "Toto");

    }

}
