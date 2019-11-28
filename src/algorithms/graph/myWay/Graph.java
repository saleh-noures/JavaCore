package algorithms.graph.myWay;

import java.util.*;

public class Graph {

    List<Node> nodeList = new ArrayList<>();
    int [][] adjMatrix;

    public void addNode(Node n)
    {
        nodeList.add(n);
    }

    public void connectNodes(Node fromNode, Node toNode) {

        if(adjMatrix == null)
        {
            adjMatrix = new int [nodeList.size()][nodeList.size()];
        }

        int fromNodeIndex = nodeList.indexOf(fromNode);
        int toNodeIndex = nodeList.indexOf(toNode);

        adjMatrix[fromNodeIndex][toNodeIndex] = 1;
        adjMatrix[toNodeIndex][fromNodeIndex] = 1;

    }

    public Node getUnvisitedNode(Node node)
    {
        int nodeIndex =  nodeList.indexOf(node);
        for (int i = 1; i < nodeList.size(); i++) {
            if (adjMatrix[nodeIndex][i] == 1 && nodeList.get(i).visited == 0)
            {
                return nodeList.get(i);
            }
        }
        return null;
    }
    //Should print A B E F C D
    public void DFS (Node currentNode)
    {
        Stack<Node> s = new Stack<>();
        currentNode.visited = 1;
        s.push(currentNode);
        System.out.print(currentNode.data + " ");

        Node unvisitedNode = getUnvisitedNode(currentNode);

        while (!s.isEmpty() || unvisitedNode != null)
        {
            while (unvisitedNode != null)
            {
                currentNode = unvisitedNode;
                currentNode.visited = 1;
                s.push(currentNode);
                System.out.print(currentNode.data + " ");
                unvisitedNode = getUnvisitedNode(currentNode);
            }

            currentNode = s.pop();
            unvisitedNode = getUnvisitedNode(currentNode);
        }
        clearNodes();
    }

    private void clearNodes() {
        nodeList.stream().forEach(item -> item.visited = 0);
    }

    public void BFS(Node currentNode) {

        Queue<Node> q = new LinkedList<>();
        currentNode.visited = 1;
        q.add(currentNode);
        System.out.print("\n" + currentNode.data + " ");



            while (currentNode != null)
            {
                Node node = getUnvisitedNode(currentNode);
                if (node != null)
                {
                    node.visited = 1;
                    q.add(node);
                    System.out.print(node.data + " ");
                } else {
                    currentNode = q.poll();
                }

            }



    }
}
