package amazon;

// Time  Complexity : O(n)
public class CheckIfTwoStringsAreSimilar {

  private static boolean areSimilar(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    int first = -1, second = -1;

    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (first == -1) {
          first = i;
        } else if (second == -1) {
          second = i;
        } else {
          return false; // More than two differences
        }
      }
    }

    if (first == -1) {
      return true; // Strings are already equal
    }
    if (second == -1) {
      return false; // Only one mismatch
    }
    return s1.charAt(first)  == s2.charAt(second)
        && s1.charAt(second) == s2.charAt(first);
  }

  public static void main(String... args) {
    System.out.println(areSimilar("xyz", "yxz"));
    System.out.println(areSimilar("abc", "cab"));
    System.out.println(areSimilar("bank", "kanb"));     // true
    System.out.println(areSimilar("attack", "defend")); // false
    System.out.println(areSimilar("kelb", "kelb"));     // true
    System.out.println(areSimilar("kelb", "keeb"));     // false
    System.out.println(areSimilar("abcd", "abdc"));     // true
    System.out.println(areSimilar("abcd", "abdd"));     // false
    System.out.println(areSimilar("abcd", "dcba"));     // false
  }
}
