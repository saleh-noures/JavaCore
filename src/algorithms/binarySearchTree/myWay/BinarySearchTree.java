package algorithms.binarySearchTree.myWay;

public class BinarySearchTree {

    public static void insertNode(Node currentNode, Node node)
    {
        if (node.key < currentNode.key)
        {
            if (currentNode.left == null)
            {
                currentNode.left = node;
               // System.out.println("Node with key "+ node.key + " inserted to the left of node with key "+ currentNode.key);
            } else
            {
                insertNode(currentNode.left, node);
            }
        } else if (node.key > currentNode.key)
        {
            if (currentNode.right == null)
            {
                currentNode.right = node;
                //System.out.println("Node with key "+ node.key + " inserted to the right of node with key "+ currentNode.key);
            } else
            {
                insertNode(currentNode.right, node);
            }
        }
    }

    public static boolean isContain (Node currentNode, Node node)
    {
        boolean result = false;
        if (node.key == currentNode.key)
        {
            return true;
        }
        else if (node.key < currentNode.key)
        {
            if (currentNode.left == null)
                {
                    return false;
                }
            else
                {
                    result = isContain(currentNode.left, node);
                }
        } else
        {
           if (node.key > currentNode.key)
           {
               if (currentNode.right == null)
               {
                   return false;
               }
               else
               {
                   result =  isContain(currentNode.right, node);
               }
           }
        }
        return result;
    }

    public static void printInOrder(Node currentNode)
    {
        if (currentNode.left != null)
            printInOrder(currentNode.left);

        System.out.println(currentNode.key);

        if (currentNode.right != null)
            printInOrder(currentNode.right);

    }
}
