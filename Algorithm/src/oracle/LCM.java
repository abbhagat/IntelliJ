package oracle;


// HCF * LCM = a * b

import static java.lang.Math.max;

public class LCM {

    private static int findLCM(int x, int y, int lcm) {
        return (lcm % x == 0 && lcm % y == 0) ? lcm : findLCM(x, y, ++lcm);
    }

    public static void main(String[] args) {
        int[] a = {10, 15 , 45};
        int lcm = a[0];
        for (int i = 1; i < a.length; i++) {
            lcm = findLCM(lcm, a[i], max(lcm, a[i]));
        }
        System.out.println("LCM := " + lcm);
    }
}
