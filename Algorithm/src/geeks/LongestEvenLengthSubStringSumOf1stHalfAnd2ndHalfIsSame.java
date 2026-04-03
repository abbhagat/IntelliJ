package geeks;

/**
 * Given a string of digits, find the longest even-length substring such that the sum of the first half equals the sum of the second half.
 * The output should be the length of this substring.
 * Input: str = "123123"  Output: 6 (the entire string is valid)
 * Input: str = "1538023" Output: 4 (the longest valid substring is "5380")
 */

// Time  Complexity: O(n^2) where n is the length of the string
// Space Complexity: O(1)
public class LongestEvenLengthSubStringSumOf1stHalfAnd2ndHalfIsSame {

  private static void findLength(String s) {
    String max = "";
    for (int k = 0; k < s.length(); k++) {
      int sum1 = 0, sum2 = 0, i = k, j = k + 1;
      while (i >= 0 && j < s.length()) {
        sum1 += s.charAt(i) - '0';
        sum2 += s.charAt(j) - '0';
        if (sum1 == sum2) {
          String str = s.substring(i, j + 1);
          max = max.length() < str.length() ? str : max;
        }
        i--;
        j++;
      }
    }
    System.out.println(max + "\t" + max.length());
  }

  public static void main(String[] args) {
    findLength("123123");
    findLength("1538023");
    findLength("152380231");
  }
}
