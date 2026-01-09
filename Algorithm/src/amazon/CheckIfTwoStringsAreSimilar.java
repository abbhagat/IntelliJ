package amazon;

import java.util.Arrays;

// Time  Complexity : O(n)
public class CheckIfTwoStringsAreSimilar {

  private static boolean isSimilar(String s1, String s2) {
    if (s1.length() == s2.length()) {
      int[] temp = new int[128];
      for (int i = 0; i < s1.length(); i++) {
        temp[s1.charAt(i)]++;
        temp[s2.charAt(i)]--;
      }
      return Arrays.stream(temp).allMatch(x -> x == 0);
    }
    return false;
  }

  public static void main(String... args) {
    System.out.println(isSimilar("xyz", "yxz"));
    System.out.println(isSimilar("abc", "cab"));
  }
}
