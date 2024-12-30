package Java8.b_functionalInterface;

import java.util.function.Consumer;

/*
java.util.function.Consumer is a functional interface. Like Supplier, it has one abstract functional
method accept(T t) and a default method andThen(Consumer<? super T> after)

@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    default Consumer<T> andThen(Consumer<? super T> after)
    {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}

There are primitive specializations of the Consumer interface:

1-IntConsumer having one abstract method ' accept(int)' and one default method ' default IntConsumer andThen(IntConsumer after)'
2-DoubleConsumer having one abstract method ' accept(double)' and one default method ' default DoubleConsumer andThen(DoubleConsumer after)'
3-LongConsumer having one abstract method ' accept(long)' and one default method ' default LongConsumer andThen(LongConsumer after)'

Instances of functional interfaces can be created with lambda expressions, method references, or constructor references.
*/

/*Consumer Interface Example*/
public class FunctionalInterface2 {

	public static void main(String[] args)
	{

		 Consumer < String > consumer1 = (x) -> {
	                                                System.out.println(x + "Con1");
	                                            };

	     consumer1.accept("TestConsumerAccept - ");

	     Consumer < String > consumer2 = (y) -> {
	                                                System.out.println(y + "Con2");
	                                            };

	     consumer1.andThen(consumer2).andThen(consumer1).accept("TestConsumerAfterThen - ");

	}

}
