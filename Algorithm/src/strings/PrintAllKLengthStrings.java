package strings;

public class PrintAllKLengthStrings {

    private static void printAllKLength(char[] a, String prefix, int k) {
        if (k == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            printAllKLength(a, prefix + a[i], k - 1);
        }
    }

    public static void main(String[] args) {
        printAllKLength(new char[]{'A', 'B', 'C'}, "", 2);
    }
}
