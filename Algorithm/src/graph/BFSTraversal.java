package graph;

import java.util.Iterator;
import java.util.LinkedList;

import static graph.CreateGraph.createGraph;

public class BFSTraversal {

    public static void BFS(Graph g, int s) {                  // // prints BFS traversal from a given source s
        boolean visited[] = new boolean[g.getV()];  // Mark all the vertices as not visited(By default set as false)
        LinkedList<Integer> queue = new LinkedList<Integer>();  // Create a queue for BFS
        visited[s] = true;    // Mark the current node as visited and enqueue it
        queue.add(s);
        while (queue.size() != 0) {   // Deque a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");
            // Get all adjacent vertices of the deque vertex s If a adjacent has not been visited, then mark it visited and enqueue it
            Iterator<Integer> i = g.getAdj()[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = createGraph(4);
        BFS(g, 2);
    }
}
