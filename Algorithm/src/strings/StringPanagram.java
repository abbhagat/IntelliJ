package strings;

public class StringPanagram {

  private static boolean isPanagram(String s) {
    int[] temp = new int[26];
    for (char c : s.toLowerCase().toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        temp[c - 'a']++;
      }
    }
    for (int x : temp) {
      if (x == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPanagram("The quick brown fox jumps over the lazy dog") ? "Panagram" : "Not Panagram");
    System.out.println(isPanagram("The quick brown fox jumps over the lays dog") ? "Panagram" : "Not Panagram");
  }
}
