package vmware;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class MaxMinWithMinComparison {

    private static void findMinMax(int[] a) {
        int n = a.length, min = a[0], max = a[0], i;
        if (n % 2 == 0) {
            max = max(a[0], a[1]);
            min = min(a[0], a[1]);
            i = 2;
        } else {
            i = 1;
        }
        while (i < n - 1) {
            if (a[i] > a[i + 1]) {
                max = max(max, a[i]);
                min = min(min, a[i + 1]);
            } else {
                max = max(max, a[i + 1]);
                min = min(min, a[i]);
            }
            i += 2;
        }
        System.out.println("Max : " + max + "  Min : " + min);
    }

    public static void main(String[] args) {
        findMinMax(new int[]{1, 2, 3, 4, 5});
        findMinMax(new int[]{10, 59, 33, 40, 21});
    }
}
