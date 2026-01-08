package adobe;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import static java.lang.Integer.max;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class LongestConsecutiveSequence {

  private static int longestConsecutiveSequence(int[] a) {
    Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
    int max = 0;
    for (int x : a) {
      int i = x - 1, j = x + 1, count = 1;
      while (set.contains(i)) {
        count++;
        set.remove(i);
        i--;
      }
      while (set.contains(j)) {
        count++;
        set.remove(j);
        j++;
      }
      max = max(max, count);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(longestConsecutiveSequence(new int[]{100, 4, 20, 1, 3, 2}));
    System.out.println(longestConsecutiveSequence(new int[]{10, 4, 9, 1, 3, 2, 8, 7, 6}));
  }
}
