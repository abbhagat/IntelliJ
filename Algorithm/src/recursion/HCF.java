package recursion;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class HCF {

    private static int findGCD(int x, int y) {
        return y == 0 ? x : findGCD(y, x % y);
    }

    public static void main(String[] args) {
        int[] a = {10, 150, 30, 50, 40, 60};
        int hcf = a[0];
        for (int i = 1; i < a.length; i++) {
            hcf = findGCD(min(hcf, a[i]), max(hcf, a[i]));
        }
        System.out.println("HCF := " + hcf);
    }
}
