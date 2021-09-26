package cisco;

import java.util.Arrays;

import static java.lang.Math.abs;

public class ClosestToZero {

    public static void main(String[] args) {
        int[] a = {1, 7, 9, 4, 2, -1};
        int near = a[0];
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (abs(near) >= abs(a[i])) {
                near = a[i];
            }
        }
        System.out.println(near);
    }
}
