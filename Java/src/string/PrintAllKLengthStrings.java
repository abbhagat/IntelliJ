package string;

public class PrintAllKLengthStrings {

    static char set[] = {'A', 'B', 'C'};

    public static void main(String[] args) {
        printAllKLength("", set.length);
    }

    private static void printAllKLength(String s, int iterations) {
        if (iterations == 0) {
            System.out.println(s);
        } else {
            for (int i = 0; i < set.length; i++) {
                printAllKLength(s + set[i], iterations - 1);
            }
        }

    }
}
