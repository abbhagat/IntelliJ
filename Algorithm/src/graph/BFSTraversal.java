package graph;

import java.util.LinkedList;
import java.util.Queue;
import static graph.CreateGraph.createGraph;

// Time  Complexity : O(V + E), where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity : O(V), since an extra visited array of size V is required.
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
    //  i = 0 => 0 1 2 3
    //  i = 1 => 1 2 3
    //  i = 2 => 2 3 1
    //  i = 3 => 3 1 2
  }
}
