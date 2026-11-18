package vmware;

public class ReverseWordsInString {

  private static String reverseWords(String str) {
    StringBuilder sb = new StringBuilder();
    String[] s = str.trim().split(" ");
    for (int i = s.length - 1; i >= 0; i--) {
      if (!s[i].isEmpty()) {
        sb.append(s[i]).append(" ");
      }
    }
    return sb.toString().trim();
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("a good  example"));
    System.out.println(reverseWords("a bad   example"));
  }
}
