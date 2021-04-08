package strings;

public class PrintDecimalToBinary {

    private static String binary = "";

    public static void printBinary(int n, int mask) {
        if (mask != 0) {
            binary += (n & mask) == 0 ? "0" : "1";
            printBinary(n, mask >> 1);
        }
    }

    public static void main(String[] args) {
        int n = 15;
        int mask = 32768;
        String binaryString = "";
        while (mask != 0) {
            binaryString += (n & mask) == 0 ? "0" : "1";
            mask >>= 1;
        }
        System.out.println(binaryString);
        printBinary(n, 32768);
        System.out.println(binary);
    }
}
