package amazon;

import static java.lang.Integer.max;

// Time Complexity : O(n)
public class AddTwoBinaryStringAndPrintTheResultInBinaryString {

  private static StringBuilder add(String num1, String num2, int base) {
    StringBuilder result = new StringBuilder();
    int carry  = 0, l1 = num1.length(), l2 = num2.length(), l = max(l1, l2);
    for (int i = 0; i < l; i++) {
      int x    = i < l1 ? num1.charAt(l1 - i - 1) - '0' : 0;
      int y    = i < l2 ? num2.charAt(l2 - i - 1) - '0' : 0;
      int sum  = x + y + carry;
      carry    = sum / base;
      result.insert(0, sum % base);
    }
    return carry == 0 ? result : result.insert(0, "1");
  }

  public static void main(String[] args) {
    System.out.println(add("1111", "1010", 2));
    System.out.println(add("15",   "20",   8));
    System.out.println(add("156",  "203",  10));
    System.out.println(add("17",   "203",  10));
  }
}
