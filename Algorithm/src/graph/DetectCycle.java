package graph;

import static graph.CreateGraph.createGraph;

public class DetectCycle {

  private static boolean hasCycleUtil(Graph g, int v, boolean[] visited, boolean[] recStack) {
    if (recStack[v]) {
      return true; // cycle found
    }
    if (visited[v]) {
      return false;
    }
    visited[v] = true;
    recStack[v] = true;
    for (int n : g.getEdge()[v]) {
      if (hasCycleUtil(g, n, visited, recStack)) {
        return true;
      }
    }
    recStack[v] = false;
    return false;
  }

  public static boolean hasCycle(Graph g) {
    boolean[] visited  = new boolean[g.getV()];
    boolean[] recStack = new boolean[g.getV()];
    for (int i = 0; i < g.getV(); i++) {
      if (hasCycleUtil(g, i, visited, recStack)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Graph g = createGraph(4);
    System.out.println(DetectCycle.hasCycle(g));
  }
}