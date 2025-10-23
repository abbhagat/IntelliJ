package leetcode;

import static java.lang.Integer.min;

// Time Complexity O(n log n)
public class LongestCommonSuffix {

  private static String longestCommonSuffix(String[] s, int low, int high) {
    if (low == high) {
      return s[low];
    }
    int mid = (low + high) / 2;
    String left = longestCommonSuffix(s, low, mid);
    String right = longestCommonSuffix(s, mid + 1, high);
    return longestCommonSuffix(left, right);
  }

  private static String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }

  private static String longestCommonSuffix(String left, String right) {
    left = reverse(left);
    right = reverse(right);
    int min = min(left.length(), right.length());
    for (int i = 0; i < min; i++) {
      if (left.charAt(i) != right.charAt(i)) {
        return reverse(left.substring(0, i));
      }
    }
    return reverse(left.substring(0, min));
  }

  public static void main(String[] args) {
    String[][] str = {
        {"ABCDEBUILD", "QOUCTBUILD"},
        {"ABCDEBUILD", "ABCDEBUILD"}
    };
    for (String[] s : str) {
      System.out.println(longestCommonSuffix(s, 0, s.length - 1));
    }
  }
}
