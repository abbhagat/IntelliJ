package strings;

// Time  Complexity : O(2^n)
// Space Complexity : O(n)
public class PrintBinaryPermutation {

  private static void binaryPermutation(String s, int n) {
    if (n == 0) {
      System.out.println(s);
      return;
    }
    binaryPermutation(s + "0", n - 1);
    binaryPermutation(s + "1", n - 1);
  }

  public static void main(String[] args) {
    binaryPermutation("", 2);
    binaryPermutation("", 3);
  }
}
