package geeks;

import java.util.LinkedHashMap;
import java.util.Map;

public class CheckCharCanBeReArrangedToFormPalindrome {

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
    System.out.println(canFormPalindromeUsingMap("aad"));
    System.out.println(canFormPalindromeUsingMap("geeksforgeeks"));
    System.out.println(canFormPalindromeUsingMap("geeksogeeks"));
    System.out.println(canFormPalindromeUsingMap("eeekkk"));
    System.out.println(canFormPalindromeUsingMap("ekekeke"));
  }
}
