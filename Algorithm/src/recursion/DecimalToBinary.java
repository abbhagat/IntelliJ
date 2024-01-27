package recursion;

public class DecimalToBinary {

    private static int carry = 0;

    private static String decimalToBinary(int num, int mask, String binaryString) {
        if (mask == 0) {
            return binaryString;
        }
        binaryString += (num & mask) == 0 ? 0 : 1;
        return decimalToBinary(num, mask >> 1, binaryString);
    }

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
            n = n / 2;
        }
        return carry == 0 ? binary.toString() : "1" + binary;
    }

    public static void main(String[] args) {
        String binaryString = decimalToBinary(35, 32768, "");
        System.out.println(binaryString.substring(binaryString.indexOf("1")));
        carry = 0;
        StringBuilder binary = decimalToBinary(35, new StringBuilder());
        System.out.println(carry == 0 ? binary.toString() : "1" + binary);
        System.out.println(decimalToBinary(35));
    }
}
