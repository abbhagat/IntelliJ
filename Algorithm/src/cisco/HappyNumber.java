package cisco;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> seen = new HashSet();
        seen.add(n);
        int result = 0;
        while (result != 1) {
            result = getResult(n);
            if (seen.contains(result)) {
                return false;
            }
            seen.add(result);
            n = result;
        }
        return true;
    }

    private static Integer getResult(int num) {
        int result = 0;
        while (num != 0) {
            result += (num % 10) * (num % 10);
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(10));
    }
}
