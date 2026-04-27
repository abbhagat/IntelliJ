package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

  record Node(int vertex, int weight) implements Comparable<Node> {
    @Override
    public int compareTo(Node node) {
      return Integer.compare(this.weight, node.weight);
    }
  }

  public static void dijkstra(int[][] M, int source) {
    int      n = M.length;
    int[] dist = new int[n];
    boolean[] visited = new boolean[n];
    PriorityQueue<Node> pq = new PriorityQueue<>();

    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;
    pq.add(new Node(source, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int u = node.vertex;

      if (visited[u]) {
        continue;
      }
      visited[u] = true;

      for (int v = 0; v < n; v++) {
        if (M[u][v] != 0 && !visited[v]) {
          int newDist = dist[u] + M[u][v];
          if (newDist < dist[v]) {
            dist[v] = newDist;
            pq.add(new Node(v, newDist));
          }
        }
      }
    }

    System.out.println("Vertex\tDistance from Source");
    for (int i = 0; i < n; i++) {
      System.out.println(i + "\t\t\t" + dist[i]);
    }
  }

  public static void main(String[] args) {
    int[][] M = {
                  {0, 10, 0,  0, 0, 0},
                  {10, 0, 5,  0, 0, 0},
                  {0,  5, 0, 20, 1, 0},
                  {0,  0, 20, 0, 2, 2},
                  {0,  0, 1,  2, 0, 3},
                  {0,  0, 0,  2, 3, 0}
                };
    dijkstra(M, 0);
  }
}
