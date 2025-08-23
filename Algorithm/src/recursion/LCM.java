package recursion;

import static java.lang.Math.max;
import static java.lang.Math.min;

// Time  Complexity: O(x*y)
// Space Complexity: O(x*y)
public class LCM {

                               // HCF * LCM = a * b

    private static int findLCM(int x, int y, int lcm) {
        return (lcm % x == 0 && lcm % y == 0) ? lcm : findLCM(x, y, lcm + y);
    }

    private static void findLCM(int[] a) {
        int lcm = a[0];
        for (int i = 1; i < a.length; i++) {
            lcm = findLCM(min(a[i], lcm), max(a[i], lcm), max(a[i], lcm));
        }
        System.out.println("LCM := " + lcm);
    }

    public static void main(String[] args) {
        findLCM(new int[]{10, 15, 45});
        findLCM(new int[]{1, 2, 8, 3});
        findLCM(new int[]{2, 7, 3, 9, 4});
    }
}
