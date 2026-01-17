package pairs;

import java.util.HashSet;
import java.util.Set;
import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class FindPairCountWithDiffDivisibleByK {

  private static int findPairs(int[] a, int k) {
    Set<String> set = new HashSet<>();
    int count = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if ((a[i] - a[j]) % k == 0) {
          int min = min(a[i], a[j]);
          int max = max(a[i], a[j]);
          var pair = min + "," + max;
          if (set.add(pair)) {
            System.out.println("(" + min + "," + max + ")");
            count++;
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(findPairs(new int[]{1, 2, 3, 4, 5, 8}, 5));
    System.out.println(findPairs(new int[]{2, 4, 6, 5, 3}, 9));
    System.out.println(findPairs(new int[]{2, 3, 5, 10}, 5));
    System.out.println(findPairs(new int[]{74, 66, 48, 11}, 13));
  }
}
