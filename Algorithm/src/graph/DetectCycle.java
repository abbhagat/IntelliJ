package graph;

import static graph.CreateGraph.createGraph;

/**
 *   0 → 1 → 2 → 3
 *       ↑       ↓
 *       └───────┘
 * 0 → 1
 * 1 → 2
 * 2 → 3
 * 3 → 1   (this creates a cycle)
 * Step 1: Visit 0
 *                  visited  = [T, F, F, F]
 *                  recStack = [T, F, F, F]
 * Step 2: Go to 1
 *                  visited  = [T, T, F, F]
 *                  recStack = [T, T, F, F]
 * Step 3: Go to 2
 *                  visited  = [T, T, T, F]
 *                  recStack = [T, T, T, F]
 * Step 4: Go to 3
 *                  visited  = [T, T, T, T]
 *                  recStack = [T, T, T, T]
 * Step 5: From 3 → go to 1 Now check:  if (recStack[1]) return true;
 *
 */

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
