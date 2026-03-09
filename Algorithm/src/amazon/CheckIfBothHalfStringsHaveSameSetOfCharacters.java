package amazon;

import java.util.Arrays;

// Time  Complexity : O(n)
public class CheckIfBothHalfStringsHaveSameSetOfCharacters {

  private static boolean hasSameSetOfChars(char[] c) {
    int[] temp = new int[128];
    int i = 0, j = c.length - 1;
    while (i < j) {
      temp[c[i++]]++;
      temp[c[j--]]--;
    }
    return Arrays.stream(temp).allMatch(x -> x == 0);
  }

  public static void main(String[] args) {
    System.out.println(hasSameSetOfChars("a".toCharArray()));
    System.out.println(hasSameSetOfChars("abccab".toCharArray()));
    System.out.println(hasSameSetOfChars("abbaab".toCharArray()));
    System.out.println(hasSameSetOfChars("abcdabc".toCharArray()));
  }
}
