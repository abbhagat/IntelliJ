package cisco;

public class PowerOfTwo {

    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    private static boolean isPowerOf2(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2) + " " + isPowerOf2(2));
        System.out.println(isPowerOfTwo(3) + " " + isPowerOf2(3));
        System.out.println(isPowerOfTwo(4) + " " + isPowerOf2(4));
        System.out.println(isPowerOfTwo(16) + " " + isPowerOf2(16));
    }
}
