package jpmorgan;

public class PrintStringInPattern {

    public static void printPatterns(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printPattern(int n) {
        int low = 0, high = n;
        int mid = (low + high - 1) / 2;
        while (low <= mid) {
            for (int i = 0; i <= low; i++) {
                System.out.print("*");
            }
            System.out.println();
            low++;
        }
        while (mid < high) {
            for (int i = mid + 1; i < high; i++) {
                System.out.print("*");
            }
            System.out.println();
            high--;
        }
    }

    public static void main(String[] args) {
        printPattern(7);
        printPattern(1);
        printPattern(4);
        printPatterns(3);
    }
}
