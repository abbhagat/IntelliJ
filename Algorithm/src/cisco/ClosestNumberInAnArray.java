package cisco;

import java.util.Arrays;

import static java.lang.Math.abs;

public class ClosestNumberInAnArray {

    public static void main(String[] args) {
        int[] a = {-1, 1, 2, 4, 7, 9};
        int k = 0;
        Arrays.sort(a);
        int closest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (abs(closest - k) >= abs(a[i] - k)) {
                closest = a[i];
            }
        }
        System.out.println(closest);
    }
}
