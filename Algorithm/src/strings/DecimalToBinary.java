package strings;

import static java.lang.Integer.toBinaryString;

public class DecimalToBinary {

    private static String decimalToBinary(int n, int mask, String binaryString) {
        if (mask == 0) {
            return binaryString;
        }
        binaryString += (n & mask) == 0 ? "0" : "1";
        return decimalToBinary(n, mask >> 1, binaryString);
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
        String binaryString = decimalToBinary(100, 32768, "");
        System.out.println(binaryString.substring(binaryString.indexOf('1')));
        System.out.println(toBinaryString(100));
        System.out.println(decimalToBinary(100));
        int n = 15, mask = 32768;
        binaryString = "";
        while (mask != 0) {
            binaryString += (n & mask) == 0 ? "0" : "1";
            mask >>= 1;
        }
        System.out.println(binaryString);
    }
}
