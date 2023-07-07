package graph;

import java.util.LinkedList;

public class Graph {
    private final int v;
    private final LinkedList<Integer>[] edge;

    public Graph(int v) {
        this.v = v;
        this.edge = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            edge[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        edge[v].add(w);
    }

    public LinkedList<Integer>[] getEdge() {
        return edge;
    }

    public int getV() {
        return v;
    }
}
