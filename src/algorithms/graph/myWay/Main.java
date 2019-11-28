package algorithms.graph.myWay;

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph();

        // Creating nodes
        Node na = new Node('a');
        Node nb = new Node('b');
        Node nc = new Node('c');
        Node nd = new Node('d');
        Node ne = new Node('e');
        Node nf = new Node('f');

        // Adding Nodes
        g.addNode(na);
        g.addNode(nb);
        g.addNode(nc);
        g.addNode(nd);
        g.addNode(ne);
        g.addNode(nf);

        //Connecting Nodes
        g.connectNodes(na, nb);
        g.connectNodes(na, nc);
        g.connectNodes(na, nd);
        g.connectNodes(nb, ne);
        g.connectNodes(nb, nf);
        g.connectNodes(nc, nf);

        g.DFS(na);
        g.BFS(na);





    }
}
