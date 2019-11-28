package algorithms.binarySearchTree.myWay;

public class Main {

    public static void main(String[] args) {
    Node rootNode  =new Node(50);
    Node n1  =new Node(30);
    Node n2  =new Node(70);
    Node n3  =new Node(10);
    Node n4  =new Node(40);
    Node n5  =new Node(60);
    Node n6  =new Node(80);
    Node n7  =new Node(5);
    Node n8  =new Node(20);
    Node n9  =new Node(35);
    Node n10  =new Node(45);
    Node n11  =new Node(40);

    Node n12  =new Node(85);




        BinarySearchTree.insertNode(rootNode,n1);
        BinarySearchTree.insertNode(rootNode,n2);
        BinarySearchTree.insertNode(rootNode,n3);
        BinarySearchTree.insertNode(rootNode,n4);
        BinarySearchTree.insertNode(rootNode,n5);
        BinarySearchTree.insertNode(rootNode,n6);
        BinarySearchTree.insertNode(rootNode,n7);
        BinarySearchTree.insertNode(rootNode,n8);
        BinarySearchTree.insertNode(rootNode,n9);
        BinarySearchTree.insertNode(rootNode,n10);
        BinarySearchTree.insertNode(rootNode,n11);

        System.out.println(BinarySearchTree.isContain(rootNode, n4));
        System.out.println(BinarySearchTree.isContain(rootNode, n12));

        BinarySearchTree.printInOrder(rootNode);

    }
}
