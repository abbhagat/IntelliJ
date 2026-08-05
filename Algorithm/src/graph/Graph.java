package graph;

import lombok.Getter;
import java.util.LinkedList;

@Getter
public class Graph {

  private final int v;
  private final LinkedList<Integer>[] edge;

  @SuppressWarnings("unchecked")
  public Graph(int v) {
    this.v = v;
    this.edge = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      this.edge[i] = new LinkedList<>();
    }
  }

  public void addEdge(int v, int e) {
    this.edge[v].addLast(e);
  }

  public void removeEdge(int v, int e) {
    this.edge[v].remove(e);
  }

}
