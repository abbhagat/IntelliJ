package arrays;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveArray {

    public static void main(String[] args) {
        char[] a = {'A', 'B', 'B', 'C', 'D', 'E', 'R', 'R', 'D', 'X', 'Y', 'Z'};
        Set<Character> hs = new HashSet<>();
        for (int i = 1; i < a.length; i++) {
            if (Math.abs(a[i - 1] - a[i]) == 1) {
                hs.add(a[i - 1]);
                hs.add(a[i]);
            }
        }
        hs.forEach(k -> System.out.print(k + " "));
    }
}
