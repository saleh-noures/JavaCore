package algorithms.linkedList;

public class LinkedList {
    Node head;

    // Unlike Arrays to add a new element you have to navigate to the end.
    public void append(int data) {

        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void delete(int data) {
        if (head == null) return;

        if (head.data == data)
        {
            head = head.next;
            return;
        }

        Node currentNode = head;
        while(currentNode.next != null)
        {
            if(currentNode.next.data == data)
            {
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }

    }

}
