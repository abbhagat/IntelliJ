package adobe;

public class LongestCommonSubsequenceString {

  // Time Complexity  : O(2^(m+n))
  // Space Complexity : O(m+n)
  private static String lcs(String s1, String s2, int m, int n) {
    if (m == 0 || n == 0) {
      return "";
    }
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      return lcs(s1, s2, m - 1, n - 1) + s1.charAt(m - 1);
    }
    String left  = lcs(s1, s2, m - 1, n);
    String right = lcs(s1, s2, m, n - 1);
    return left.length() >= right.length() ? left : right;
  }

  public static void main(String[] args) {
    System.out.println(lcs("cat", "cut", 3, 3));
    System.out.println(lcs("geek", "gesek", 4, 5));
  }

}
