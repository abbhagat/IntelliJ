package geeksforgeeks;

import java.util.HashSet;
import java.util.Set;

public class BeautifulNumber {

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
        System.out.println(isHappyNumber(31));
        System.out.println(isHappyNumber(32));
        System.out.println(isHappyNumber(33));
    }
}
