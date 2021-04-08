package strings;

public class PrintAllKLengthStrings {

    static char set[] = { 'A', 'B', 'C'};

    public static void main(String[] args) {
        printAllKLength("", 3);
    }

    static void printAllKLength(String prefix, int iterations) {
        if (iterations == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < set.length; i++) {
            printAllKLength(prefix + set[i], iterations - 1);
        }
    }
}
