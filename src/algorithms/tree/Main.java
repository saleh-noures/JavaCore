package algorithms.tree;

// This ia a binary tree
/*
                            50
                          /    \
                        30      70
                       / \      / \
                     10   40   60  80
                    /\     /\
                   5 20  35  45
 */

public class Main {
    public static void main(String[] args) {

        // Inserting level 1
        Node node = new Node(50);

        // Inserting level 2
        node.insert(30);
        node.insert(70);

        // Inserting level 3
        node.insert(10);
        node.insert(40);
        node.insert(60);
        node.insert(80);

        // Inserting level 4
        node.insert(5);
        node.insert(20);
        node.insert(35);
        node.insert(45);


        System.out.println("Is 20 is in the tree: " + node.contains(20));
        System.out.println("Is 9 is in the tree: " + node.contains(9));

        System.out.println("Printing the tree InOrder");
        node.printInOrder();


    }
}
