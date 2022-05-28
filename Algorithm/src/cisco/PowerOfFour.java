package cisco;

public class PowerOfFour {

    private static boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }

    private static boolean isPowerOf4(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(4) + " " + isPowerOf4(4));
        System.out.println(isPowerOfFour(14) + " " + isPowerOf4(14));
        System.out.println(isPowerOfFour(16) + " " + isPowerOf4(16));
        System.out.println(isPowerOfFour(64) + " " + isPowerOf4(64));
    }
}
