package strings;

// Time Complexity : O(2^n)

public class BinaryStringInAPattern {

    private static void printBinaryString(char[] c, int index) {
        if (index == c.length) {
            System.out.println(c);
            return;
        }
        if (c[index] == '?') {
            c[index] = '0';
            printBinaryString(c, index + 1);
            c[index] = '1';
            printBinaryString(c, index + 1);
        } else {
            printBinaryString(c, index + 1);
        }
    }

    public static void main(String[] args) {
        printBinaryString("1??0?10?1".toCharArray(), 0);
    }
}
