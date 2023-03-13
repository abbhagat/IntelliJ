package strings;

public class PrintDecimalToBinary {

    private static String binary = "";

    public static void printBinary(int n, int mask) {
        if (mask != 0) {
            binary += (n & mask) == 0 ? "0" : "1";
            printBinary(n, mask >> 1);
        }
    }

    private static String decimalToBinary(int n) {
        StringBuilder binary = new StringBuilder("");
        int carry = 0;
        while (n != 0) {
            carry = n / 2;
            binary = binary.insert(0, n % 2);
            n /= 2;
        }
        return carry == 1 ? "1" + binary : binary.toString();
    }

    public static void main(String[] args) {
        int n = 15, mask = 32768;
        String binaryString = "";
        while (mask != 0) {
            binaryString += (n & mask) == 0 ? "0" : "1";
            mask >>= 1;
        }
        System.out.println(binaryString);
        printBinary(n, 32768);
        System.out.println(binary);
        System.out.println(decimalToBinary(15));
    }
}
