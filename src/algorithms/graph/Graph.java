package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// both BFS and DFS
public class Graph {

    public Node rootNode;
    public ArrayList<Node> nodes = new ArrayList();
    public int[][] adjMatrix;//Edges will be represented as adjacency Matrix
    int size;

    public Node getRootNode() {
        return this.rootNode;
    }

    public void setRootNode(Node n) {
        this.rootNode = n;
    }

    public void addNode(Node n) {
        nodes.add(n);
    }

    //This method will be called to make connect two nodes
    public void connectNode(Node start, Node end) {
        if (adjMatrix == null) {
            size = nodes.size();
            adjMatrix = new int[size][size];
        }

        int startIndex = nodes.indexOf(start);
        int endIndex = nodes.indexOf(end);
        adjMatrix[startIndex][endIndex] = 1;
        adjMatrix[endIndex][startIndex] = 1;
    }

    private Node getUnvisitedChildNode(Node n) {
        int index = nodes.indexOf(n);
        int j = 0;
        while (j < size) {
            if (adjMatrix[index][j] == 1 && nodes.get(j).visited == false) {
                return nodes.get(j);
            }
            j++;
        }
        return null;
    }

    //DFS traversal of a tree is performed by the dfs() function
    public void dfs() {
        //DFS uses Stack data structure
        Stack<Node> s = new Stack();
        s.push(this.rootNode);
        rootNode.visited = true;
        printNode(rootNode);
        while (!s.isEmpty()) {
            Node n = s.peek();
            Node child = getUnvisitedChildNode(n);
            if (child != null) {
                child.visited = true;
                printNode(child);
                s.push(child);
            } else {
                s.pop();
            }
        }
        //Clear visited property of nodes
        clearNodes();
    }

    //BFS traversal of a tree is performed by the bfs() function
    public void bfs() {

        //BFS uses Queue data structure
        Queue<Node> q = new LinkedList();
        q.add(this.rootNode);
        printNode(this.rootNode);
        rootNode.visited = true;
        while (!q.isEmpty()) {
            Node n = q.remove();
            Node child = null;
            while ((child = getUnvisitedChildNode(n)) != null) {
                child.visited = true;
                printNode(child);
                q.add(child);
            }
        }
        //Clear visited property of nodes
        clearNodes();
    }


    //Utility methods for clearing visited property of node
    private void clearNodes() {
        int i = 0;
        while (i < size) {
            Node n = nodes.get(i);
            n.visited = false;
            i++;
        }
    }

    //Utility methods for printing the node's label
    private void printNode(Node n) {
        System.out.print(n.label + " ");
    }


}
