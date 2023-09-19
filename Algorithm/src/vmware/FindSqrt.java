package vmware;

public class FindSqrt {

    private static int findSqrt(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            int square  = mid * mid;
            if (square == n) {
                return mid;
            } else if (square > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(findSqrt(2));
        System.out.println(findSqrt(4));
        System.out.println(findSqrt(8));
        System.out.println(findSqrt(16));
    }
}
