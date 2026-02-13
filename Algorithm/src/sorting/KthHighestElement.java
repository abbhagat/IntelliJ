package sorting;

import java.util.PriorityQueue;

// Time  Complexity O(n log k)
// Space Complexity O(k)
public class KthHighestElement {

  private static int findKthHighest(int[] a, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int x : a) {
      pq.add(x);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.peek();
  }

  public static void main(String[] args) {
    System.out.println(findKthHighest(new int[]{5, 4, 1, 3, 2}, 2));
    System.out.println(findKthHighest(new int[]{5, 4, 1, 3, 2}, 3));
  }
}
