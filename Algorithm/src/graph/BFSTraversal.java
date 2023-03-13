package graph;

import java.util.LinkedList;
import java.util.Queue;

import static graph.CreateGraph.createGraph;

public class BFSTraversal {
    public static void BFS(Graph g, int v, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);
        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");
            LinkedList<Integer> edge = g.getEdge()[v];
            for (int n : edge) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = createGraph(4);
        BFS(g, 0, new boolean[g.getV()]);     // 0 1 2 3
        BFS(g, 1, new boolean[g.getV()]);    // 1 2 0 3
        BFS(g, 2, new boolean[g.getV()]);   // 2 0 3 1
        BFS(g, 3, new boolean[g.getV()]);  // 3
    }
}
