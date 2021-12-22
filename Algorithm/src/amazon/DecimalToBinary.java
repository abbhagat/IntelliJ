package amazon;

public class DecimalToBinary {

    private static int carry = 0;

    private static StringBuilder decimalToBinary(int n, StringBuilder binary) {
        if (n != 0) {
            carry = n / 2;
            binary.insert(0, n % 2);
            decimalToBinary(n / 2, binary);
        }
        return binary;
    }

    private static String decimalToBinary(int n) {
        StringBuilder binary = new StringBuilder();
        int carry = 0;
        while (n != 0) {
            carry = n / 2;
            binary.insert(0, n % 2);
            n /= 2;
        }
        return carry == 0 ? binary.toString() : "1" + binary;
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(5));
        System.out.println(decimalToBinary(15));
        System.out.println(decimalToBinary(32));
        carry = 0;
        StringBuilder binary = decimalToBinary(5, new StringBuilder());
        System.out.println(carry == 0 ? binary.toString() : "1" + binary);
        carry = 0;
        binary = decimalToBinary(15, new StringBuilder());
        System.out.println(carry == 0 ? binary.toString() : "1" + binary);
        carry = 0;
        binary = decimalToBinary(32, new StringBuilder());
        System.out.println(carry == 0 ? binary.toString() : "1" + binary);
    }
}
