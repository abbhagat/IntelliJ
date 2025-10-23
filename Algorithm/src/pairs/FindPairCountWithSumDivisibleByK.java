package pairs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time  Complexity : O(n + k)
// Space Complexity : O(k)
public class FindPairCountWithSumDivisibleByK {

  private static int findPairs(int[] a, int k) {
    Set<String> set = new HashSet<>();
    int count = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if ((a[i] + a[j]) % k == 0) {
          int min = min(a[i], a[j]);
          int max = max(a[i], a[j]);
          String pair = min + "," + max;
          if (set.add(pair)) {
            System.out.println("(" + min + "," + max + ")");
            count++;
          }
        }
      }
    }
    return count;
  }

  private static int findPairCount(int[] a, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int x : a) {
      int y = x % k;
      int z = (k - y) % k;  // complement
      count += map.getOrDefault(z, 0);
      map.put(y, map.getOrDefault(y, 0) + 1);   // map.merge(y, 1, Integer::sum);
    }
    return count;
  }

  private static int countPairs(int[] a, int k) {
    int[] freq = new int[k];
    for (int x : a) {
      int y = x % k;
      freq[y]++;  // keeps the count of each remainder
    }
    int count = freq[0] * (freq[0] - 1) / 2;  // Counting Pairs with Remainder 0
    for (int i = 1; i <= k / 2 && i != (k - i); i++) {  // Counting Pairs with Remainders i and k-i
      count += freq[i] * freq[k - i];
    }
    count += k % 2 == 0 ? freq[k / 2] * (freq[k / 2] - 1) / 2 : 0;  // Counting Pairs with Remainder k/2 if k is even
    return count;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 8};
    findPairs(a, 5);
    System.out.println(findPairs(a, 5) + "\t" + countPairs(a, 5) + "\t" + findPairCount(a, 5));
    System.out.println("------------------------");
    int[] b = {2, 1, 7, 5, 3};
    System.out.println(findPairs(b, 5) + "\t" + countPairs(b, 5) + "\t" + findPairCount(b, 5));
    System.out.println("------------------------");
    int[] c = {2, 3, 5, 10};
    System.out.println(findPairs(c, 5) + "\t" + countPairs(c, 5) + "\t" + findPairCount(c, 5));
  }
}
