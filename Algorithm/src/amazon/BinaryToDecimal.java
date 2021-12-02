package amazon;

public class BinaryToDecimal {

    private static int carry = 0;

    private static StringBuilder binaryToDecimal(int n, StringBuilder result) {
        if (n != 0) {
            carry = n / 2;
            result.insert(0, n % 2);
            binaryToDecimal(n / 2, result);
        }
        return result;
    }

    private static String binaryToDecimal(int n) {
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
        System.out.println(binaryToDecimal(5));
        System.out.println(binaryToDecimal(15));
        System.out.println(binaryToDecimal(32));
        carry = 0;
        StringBuilder result = binaryToDecimal(5, new StringBuilder());
        System.out.println(carry == 0 ? result.toString() : "1" + result);
        carry = 0;
        result = binaryToDecimal(15, new StringBuilder());
        System.out.println(carry == 0 ? result.toString() : "1" + result);
        carry = 0;
        result = binaryToDecimal(32, new StringBuilder());
        System.out.println(carry == 0 ? result.toString() : "1" + result);
    }
}
