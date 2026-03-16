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
      for (int i : g.getEdge()[v]) {
        if (!visited[i]) {
          visited[i] = true;
          q.add(i);
        }
      }
    }
  }

  public static void main(String[] args) {
    Graph g = createGraph(4);
    int v = g.getV();
    for(int i = 0; i < v; i++) {
      boolean[] visited = new boolean[v];
      BFS(g, i, visited);
      System.out.println();
    }
     // 0 1 2 3
    // 1 2 0 3
   // 2 0 3 1
  // 3
  }
}
