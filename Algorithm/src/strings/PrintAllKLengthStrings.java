package strings;

public class PrintAllKLengthStrings {

    private static char set[] = {'A', 'B', 'C'};

    private static void printAllKLength(String prefix, int iterations) {
        if (iterations == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < set.length; i++) {
            printAllKLength(prefix + set[i], iterations - 1);
        }
    }

    public static void main(String[] args) {
        printAllKLength("", 3);
    }


}
