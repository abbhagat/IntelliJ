package strings;

public class LongestContiguousSubsequenceString {

  private static String longestContiguousSubstring(String str) {
    if (str == null || str.isEmpty()) {
      return "";
    }
    char[] c = str.toCharArray();
    int start = 0, maxStart = 0, maxLen = 1;
    for (int i = 1; i < c.length; i++) {
      if (c[i] - c[i - 1] == 1) {
        if (maxLen   < i - start + 1) {
            maxLen   = i - start + 1;
            maxStart = start;
        }
      } else if (c[i] != c[i - 1]) {
        start = i;
      }
    }
    return new String(c, maxStart, maxLen);
  }

  public static void main(String[] args) {
    String s = longestContiguousSubstring("abcdedijklmnopqrstuvwxyzssssfgsdgadmnopqrstuv");
    System.out.println(s + " " + s.length());
  }
}
