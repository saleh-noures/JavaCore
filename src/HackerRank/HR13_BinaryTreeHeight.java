package HackerRank;

import java.util.Scanner;
/* https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
* Test Data:
*  7
*  3 2 5 1 4 6 7
 */
public class HR13_BinaryTreeHeight {

    public static int height(Node root) {

        return traverse(root,0);
    }

    public static int traverse(Node root, int nodeHeight) {
        int maxHeight = 0;

        if(root.left != null){
            maxHeight = traverse(root.left, nodeHeight + 1);
        }

        if(root.right != null){
            maxHeight = traverse(root.right, nodeHeight + 1);
        }
        // when a node has no left or right nodes is means it is a leaf node
        if (nodeHeight > maxHeight)
            maxHeight = nodeHeight;

        return maxHeight;
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
        int height = height(root);
        System.out.println(height);
    }

}

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}