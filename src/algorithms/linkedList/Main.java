package algorithms.linkedList;

/*
Each element (we will call it a node) of a list is comprising of two items - the data and a reference to the next node.
The last node has a reference to null. The entry point into a linked list is called the head of the list. It should be
noted that head is not a separate node, but the reference to the first node. If the list is empty then the head is a
null reference.
A linked list is a dynamic data structure. The number of nodes in a list is not fixed and can grow and shrink on demand.
Any application which has to deal with an unknown number of objects will need to use a linked list.

One disadvantage of a linked list against an array is that it does not allow direct access to the individual elements.
If you want to access a particular item then you have to start at the head and follow the references until you get to
that item.

Another disadvantage is that a linked list uses more memory compare with an array - we extra 4 bytes (on 32-bit CPU) to
store a reference to the next node.

Types of Linked Lists
A singly linked list is described above
A doubly linked list is a list that has two references, one to the next node and another to previous node.
        */
public class Main {
    public static void main(String[] args) {


        LinkedList ls = new LinkedList();

        ls.append(1);
        ls.append(2);
        ls.append(3);
        ls.append(4);
        ls.append(5);

        printStackTrace(ls);

        System.out.println("After prepending 0 and -1");
        ls.prepend(0);
        ls.prepend(-1);
        printStackTrace(ls);

        System.out.println("After deleting 3");
        ls.delete(3);
        printStackTrace(ls);

        System.out.println("After deleting head");
        ls.delete(-1);
        printStackTrace(ls);


    }

    private static void printStackTrace(LinkedList ls) {
        Node currentNode = ls.head;
        do{
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
        while(currentNode != null);
    }
}
