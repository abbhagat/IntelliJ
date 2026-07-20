package leetcode;

import static util.CommonUtils.isPalindrome;

// Time complexity : O(n)
// Space Complexity: O(1)
public class PalindromeIndexing {

  private static int palindromeIndex(char[] c) {
    for (int i = 0, j = c.length - 1; i < j; i++, j--) {
      if (c[i] != c[j]) {
        if (isPalindrome(c, i + 1, j)) {
          return i;
        }
        if (isPalindrome(c, i, j - 1)) {
          return j;
        }
        return -1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println("Palindrome Index : " + palindromeIndex("MADAM".toCharArray()));
    System.out.println("Palindrome Index : " + palindromeIndex("MADXAM".toCharArray()));
  }
}
