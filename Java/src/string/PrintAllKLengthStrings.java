package string;

public class PrintAllKLengthStrings {

    public static void main(String[] args) {
        char set[] = {'A', 'B', 'C'};
        printAllKLength("", set, set.length);
    }

    private static void printAllKLength(String s, char[] set, int iterations) {
        if (iterations == 0) {
            System.out.println(s);
        } else {
            for (int i = 0; i < set.length; i++) {
                printAllKLength(s + set[i], set, iterations - 1);
            }
        }
    }
}
