package cisco;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
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
        int result = 0;
        while (n != 0) {
            int k = n % 10;
            result += Math.pow(k, 2);
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(10));
        System.out.println(isHappy(30));
        System.out.println(isHappy(31));
        System.out.println(isHappy(32));
    }
}
