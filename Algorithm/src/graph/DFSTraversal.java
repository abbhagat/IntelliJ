package graph;

import static graph.CreateGraph.createGraph;

// Time  Complexity : O(V + E), where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity : O(V), since an extra visited array of size V is required.
public class DFSTraversal {

  private static void DFS(Graph g, int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");
    for (int i : g.getEdge()[v]) {
      if (!visited[i]) {
        DFS(g, i, visited);
      }
    }
  }

  public static void main(String[] args) {
    Graph g = createGraph(4);
    int v = g.getV();
    for(int i = 0; i < v; i++) {
      boolean[] visited = new boolean[v];
      DFS(g, i, visited);
      System.out.println();
    }
    //  i = 0 => 0 1 2 3
    //  i = 1 => 1 2 3
    //  i = 2 => 2 3 1
    //  i = 3 => 3 1 2
  }
}
