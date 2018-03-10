package algorithms.hashTable;

/*
The core of the Hashtable (as a data structure) is an array of list where the index of that array is mapped to a hashcode
that is generated from the key. The list contains the values which have same index when converting form the key to
the hashcode "key->Hashcode->Index". This technique is called chaining to address the collision issue.
However, in chaining technique the key is stored along side the value in the list so elements can be distinguished
 */

import java.util.Hashtable;
import java.util.Map;

/*
Hashtable In Java
Java Hashtable class implements a hashtable, which maps keys to values. It inherits Dictionary class and implements the Map interface.
The important points about Java Hashtable class are:

-A Hashtable is an array of list. Each list is known as a bucket. The position of bucket is identified by calling the hashcode() method.
-A Hashtable contains values based on the key.
-It contains only unique elements.
-It may have not have any null key or value.
-It is synchronized.
*/
public class HashTable {
    public static void main(String[] args) {
        //Creating map of Books
        Map<Integer,Book> map=new Hashtable<Integer,Book>();
        //Creating Books
        Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book b3=new Book(103,"Operating System","Galvin","Wiley",6);
        //Adding Books to map
        map.put(1,b1);
        map.put(2,b2);
        map.put(3,b3);
        //Traversing map
        for(Map.Entry<Integer, Book> entry : map.entrySet()){
            int key=entry.getKey();
            Book b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
    }
}

class Book {
    int id;
    String name,author,publisher;
    int quantity;
    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}
