package pairs;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class FindPairCountWithDivDivisibleByK {

  private static void findPairs(int[] a, int k) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if ((a[i] / a[j]) % k == 0) {
          int min = min(a[i], a[j]);
          int max = max(a[i], a[j]);
          var pair = min + "," + max;
          if (set.add(pair)) {
            System.out.println("(" + min + "," + max + ")");
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    findPairs(new int[]{2, 4}, 2);
  }
}
