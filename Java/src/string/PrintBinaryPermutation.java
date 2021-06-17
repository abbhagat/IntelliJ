package string;

public class PrintBinaryPermutation {

    public static void printBinary(String s, int iterations) {
        if (iterations == 0) {
            System.out.println(s);
        } else {
            printBinary(s + "0", iterations - 1);
            printBinary(s + "1", iterations - 1);
        }
    }

    public static void main(String[] args) {
        printBinary("", 2);
    }
}
