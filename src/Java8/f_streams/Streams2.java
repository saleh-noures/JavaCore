package Java8.f_streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Other Stream operations
 * 1-limit(intermediate): returns a stream instance with the given number of element (from the start) in limit as an argument
 * 2-skip(intermediate): returns a stream of remaining elements after skipping first n elements.
 * 3-sorted(intermediate): using Natural Ordering, Comparator and Reverse Ordering
 *     1. sorted(): It sorts the elements of stream using natural ordering. The element class must implement Comparable interface.
 *     2. sorted(Comparator<? super T> comparator): Here we create an instance of Comparator using lambda expression. We can sort the stream elements in ascending and descending order.
 */

public class Streams2 {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //You have to create two streams (one for the limit example and another of the skip example) otherwise will get "stream has already been operated upon or closed" error
        System.out.println("*************Limit()***************");
        Stream<Integer> intStream1 = integerList.stream();
        intStream1.limit(3).forEach(System.out::println);

        System.out.println("*************skip()***************");
        Stream<Integer> intStream2 = integerList.stream();
        intStream2.skip(3).forEach(System.out::println);

        System.out.println("*************Sorted() ***************");
        System.out.println("-------------Sorted List-------------");
        List<Student> studentList = Arrays.asList(new Student(2, "Omar", 8), new Student(1, "Saleh", 41), new Student(3, "Adam", 3));

        System.out.println("-----Example1: Sorting the elements of stream using natural ordering. The element class must implement Comparable interface-----");
        List<Student> sortedStudentList1 = studentList.stream().sorted().collect(Collectors.toList());
        sortedStudentList1.stream().forEach(s -> System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge()));

        System.out.println("-----Example2: Natural Sorting by Name in reverse order-----");
        List<Student> sortedStudentList2 = studentList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        sortedStudentList2.stream().forEach(s -> System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge()));

        System.out.println("-----Example3: Sorting using Comparator by Age-----");
        List<Student> sortedStudentList3 = studentList.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        sortedStudentList3.stream().forEach(s -> System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge()));

        System.out.println("-----Example4: Sorting using Comparator by Age with reverse order-----");
        List<Student> sortedStudentList4 = studentList.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        sortedStudentList4.stream().forEach(s -> System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge()));

        System.out.println("-------------Sorted SET-------------");
        /* Keep in mind that Set does not maintain the insertion order so if you ordered a Set and saved it in another set you will lose the order*/
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student(2, "Omar", 5));
        studentSet.add(new Student(1, "Saleh", 38));
        studentSet.add(new Student(3, "Adam", 1));

        System.out.println("---Natural Sorting by Name---");
        studentSet.stream().sorted().forEach(s -> System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge()));

        System.out.println("---Natural Sorting by Name in reverse order---");
        studentSet.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge()));

        System.out.println("---Sorting using Comparator by Age---");
        studentSet.stream().sorted(Comparator.comparing(Student::getAge)).forEach(s -> System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge()));

        System.out.println("---Sorting using Comparator by Age in reverse order---");
        studentSet.stream().sorted(Comparator.comparing(Student::getAge).reversed()).forEach(s -> System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge()));

        System.out.println("-------------Natural Sorting MAP-------------");
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, new Student(2, "Omar", 5));
        studentMap.put(2, new Student(1, "Saleh", 38));
        studentMap.put(3, new Student(3, "Adam", 1));

        //Map Sorting by Value i.e student's natural ordering i.e by name
        studentMap.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(entry -> System.out.println("Id: " + entry.getValue().getId() + ", Name: " + entry.getValue().getName() + ", Age: " + entry.getValue().getAge()));

    }
}

class Student implements Comparable<Student> {
    private int Id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        super();
        Id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }
}

class IdComparator implements Comparator<Student> {
    public int compare(Student o1, Student o2) {
        if (o1.getId() == o2.getId())
            return 0;
        else if (o1.getId() > o2.getId())
            return 1;
        else
            return -1;

    }
}
