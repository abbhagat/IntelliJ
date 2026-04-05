package strings;

// Time Complexity : O(2^n) For every i we have 2 choices
public class BinaryStringInAPattern {

  private static void printBinaryString(char[] c, int i) {
    if (i == c.length) {
      System.out.println(c);
      return;
    }
    if (c[i] == '?') {
        c[i] =  '0';
        printBinaryString(c, i + 1);
        c[i] =  '1';
        printBinaryString(c, i + 1);
    } else {
        printBinaryString(c, i + 1);
    }
  }

  public static void main(String[] args) {
    printBinaryString("1??0?10?1".toCharArray(), 0);
  }
}
