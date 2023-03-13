package cisco;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet();
        set.add(n);
        int result = 0;
        while (result != 1) {
            result = getResult(n);
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            n = result;
        }
        return true;
    }

    private static int getResult(int n) {
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
