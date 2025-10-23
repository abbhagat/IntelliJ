package strings;

// Time  Complexity: O(n)
// Space Complexity: O(n)
public class CreateStringByRemovingEmptySpacesFromCharArray {

  private static StringBuilder removeEmptyChar(String str) {
    StringBuilder sb = new StringBuilder();
    for (char c : str.trim().toCharArray()) {
      if (c != ' ') {
        sb.append(c);
      }
    }
    return sb;
  }

  public static void main(String[] args) {
    System.out.println(removeEmptyChar(" abc d e    f ghi  j  k "));
    System.out.println(removeEmptyChar(" abc d e    f ghi  j "));
  }
}
