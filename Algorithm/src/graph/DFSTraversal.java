package graph;

import static graph.CreateGraph.createGraph;

// Time  Complexity : O(V + E), where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity : O(V), since an extra visited array of size V is required.
public class DFSTraversal {

    private static void DFS(Graph g, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : g.getEdge()[v]) {
            if (!visited[n]) {
                DFS(g, n, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = createGraph(4);
        DFS(g, 0, new boolean[g.getV()]);   // 0 1 2 3
        System.out.println();
        DFS(g, 1, new boolean[g.getV()]);  //  1 2 0 3
        System.out.println();
        DFS(g, 2, new boolean[g.getV()]);  //  2 0 1 3
        System.out.println();
        DFS(g, 3, new boolean[g.getV()]);  //  3
    }
}
