package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// Time  Complexity: O(n)
// Space Complexity: O(n)
public class PrintMissingRangeFrom0To99 {

  private static void printMissingRanges(int[] a, int start, int end) {
    Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
    int index = -1, i;
    for (i = start; i <= end; i++) {
      if (set.contains(i)) {
        if (index != -1) {
          System.out.println(index == i - 1 ? index : index + "-" + (i - 1));
          index = -1;
        }
      } else {
        index = index == -1 ? i : index;
      }
    }
    if (index != -1) {
      System.out.println(index == i - 1 ? index : index + "-" + (i - 1));
    }
    System.out.println("------------------------");
  }

  public static void main(String[] args) {
    printMissingRanges(new int[]{2, 3, 4, 6, 9, 10}, 0, 99);
    printMissingRanges(new int[]{9, 6, 900, 850, 5, 90, 100, 99}, 0, 99);
    printMissingRanges(new int[]{-1, 2, 3, 10, 88, 105, 200}, 10, 50);
    printMissingRanges(new int[]{-1, 2, 3, 10, 88, 105, 200}, 40, 100);
    printMissingRanges(new int[]{-1, 2, 3, 10, 88, 105, 200}, 60, 1000);
  }
}
