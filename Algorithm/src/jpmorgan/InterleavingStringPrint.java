package jpmorgan;

/**
 * Given two strings str1 and str2, write a function that prints all interleaving of the given two strings.
 * You may assume that all characters in both strings are different.
 * ---------------------------------------------------------------------------------------------------
 * Example:
 * Input: str1 = "AB",  str2 = "CD"    | Input: str1 = "AB",  str2 = "C"
 * Output:                             | Output:
 * ABCD                                |           ABC
 * ACBD                                |           ACB
 * ACDB                                |           CAB
 * CABD                                |
 * CADB                                |
 * CDAB                                |
 * ---------------------------------------------------------------------------------------------------
 * An interleaved string of given two strings preserves the order of characters in individual strings.
 * Ex: in all the interleaving of above first example, ‘A’ comes before ‘B’ and ‘C’ comes before ‘D’
 */

// Time Complexity: O(2^(m+n))
// Auxiliary Space: O(1)
public class InterleavingStringPrint {

  private static void printInterLeaving(String s1, String s2, String s3, int i, int j) {
    if (i == s1.length() && j == s2.length()) {
      System.out.println(s3);
      return;
    }
    if (i < s1.length()) {
      printInterLeaving(s1, s2, s3 + s1.charAt(i), i + 1, j);
    }
    if (j < s2.length()) {
      printInterLeaving(s1, s2, s3 + s2.charAt(j), i, j + 1);
    }
  }

  public static void main(String[] args) {
    printInterLeaving("AB", "C" , "", 0, 0);
    System.out.println();
    printInterLeaving("AB", "CD", "", 0, 0);
  }
}
