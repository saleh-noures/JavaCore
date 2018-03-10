package Java8.b_functionalInterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/*https://www.youtube.com/results?search_query=java+8+method+reference*/

/*Java8 Functional Interfaces in action - Person class is package-private scope*/
/*
 * 1-forEach accepts Consumer object then iterate and
 * execute accept method against each element in the list
 *
 * 2-Collections.sort is a static method that accepts twp
 * parameters List and Comparator objects
 */
public class FunctionalInterface3 {
    public static void main(String[] args) {
        List<Person> peopleList = Arrays.asList(new Person("Saleh", 30, "Programmer"), new Person("Omar", 5, "CEO"), new Person("Adam", 1, "CEO"));

        System.out.println("===========Using Implementation class=========");
        ConsumerImpl cons0 = new ConsumerImpl();
        peopleList.forEach(cons0);

        System.out.println("===========Using Anynomous Inner Class=========");
        Consumer<Person> cons1 = new Consumer<Person>() {
            @Override
            public void accept(Person p) {
                System.out.println(p.getName());
            }
        };
        peopleList.forEach(cons1);

        System.out.println("===========Using Consumer interface and Lambda=========");
        Consumer<Person> cons2 = (p) -> {
            System.out.println(p.getName());
        };
        peopleList.forEach(cons2);

        System.out.println("===========Or Using Lambda Only================");
        peopleList.forEach(p -> System.out.println(p.getName()));

        System.out.println("===========Now using Comparator functional interface to order people by age================");
        Collections.sort(peopleList, (Person p1, Person p2) -> {

            if (p1.getAge() > p2.getAge())
                return 1;
            if (p1.getAge() < p2.getAge())
                return -1;
            else return 0;

        });

        peopleList.forEach((p) -> System.out.println(p.getName()));
    }
}

class ConsumerImpl implements Consumer<Person> {
    @Override
    public void accept(Person p) {
        System.out.println(p.getName());
    }
}
