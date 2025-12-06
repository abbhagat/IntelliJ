package geeks;

/**
 * Problem:
 * Given a string of digits, find the longest even-length substring such that the sum of the first half equals the sum of the second half.
 * The output should be the length of this substring.
 * Input: str = "123123"  Output: 6 (the entire string is valid)
 * Input: str = "1538023" Output: 4 (the longest valid substring is "5380")
 */

// Time  Complexity: O(n^2) where n is the length of the string
// Space Complexity: O(1)
public class LongestEvenLengthSubStringSumOf1stHalfAnd2ndHalfIsSame {

  private static void findLength(String s) {
    String maxString = "";
    for (int k = 0; k < s.length(); k++) {
      int leftSum = 0, rightSum = 0;
      for (int i = k, j = k + 1; i >= 0 && j < s.length(); i--, j++) {
        leftSum  += Character.getNumericValue(s.charAt(i));
        rightSum += Character.getNumericValue(s.charAt(j));
        if (leftSum == rightSum) {
          String str = s.substring(i, j + 1);
          maxString = maxString.length() < str.length() ? str : maxString;
        }
      }
    }
    System.out.println(maxString + "\t" + maxString.length());
  }

  public static void main(String[] args) {
    findLength("123123");
    findLength("1538023");
    findLength("152380231");
  }
}
