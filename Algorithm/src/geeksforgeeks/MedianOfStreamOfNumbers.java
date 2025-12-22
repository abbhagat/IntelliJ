package geeksforgeeks;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStreamOfNumbers {

  private static final PriorityQueue<Float> left = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
  private static final PriorityQueue<Float> right = new PriorityQueue<>(); // Min heap


  public static void addNum(float num) {
    left.offer(num);                     // Step 1: Add to max heap
    right.offer(left.poll());           // Step 2: Balance order
    if (right.size() > left.size()) {  // Step 3: Balance size
      left.offer(right.poll());
    }
  }

  public static double findMedian() {
    return left.size() == right.size() ? (left.peek() + right.peek()) / 2 : left.peek();
  }

  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("#.##");
    for (int x : new int[]{1, 2, 3, 4, 5}) {
      addNum(x);
      System.out.println(df.format(findMedian()));
    }
  }
}
