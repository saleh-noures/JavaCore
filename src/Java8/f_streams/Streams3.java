package Java8.f_streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Advanced Streams Topics
 * http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */
public class Streams3 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl", "axy");

        /****************Good Examples******************/
        strings.stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        strings.stream()
                .findFirst() // This returns optional
                .ifPresent(System.out::println);

        //Primitive streams can be transformed to object streams via mapToObj():
        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        //Here's a combined example: the stream of doubles is first mapped to an int stream and than mapped to an object stream of strings:
        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "b" + i)
                .forEach(System.out::println);

        int sum = Stream.of("2", "2", "3", "3", "5").mapToInt(e->{
            return Integer.parseInt(e);
        }).sum();
        System.out.println("The Sum is " + sum);

        System.out.println("****************Elements Processing Order******************");

        System.out.println("-----------------First-----------------");
        /*Each element moves along the chain vertically. The first string "d2" passes filter then forEach, only then the second string "a2" is processed.*/
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("-----------------Second-----------------");
        /*This behavior can reduce the actual number of operations performed on each element, as we see in the next example*/
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

        System.out.println("****************Why operation order matters******************");
        System.out.println("-----------------First-----------------");
        /*In the next example Both map and filter will be called five times*/
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("-----------------Second-----------------");
        /*We can greatly reduce the actual number of executions if we change the order of the operations, moving filter to the beginning of the chain:*/
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("****************Reusing Streams******************");
        System.out.println("-----------------First-----------------");
        /*Java 8 streams cannot be reused. As soon as you call any terminal operation the stream is closed*/
        Stream<String> stream =
                Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // ok
        //stream.noneMatch(s -> true);   // exception: stream has already been operated upon or closed
        System.out.println("-----------------Second-----------------");
        /*To overcome this limitation we have to create a new stream chain for every terminal operation we want to execute,
         * e.g. we could create a stream supplier to construct a new stream with all intermediate operations already set up:*/
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok


        System.out.println("****************Parallel Streams******************");
        /*Streams can be executed in parallel to increase runtime performance on large amount of input elements.
         *Parallel streams use a common ForkJoinPool available via the static ForkJoinPool.commonPool() method.
         * The size of the underlying thread-pool depends on the amount of available physical CPU cores:*/

        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println("The size of the underlying thread-pool: " + commonPool.getParallelism());

        System.out.println("-----------------First-----------------");
        System.out.println("-------------parallel Stream---------------------");
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));

        System.out.println("-----------------Second-----------------");
        System.out.println("-----------sequential Stream---------------------");
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .stream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));

        System.out.println("****************CPU Cores******************");
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number or CPU cores are " + cores);

    }
}
