package amazon;

// Time  Complexity : O(n)
public class CheckIfTwoStringsAreSimilar {

  private static boolean areSimilar(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    int i = -1, j = -1;
    for (int k = 0; k < s1.length(); k++) {
      if (s1.charAt(k) != s2.charAt(k)) {
        if (i == -1) {
          i = k;
        } else if (j == -1) {
          j = k;
        } else {
          return false; // More than two differences
        }
      }
    }
    if (i == -1) {
      return true; // Strings are already equal
    }
    if (j == -1) {
      return false; // Only one mismatch
    }
    return s1.charAt(i)  == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
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
