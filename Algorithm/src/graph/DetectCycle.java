package graph;

import static graph.CreateGraph.createGraph;

// Time Complexity  : O(V + E)
// Space Complexity : O(V)
public class DetectCycle {

  private static boolean hasCycle(Graph g, int v, boolean[] visited, boolean[] recStack) {
    if (recStack[v]) {
      return true; // cycle found
    }
    if (visited[v]) {
      return false;
    }
     visited[v] = true;
    recStack[v] = true;
    for (int i : g.getEdge()[v]) {
      if (hasCycle(g, i, visited, recStack)) {
        return true;
      }
    }
    recStack[v] = false;
    return false;
  }

  public static boolean hasCycle(Graph g) {
    int v = g.getV();
    boolean[] visited  = new boolean[v];   // tracks nodes that were visited anytime in the DFS
    boolean[] recStack = new boolean[v];  //  tracks nodes currently in the recursion path (DFS call stack) is used to detect a back edge during DFS, which indicates a cycle in a directed graph.
    for (int i = 0; i < v; i++) {
      if (hasCycle(g, i, visited, recStack)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Graph g = createGraph(4);
    System.out.println(hasCycle(g));
  }
}
