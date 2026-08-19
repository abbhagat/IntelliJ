package jpmorgan;

import java.util.*;

// Time  Complexity: O(n + n log k)
// Space Complexity: O(n)
public class TopKFrequentElementsInAnArray {

  public static void topKFreqElements(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(nums).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
    PriorityQueue<Integer> pq = new PriorityQueue<>(  //  Min-heap based on frequency
        (a, b) -> {
          int n = map.get(a).compareTo(map.get(b));
          if (n == 0) {
            return a.compareTo(b); // reverse for tie (optional)
          }
          return n;
        }
    );
    for (int x : map.keySet()) {
      pq.add(x);
      if (pq.size() > k) {
        pq.poll(); // remove least frequent
      }
    }
    System.out.println(pq);
  }

  public static void main(String[] args) {
    int[] nums = new int[]{5, 2, 5, 5, 2, 6, 2};
    topKFreqElements(nums, 2);
  }
}
