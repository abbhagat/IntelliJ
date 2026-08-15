package geeks;

import java.util.HashMap;
import java.util.Map;

public class CheckCharCanBeReArrangedToFormPalindrome {

  private static boolean canFormPalindromeUsingMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int count = 0;
    for (int x : map.values()) {
      if (x % 2 == 1) {
        count++;
      }
      if (count > 1) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(canFormPalindromeUsingMap("aad"));
    System.out.println(canFormPalindromeUsingMap("geeksforgeeks"));
    System.out.println(canFormPalindromeUsingMap("geeksogeeks"));
    System.out.println(canFormPalindromeUsingMap("eeekkk"));
    System.out.println(canFormPalindromeUsingMap("ekekeke"));
  }
}
