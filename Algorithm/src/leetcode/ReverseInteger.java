package leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = 1534236469;
        boolean isPositive = x > 0 ? true : false;
        x = isPositive ? x : x * -1;
        long rev = 0;
        while (x != 0) {
            int n = x % 10;
            rev = rev * 10 + n;
            x /= 10;
        }
        System.out.println(isPositive ? rev : rev * -1);
    }
}
