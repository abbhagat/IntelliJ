package vmware;

import java.util.Arrays;
import java.util.PriorityQueue;
import static util.CommonUtils.printArray;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class NthMaxAndMinElementInArray {

  private static Integer nthMax(int[] a, int n) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int x : a) {
      pq.add(x);
      if (pq.size() > n) {
        pq.poll();
      }
    }
    return pq.isEmpty() ? null : pq.peek();
  }

  private static Integer nthMin(int[] a, int n) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);  // Comparator.reverseOrder()
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
    Arrays.sort(a);
    printArray(a);
    System.out.println(nthMax(a, 3));
    System.out.println(nthMin(a, 3));
    System.out.println(nthMax(a, 2));
    System.out.println(nthMin(a, 2));
  }
}
