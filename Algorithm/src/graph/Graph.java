package graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {

  private final int v;
  private final List<Integer>[] edge;

  public Graph(int v) {
    this.v = v;
    this.edge = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      this.edge[i] = new LinkedList<>();
    }
  }

  public void addEdge(int v, int e) {
    this.edge[v].add(e);
  }

  public List<Integer>[] getEdge() {
    return this.edge;
  }

  public int getV() {
    return this.v;
  }
}
