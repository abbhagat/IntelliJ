package graph;

public class CreateGraph {

  public static Graph createGraph(int v) {
    Graph g = new Graph(v);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 2);
    g.addEdge(3, 1);
    return g;
  }
}
