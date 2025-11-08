package vmware;

public class ValidPerfectSquare {

    private static boolean isPerfectSquare(int n) {
        long low = 0, high = n;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == n) {
                return true;
            } else if (mid * mid < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}
