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

    public static void main(String[] args) {
        String binaryString = decimalToBinary(100, 32768, "");
        System.out.println(binaryString.substring(binaryString.indexOf('1')));
        System.out.println(toBinaryString(100));
    }
}
