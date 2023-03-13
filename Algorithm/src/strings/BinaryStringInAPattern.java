package strings;

public class BinaryStringInAPattern {

    private static void printBinaryString(char[] a, int index) {
        if (index == a.length) {
            System.out.println(a);
            return;
        }
        if (a[index] == '?') {
            a[index] = '0';
            printBinaryString(a, index + 1);
            a[index] = '1';
            printBinaryString(a, index + 1);
        } else {
            printBinaryString(a, index + 1);
        }
    }

    public static void main(String[] args) {
        printBinaryString("1??0?10?1".toCharArray(), 0);
    }
}
