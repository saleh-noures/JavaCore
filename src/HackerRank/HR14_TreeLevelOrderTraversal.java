package HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/tree-level-order-traversal
// My rank is 680,758

public class HR14_TreeLevelOrderTraversal {

    public static void levelOrder(Node root) {

        List<Node> currentLayer = new ArrayList<>();
        List<Node> nextLayer = new ArrayList<>();
        currentLayer.add(root);
        System.out.print(root.data + " ");
        while (!currentLayer.isEmpty())
        {
            for (Node node: currentLayer) {
                if (node.left != null)
                {
                    System.out.print(node.left.data + " ");
                    nextLayer.add(node.left);
                }

                if (node.right != null)
                {
                    System.out.print(node.right.data + " ");
                    nextLayer.add(node.right);
                }
            }
            currentLayer = nextLayer;
            nextLayer = new ArrayList<>();
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}
