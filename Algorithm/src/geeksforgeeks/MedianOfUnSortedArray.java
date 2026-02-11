package geeksforgeeks;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfUnSortedArray {

  public static float findMedian(int[] a) {
    PriorityQueue<Integer> left  = new PriorityQueue<>(Comparator.reverseOrder()); // Max heap
    PriorityQueue<Integer> right = new PriorityQueue<>();                         //  Min heap
    Arrays.stream(a).forEach(x -> {
      left.offer(x);                       // Step 1: Add to max heap
      right.offer(left.poll());           //  Step 2: Balance order
      if (right.size() > left.size()) {  //   Step 3: Balance size
        left.offer(right.poll());
      }
    });
    return left.size() == right.size() ? (left.peek() + right.peek()) / 2.0f : left.peek();
  }

  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("#.##");
    System.out.println(df.format(findMedian(new int[]{1, 4, 3, 2})));
    System.out.println(df.format(findMedian(new int[]{1, 4, 3, 2, 5})));
    System.out.println(df.format(findMedian(new int[]{1, 4, 3, 2, 5, 6})));
    System.out.println(df.format(findMedian(new int[]{1, 4, 3, 2, 5, 6, 7})));
    System.out.println(df.format(findMedian(new int[]{1, 4, 3, 2, 5, 8, 7, 6})));
  }
}
