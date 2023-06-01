package gfg;

import java.util.Arrays;

import static java.lang.Math.abs;

public class ClosestToZero {

    public static void main(String[] args) {
        int[] a = {1, 7, 9, 4, 2, -1};
        int closest = a[0];
        Arrays.sort(a);
        for (int x : a) {
            closest = abs(x) <= abs(closest) ? x : closest; // closest to 0
        }
        System.out.println(closest);
    }
}
