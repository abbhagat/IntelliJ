package geeksforgeeks;

public class ReverseInteger {

    private static long reverse(long n) {
        boolean isPositive = n > 0;
        n = isPositive ? n : n * -1;
        long rev = 0;
        while (n != 0) {
            long k = n % 10;
            rev = rev * 10 + k;
            n /= 10;
        }
        return isPositive ? rev : rev * -1;
    }

    public static void main(String[] args) {
        System.out.println(reverse( 1534236469));
        System.out.println(reverse(-1534236469));
    }
}
