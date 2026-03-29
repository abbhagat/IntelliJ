package pairs;

import java.util.*;
import static java.lang.Integer.*;

// Time  Complexity : O(n + k)
// Space Complexity : O(k)
public class FindPairCountWithSumDivisibleByK {

  private static int findPairs(int[] a, int k) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if ((a[i] + a[j]) % k == 0) {
          int min  = min(a[i], a[j]);
          int max  = max(a[i], a[j]);
          var pair = min + "," + max;
          if (set.add(pair)) {
            System.out.println("(" + min + "," + max + ")");
          }
        }
      }
    }
    return set.size();
  }

  private static int findPairCount(int[] a, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int x : a) {
      int y = x % k;
      int z = (k - y) % k;  // Complement Remainder (x + y) % k == 0 => (x % k + y % k) % k == 0 if x % k = y then we need y % k = (k - y) % k
      count += map.getOrDefault(z, 0);  // Check how many elements we have already seen with remainder z Each of them forms a valid pair with current x
      map.put(y, map.getOrDefault(y, 0) + 1);  // Add current remainder y to the map and Increase its frequency
    }
    return count;
  }

  private static int countPairs(int[] a, int k) {
    int[] freq = new int[k];
    int count = 0;
    for (int x : a) {
      int y = x % k;
      int z = (k - y) % k;  // Complement Remainder (x + y) % k == 0 => (x % k + y % k) % k == 0 if x % k = y then we need y % k = (k - y)
      count += freq[z];    // how many numbers we have already seen whose remainder is z Each of those numbers can form a valid pair with the current number
      freq[y]++;
    }
    return count;
  }

  public static void main(String[] args) {
    int[] x = {1, 2};
    System.out.println(findPairs(x, 3) + "\t" + countPairs(x, 3) + "\t" + findPairCount(x, 3));
    System.out.println("------------------------");
    int[] a = {1, 2, 3, 4, 5, 8};
    System.out.println(findPairs(a, 5) + "\t" + countPairs(a, 5) + "\t" + findPairCount(a, 5));
    System.out.println("------------------------");

    int[] b = {2, 4, 6, 5, 3};
    System.out.println(findPairs(b, 9) + "\t" + countPairs(b, 9) + "\t" + findPairCount(b, 9));
    System.out.println("------------------------");

    int[] c = {2, 3, 5, 10};
    System.out.println(findPairs(c, 5) + "\t" + countPairs(c, 5) + "\t" + findPairCount(c, 5));
    System.out.println("------------------------");

    c = new int[]{74, 66, 48, 11};
    System.out.println(findPairs(c, 13) + "\t" + countPairs(c, 13) + "\t" + findPairCount(c, 13));
  }
}
