package graph;

import java.util.LinkedList;

public class Graph {

    private int v;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public int getV() {
        return v;
    }
}
