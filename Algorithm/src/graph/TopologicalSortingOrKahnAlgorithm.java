package graph;

import java.util.*;

// Time  : O(N + M)
// Space : O(N + M)
public class TopologicalSortingOrKahnAlgorithm {

  public static List<String> schedule(List<String> tasks, List<String[]> dependencies) {
    Map<String, List<String>> graph = new HashMap<>();
    Map<String, Integer> inDegree = new HashMap<>();

    // Initialize
    for (String task : tasks) {
      graph.put(task, new ArrayList<>());
      inDegree.put(task, 0);
    }

    // Build graph
    for (String[] dependency : dependencies) {
      String from = dependency[0];
      String to = dependency[1];
      graph.get(from).add(to);
      inDegree.put(to, inDegree.get(to) + 1);
    }
    Queue<String> queue = new LinkedList<>();
    // Tasks with no dependency
    for (String task : tasks) {
      if (inDegree.get(task) == 0) {
        queue.offer(task);
      }
    }
    List<String> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      String task = queue.poll();
      result.add(task);
      for (String next : graph.get(task)) {
        inDegree.put(next, inDegree.get(next) - 1);

        if (inDegree.get(next) == 0) {
          queue.offer(next);
        }
      }
    }
    // Cycle detected
    if (result.size() != tasks.size()) {
      throw new IllegalArgumentException("Circular dependency exists");
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> tasks = Arrays.asList("A", "B", "C", "D", "E");
    List<String[]> dependencies = Arrays.asList(
                                                  new String[]{"A", "C"},
                                                  new String[]{"B", "C"},
                                                  new String[]{"C", "D"},
                                                  new String[]{"C", "E"}
                                              );
    System.out.println(schedule(tasks, dependencies));
  }
}
