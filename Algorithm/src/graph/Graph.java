package graph;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Graph {

  private final int v;
  private final List<Integer>[] edge;

  @SuppressWarnings("unchecked")
  public Graph(int v) {
    this.v = v;
    edge = new ArrayList[v];
    for (int i = 0; i < v; i++) {
      edge[i] = new ArrayList<>();
    }
  }

  public void addEdge(int v, int e) {
    edge[v].add(e);
  }

}
