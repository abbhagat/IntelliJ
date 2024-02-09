package jpmorgan;

public class PrintTriangleInAPattern {
    private static void printPattern(int n) {
        int low = 1, high = n;
        int mid = (low + high) / 2;
        while(low <= mid) {
            for(int i = 1; i <= low; i++) {
                System.out.print((i == 1 || i == low) ? "#" : ' ');
            }
            low++;
            System.out.println();
        }
        while(mid <= high) {
            for(int i = mid + 1; i <= high; i++) {
                System.out.print((i == mid + 1 || i == high) ? "#" : ' ');
            }
            high--;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPattern(5);
        System.out.println();
        printPattern(7);
    }
}
