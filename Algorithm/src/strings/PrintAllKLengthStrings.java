package strings;

public class PrintAllKLengthStrings {

    private static void printAllKLength(char[] set, String prefix, int itr) {
        if (itr == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < set.length; i++) {
                printAllKLength(set, prefix + set[i], itr - 1);
            }
        }
    }

    public static void main(String[] args) {
        printAllKLength(new char[]{'A', 'B', 'C'}, "", 3);
    }
}
