package strings;

import java.util.Arrays;

public class StringPanagram {

  private static boolean isPanagram(String s) {
    int[] temp = new int[26];
    for (char c : s.toLowerCase().toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        temp[c - 'a']++;
      }
    }
    return Arrays.stream(temp).allMatch(x -> x > 0);
  }

  public static void main(String[] args) {
    System.out.println(isPanagram("The quick brown fox jumps over the lazy dog") ? "Panagram" : "Not Panagram");
    System.out.println(isPanagram("The quick brown fox jumps over the lays dog") ? "Panagram" : "Not Panagram");
  }
}
