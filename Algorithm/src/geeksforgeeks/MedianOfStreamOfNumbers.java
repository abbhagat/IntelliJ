package geeksforgeeks;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;

// Time  Complexity : O(log n)
// Space Complexity : O(n)
public class MedianOfStreamOfNumbers {

  private static final PriorityQueue<Integer> left  = new PriorityQueue<>(Comparator.reverseOrder()); // Max heap
  private static final PriorityQueue<Integer> right = new PriorityQueue<>(); // Min heap

  public static float findMedian(int n) {
    left.offer(n);                       // Step 1: Add to max heap
    right.offer(left.poll());           //  Step 2: Balance order
    if (right.size() > left.size()) {  //   Step 3: Balance size
      left.offer(right.poll());
    }
    return left.size() == right.size() ? (left.peek() + right.peek()) / 2.0f : left.peek();
  }

  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("#.##");
    for (int x : new int[]{1, 2, 3, 4, 5}) {
      System.out.println(df.format(findMedian(x)));
    }
  }
}
