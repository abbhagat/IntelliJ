package arrays;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveArray {

    private char[] a = {'A', 'B', 'B', 'C', 'D', 'E', 'R', 'R', 'D', 'X', 'Y', 'Z'};
    private Set<Character> hs = new HashSet<>();

    private void displayConsecutiveArray() {
        for (int i = 1; i < a.length; i++) {
            if (Math.abs(a[i - 1] - a[i]) == 1) {
                hs.add(a[i - 1]);
                hs.add(a[i]);
            }
        }
    }

    public static void main(String[] args) {
        ConsecutiveArray c = new ConsecutiveArray();
        c.displayConsecutiveArray();
        c.hs.forEach(k -> System.out.print(k + " "));
    }
}
