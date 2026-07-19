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

  private static void printMissingRange(int[] a, int start, int end) {
    Arrays.sort(a);
    if (start < a[0]) {                         // Missing before the first element
      printRange(start, a[0] - 1);
    }
    int i;
    for (i = 1; i < a.length; i++) {          // Missing between consecutive elements
      if (a[i] - a[i - 1] != 1) {
        printRange(a[i - 1] + 1, a[i] - 1);
      }
    }
    if (a[i - 1] < end) {                   // Missing after the last element
      printRange(a[i - 1] + 1, end);
    }
    System.out.println("------------------------");
  }

  private static void printRange(int start, int end) {
    System.out.println(start == end ? start : start + "-" + end);
  }

  public static void main(String[] args) {
    printMissingRanges(new int[]{2, 3, 4, 6, 9, 10}, 0, 99);
    printMissingRange(new int[]{2, 3, 4, 6, 9, 10}, 0, 99);
    printMissingRanges(new int[]{9, 6, 900, 850, 5, 90, 100, 99}, 0, 99);
    printMissingRange(new int[]{9, 6, 900, 850, 5, 90, 100, 99}, 0, 99);
    printMissingRanges(new int[]{-1, 2, 3, 10, 88, 105, 200}, 10, 50);
    printMissingRange(new int[]{-1, 2, 3, 10, 88, 105, 200}, 10, 50);
    printMissingRanges(new int[]{-1, 2, 3, 10, 88, 105, 200}, 40, 100);
    printMissingRange(new int[]{-1, 2, 3, 10, 88, 105, 200}, 40, 100);
    printMissingRanges(new int[]{-1, 2, 3, 10, 88, 105, 200}, 60, 1000);
    printMissingRange(new int[]{-1, 2, 3, 10, 88, 105, 200}, 60, 1000);
  }
}
