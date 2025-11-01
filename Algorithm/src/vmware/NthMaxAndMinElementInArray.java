package vmware;

import java.util.PriorityQueue;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class NthMaxAndMinElementInArray {

  private static Integer thirdMax(int[] a, int n) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int x : a) {
      pq.add(x);
      if (pq.size() > n) {
        pq.poll();
      }
    }
    return pq.isEmpty() ? null : pq.peek();
  }

  private static Integer thirdMin(int[] a, int n) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
    for (int x : a) {
      pq.add(x);
      if (pq.size() > n) {
        pq.poll();
      }
    }
    return pq.isEmpty() ? null : pq.peek();
  }

  public static void main(String[] args) {
    int[] a = {5, 2, 8, 4, 10, 1, 7, 3, 9, 6};
    System.out.println(thirdMax(a, 3));
    System.out.println(thirdMin(a, 3));
    System.out.println(thirdMax(a, 2));
    System.out.println(thirdMin(a, 2));
  }
}
