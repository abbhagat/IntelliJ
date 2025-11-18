package strings;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity: O(n)
// Space Complexity: O(n)
public class Isomorphic {

  private static boolean isIsomorphic(char[] c1, char[] c2) {
    if (c1.length == c2.length) {
      Map<Character, Character> map = new HashMap<>();
      for (int i = 0; i < c1.length; i++) {
        if (map.containsKey(c1[i]) && map.get(c1[i]) != c2[i]) {
          return false;
        }
        map.put(c1[i], c2[i]);
      }
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isIsomorphic("egg".toCharArray(), "add".toCharArray()) ? "Isomorphic" : "Not Isomorphic");
    System.out.println(isIsomorphic("eeg".toCharArray(), "add".toCharArray()) ? "Isomorphic" : "Not Isomorphic");
    System.out.println(isIsomorphic("aab".toCharArray(), "baa".toCharArray()) ? "Isomorphic" : "Not Isomorphic");
    System.out.println(isIsomorphic("aab".toCharArray(), "xxy".toCharArray()) ? "Isomorphic" : "Not Isomorphic");
    System.out.println(isIsomorphic("ACA".toCharArray(), "XCX".toCharArray()) ? "Isomorphic" : "Not Isomorphic");
  }
}
