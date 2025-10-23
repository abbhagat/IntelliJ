package recursion;

// Time Complexity : O(log n)
public class DecimalToBinary {

  private static String decimalToBinary(int n) {
    StringBuilder binary = new StringBuilder();
    int carry = 0;
    while (n != 0) {
      carry = n / 2;
      binary.insert(0, n % 2);
      n = n / 2;
    }
    return carry == 0 ? binary.toString() : "1" + binary;
  }

  public static void main(String[] args) {
    System.out.println(35 + " -> " + decimalToBinary(35));
    System.out.println(10 + " -> " + decimalToBinary(10));
  }
}
