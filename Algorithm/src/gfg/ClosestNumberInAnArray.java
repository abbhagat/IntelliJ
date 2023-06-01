package gfg;

import static java.lang.Math.abs;

public class ClosestNumberInAnArray {

    public static void main(String[] args) {
        int[] a = {3, 2, 9, 4, 10, 1, 7};
        int closest = a[0], k = 8;
        for (int x : a) {
            closest = abs(k - x) <= abs(k - closest) ? x : closest;
        }
        System.out.println(closest);
    }
}
