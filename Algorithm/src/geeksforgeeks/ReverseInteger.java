package geeksforgeeks;

public class ReverseInteger {

    public static void main(String[] args) {
        int n = 1534236469;
        boolean isPositive = n > 0 ? true : false;
        n = isPositive ? n : n * -1;
        long rev = 0;
        while (n != 0) {
            int k = n % 10;
            rev = rev * 10 + k;
            n /= 10;
        }
        System.out.println(isPositive ? rev : rev * -1);
    }
}
