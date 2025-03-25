package strings;

/**
 * Time  complexity O(n^k), where n is the length of the input array a[] and k is the length of the strings to be printed.
 * This is because the method generates all possible strings of length k from the given characters, and there are n^k such strings.
 * Space complexity of the method is O(k) for the recursion stack, as the maximum depth of the recursion is k.
 * The space used for the `prefix` string is not considered additional space since it is part of the input/output.
 */
public class PrintAllKLengthStrings {

    private static void printAllKLength(char[] a, String prefix, int k) {
        if (k == 0) {
            System.out.println(prefix);
            return;
        }
        for (char c : a) {
            printAllKLength(a, prefix + c, k - 1);
        }
    }

    public static void main(String[] args) {
        printAllKLength(new char[]{'A', 'B', 'C'}, "", 3);
    }
}
