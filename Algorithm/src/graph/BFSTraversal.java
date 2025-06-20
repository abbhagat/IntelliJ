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
            for (int n : g.getEdge()[v]) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = createGraph(4);
        BFS(g, 0, new boolean[g.getV()]);     // 0 1 2 3
        System.out.println();
        BFS(g, 1, new boolean[g.getV()]);    // 1 2 0 3
        System.out.println();
        BFS(g, 2, new boolean[g.getV()]);   // 2 0 3 1
        System.out.println();
        BFS(g, 3, new boolean[g.getV()]);  // 3
    }
}
