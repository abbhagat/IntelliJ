package geeksforgeeks;

import java.util.HashSet;
import java.util.Set;

public class BeautifulNumber {

    private static boolean isBeautiful(int n) {
        if (n == 1) {
            return true;
        }
        int sum = sum(n);
        return sum > 1 && sum < 10 ? false : isBeautiful(sum);
    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int m = n;
        while (true) {
            n = sum(sum(n));
            m = sum(m);
            if (m == 1 || n == 1) {
                return true;
            }
            if (m == n) {
                return false;
            }
        }
    }

    public static boolean isHappyNumber(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int sum = 0;
        while (sum != 1) {
            sum = sum(n);
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
        return true;
    }

    private static int sum(int n) {
        int sum = 0;
        while (n != 0) {
            int k = n % 10;
            sum += k * k;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isBeautiful(31) + "\t" + isHappy(31) + "\t" + isHappyNumber(31));
        System.out.println(isBeautiful(32) + "\t" + isHappy(32) + "\t" + isHappyNumber(32));
        System.out.println(isBeautiful(33) + "\t" + isHappy(33) + "\t" + isHappyNumber(33));
    }
}
