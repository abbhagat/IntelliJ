package strings;

// Time  Complexity : O(n^k)
// Space Complexity : O(k)
public class PrintAllKLengthStrings {

  private static void printAllKLength(char[] a, String prefix, int k) {
    if (k == 0) {
      System.out.println(prefix);
      return;
    }
    for (char c : a) {
      printAllKLength(a, prefix + c, k - 1);
    }
  }

  public static void main(String[] args) {
    printAllKLength(new char[]{'A', 'B', 'C'}, "", 3);
  }
}
