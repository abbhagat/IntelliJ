package strings;

public class PrintAllKLengthStrings {

    private static char set[] = {'A', 'B', 'C'};

    private static void printAllKLength(String prefix, int itr) {
        if (itr == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < set.length; i++) {
                printAllKLength(prefix + set[i], itr - 1);
            }
        }
    }

    public static void main(String[] args) {
        printAllKLength("", 3);
    }
}
