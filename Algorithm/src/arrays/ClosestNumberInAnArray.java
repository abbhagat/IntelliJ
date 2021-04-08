package arrays;

import java.util.Arrays;

import static java.lang.Math.abs;

public class ClosestNumberInAnArray {

    public static void main(String[] args) {
        int[] a = {-1, 7, 9, 4, 2, 1};
        int k = 0;
        Arrays.sort(a);
        int near = a[0];
        for (int i = 1; i < a.length; i++) {
            if (abs(near - k) >= abs(a[i] - k)) {
                near = a[i];
            }
        }
        System.out.println(near);
    }
}
