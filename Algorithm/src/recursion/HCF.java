package recursion;

import static java.lang.Integer.max;

public class HCF {

    private static int findHCF(int x, int y) {
        return y == 0 ? x : findHCF(y, x % y);
    }

    private static int findGCD(int x, int y) {
        int hcf = 0;
        for (int i = 1; i <= max(x,y); i++) {
            if (x % i == 0 && y % i == 0)
                hcf = i;
        }
        return hcf;
    }

    public static void main(String[] args) {
        int[] a = {10, 150, 30, 50, 40, 60};
        int hcf = a[0];
        for (int i = 1; i < a.length; i++) {
            hcf = findHCF(hcf, a[i]);
        }
        System.out.println("HCF := " + hcf);
        System.out.println(findHCF(0,5) + "\t" + findGCD(0,5));
        System.out.println(findHCF(5,0) + "\t" + findGCD(5,0));
    }
}
