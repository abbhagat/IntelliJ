package vmware;

import java.util.PriorityQueue;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class ThirdMaxAndMinElementInArray {

  private static Integer thirdMax(int[] a) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int x : a) {
      pq.add(x);
      if (pq.size() > 3) {
        pq.poll();
      }
    }
    return pq.isEmpty() ? null : pq.peek();
  }

  private static Integer thirdMin(int[] a) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
    for (int x : a) {
      pq.add(x);
      if (pq.size() > 3) {
        pq.poll();
      }
    }
    return pq.isEmpty() ? null : pq.peek();
  }

  public static void main(String[] args) {
    System.out.println(thirdMax(new int[]{1, 2, 3, 4, 5}));
    System.out.println(thirdMax(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    System.out.println(thirdMin(new int[]{6, 7, 8, 9, 10}));
    System.out.println(thirdMin(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
  }
}
