package jpmorgan;

// Time Complexity:- O(n^2)
public class PrintTriangleInPattern {

    private static void printPattern(int n) {
        int low = 1, high = n, mid = n / 2;
        while (low <= mid) {
            for (int i = 1; i <= low; i++) {
                 System.out.print("*");
            }
            System.out.println();
            low++;
        }
        while (mid <= high) {
            for (int i = mid + 1; i <= high; i++) {
                 System.out.print("*");
            }
            System.out.println();
            high--;
        }
    }

    public static void main(String[] args) {
        printPattern(5);
        System.out.println();
        printPattern(7);
    }
}
