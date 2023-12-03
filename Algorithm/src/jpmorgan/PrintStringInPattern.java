package jpmorgan;

public class PrintStringInPattern {
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
    }
}
