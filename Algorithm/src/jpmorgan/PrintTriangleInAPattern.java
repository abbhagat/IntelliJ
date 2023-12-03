package jpmorgan;

public class PrintTriangleInAPattern {
    private static void printPattern(int n) {
        int low = 0, high = n;
        int mid = (low + high) / 2;
        while (low <= mid) {
            for (int i = 0; i <= low; i++) {
                if (low >= 2) {
                    System.out.print(i == 0 || i == low ? "#" : " ");
                } else if (i == 0 || i == 1) {
                    System.out.print("#");
                }
            }
            System.out.println();
            low++;
        }
        while (mid < high) {
            for (int i = mid + 1; i <= high; i++) {
                if (mid >= 2) {
                    System.out.print(i == mid + 1 || i == high ? "#" : " ");
                } else if (i == high || i == high - 1) {
                    System.out.print("#");
                }
            }
            System.out.println();
            high--;
        }
    }

    public static void main(String[] args) {
        printPattern(7);
    }
}
