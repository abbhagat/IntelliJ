package dynamicProgramming;

import static java.lang.Integer.min;

public class PalindromePartitioningDP {

  private static boolean[][] createDPArray(String s) {
    boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      isPalindrome[i][i] = true;
    }
    for (int i = 0; i < s.length() - 1; i++) {
      isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
    }
    for (int i = 2; i < s.length(); i++) {
      for (int j = 0; j + i < s.length(); j++) {
        isPalindrome[j][j + i] = isPalindrome[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
      }
    }
    return isPalindrome;
  }

  public static int minPalindromePartition(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    boolean[][] isPalindrome = createDPArray(s);
    int[] dp = new int[s.length() + 1];
    dp[0] = 0;
    for (int i = 1; i <= s.length(); i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j = 0; j < i; j++) {
        if (isPalindrome[j][i - 1]) {
          dp[i] = min(dp[i], dp[j] + 1);
        }
      }
    }
    return dp[s.length()] - 1;
  }

  public static void main(String[] args) {
    System.out.println(minPalindromePartition("ababbbabbababa"));
    System.out.println(minPalindromePartition("abcde"));
    System.out.println(minPalindromePartition("abbac"));
    System.out.println(minPalindromePartition("geek"));
    System.out.println(minPalindromePartition("aaaa"));
    System.out.println(minPalindromePartition("aaabba"));
    System.out.println(minPalindromePartition("aab"));
  }
}
