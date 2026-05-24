package vmware;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class IsSubsequenceString {

  private static boolean isSubsequence(String s1, String s2) {
    if (s2.isEmpty()) {
      return true;
    }
    int j = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) == s2.charAt(j)) {
        j++;
      }
      if (j == s2.length()) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isSubsequence("ahbgdc", "abc"));
    System.out.println(isSubsequence("ahbgdc", "axc"));
    System.out.println(isSubsequence("axbgdc", "axc"));
  }
}
