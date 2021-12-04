package amazon;

public class DecimalToBinary {

    private static int carry = 0;

    private static StringBuilder decimalToBinary(int n, StringBuilder result) {
        if (n != 0) {
            carry = n / 2;
            result.insert(0, n % 2);
            decimalToBinary(n / 2, result);
        }
        return result;
    }

    private static String decimalToBinary(int n) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (n != 0) {
            carry = n / 2;
            result.insert(0, n % 2);
            n /= 2;
        }
        return carry == 0 ? result.toString() : "1" + result;
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(5));
        System.out.println(decimalToBinary(15));
        System.out.println(decimalToBinary(32));
        carry = 0;
        StringBuilder result = decimalToBinary(5, new StringBuilder());
        System.out.println(carry == 0 ? result.toString() : "1" + result);
        carry = 0;
        result = decimalToBinary(15, new StringBuilder());
        System.out.println(carry == 0 ? result.toString() : "1" + result);
        carry = 0;
        result = decimalToBinary(32, new StringBuilder());
        System.out.println(carry == 0 ? result.toString() : "1" + result);
    }
}
