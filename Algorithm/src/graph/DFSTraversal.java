package graph;

import java.util.Iterator;

import static graph.CreateGraph.createGraph;

public class DFSTraversal {

    private static void DFSUtil(Graph g, int v, boolean visited[]) {
        visited[v] = true;                                    // Mark the current node as visited and print it
        System.out.print(v + " ");
        Iterator<Integer> i = g.getAdj()[v].listIterator();  // Recur for all the vertices adjacent to this vertex
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(g, n, visited);
            }
        }
    }

    public static void DFS(Graph g, int v) {
        boolean visited[] = new boolean[g.getV()];
        DFSUtil(g, v, visited);
    }

    public static void main(String[] args) {
        Graph g = createGraph(4);
        DFS(g, 2);
    }
}
