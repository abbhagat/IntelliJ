package cisco;

// Given a +ve Integer find min no of perfect square which sum to n
// Time Complexity O(sqrt(n))
// Space Complexity : O(1)
public class PerfectSquares {
    private static boolean isSquare(int n) {
        int sqRoot = (int) Math.sqrt(n);
        return (sqRoot * sqRoot == n);
    }

    private static int cntSquares(int n) {
        // ans = 1 if the number is a perfect square
        if (isSquare(n)) {
            return 1;
        }
        // ans = 2: we check for each i if n - (i * i) is a perfect square
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (isSquare(n - (i * i))) {
                return 2;
            }
        }
        // possible if the number is representable in the form 4^a (8*b + 7)
        while (n % 4 == 0) {
            n >>= 2;
        }
        if (n % 8 == 7) {
            return 4;
        }
        return 3;
    }

    public static void main(String[] args) {
        System.out.println(cntSquares(12));
        System.out.println(cntSquares(13));
    }
}
