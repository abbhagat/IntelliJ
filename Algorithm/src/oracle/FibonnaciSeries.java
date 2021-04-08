package oracle;

public class FibonnaciSeries {

    private static void fibonnaci(int f, int s, int iteration) {
        if (iteration != 10) {
            System.out.print((f + s) + " ");
            fibonnaci(s, (f + s), ++iteration);
        }
    }

    public static void main(String[] args) {
        System.out.print(0 + " " + 1 + " ");
        fibonnaci(0, 1, 2);
        System.out.println();
    }
}
