package geeks;

import java.util.LinkedHashMap;
import java.util.Map;

public class CheckCharCanBeReArrangedToFormPalindrome {

  private static boolean canFormPalindrome(String s) {
    int[] temp = new int[128];
    for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
      temp[s.charAt(i)]++;
      temp[s.charAt(j)]--;
    }
    int count = 0;
    for (int x : temp) {
      if (x != 0) {
        count++;
      }
      if (count > 1) {
        return false;
      }
    }
    return true;
  }

  private static boolean canFormPalindromeUsingMap(String s) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    s.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
    int count = 0;
    for (int n : map.values()) {
      if (n % 2 == 1) {
        count++;
      }
      if (count > 1) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(canFormPalindrome("geeksforgeeks"));
    System.out.println(canFormPalindrome("geeksogeeks"));
    System.out.println(canFormPalindromeUsingMap("geeksforgeeks"));
    System.out.println(canFormPalindromeUsingMap("geeksogeeks"));
    System.out.println(canFormPalindromeUsingMap("eeekkk"));
    System.out.println(canFormPalindromeUsingMap("ekekeke"));
  }
}
