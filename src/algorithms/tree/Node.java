package algorithms.tree;

/*
In a normal tree, every node can have any number of children.
1- Binary tree is a special type of tree data structure in which every node can have a maximum of 2 children.
   One is known as left child and the other is known as right child.

2- A binary tree is balanced if for each node it holds that the number of inner nodes in the left subtree
   and the number of inner nodes in the right subtree differ by at most 1. An Example of unbalanced binary tree is
   the linked list.

3- Binary search tree is a specific type if "binary tree" where the left node has a key (the value) less than the parent node
   while the right node has key (the value) node greater that the parent.

4- A Heap is a special case of balanced binary tree data structure that satisfies the heap property:
   if P is a parent node of C, then the key (the value) of P is either greater than or equal to (in a max heap)
   or less than or equal to (in a min heap) the key of C.

5- Red-black tree is a specific type of balanced search tree (https://www.youtube.com/watch?v=axa2g5oOzCE)
    - A node is either red or black
    - The root and leaves(NIL) are black
    - if a node is red, then its children are black
    - All paths from a node to its NIL descendants contains the same number of black nodes (black-depth).

 */

// This ia a binary search tree
public class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    // Binary search tree could end up with a tree like a linked list (unbalanced tree),
    //the solution for this is using red-black tree
    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
                System.out.println(value + " inserted left to " + data);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
                System.out.println(value + " inserted right to " + data);
            } else {
                right.insert(value);
            }
        }
    }

    //Binary Tree Search
    public boolean contains(int value) {

        if (data == value) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    //InOrder traversal of a binary tree
    public void printInOrder() {

        if (left != null) {
            left.printInOrder();
        }

        System.out.println(data);

        if (right != null) {
            right.printInOrder();
        }

    }
}
