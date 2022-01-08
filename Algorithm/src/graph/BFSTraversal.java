package graph;

import java.util.LinkedList;
import java.util.Queue;

import static graph.CreateGraph.createGraph;

public class BFSTraversal {

    public static void BFS(Graph g, int v) {
        boolean[] visited = new boolean[g.getV()];
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);
        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");
            for (int n : g.getEdge()[v]) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = createGraph(4);  // 2 0 3 1
        BFS(g, 2);
    }
}
