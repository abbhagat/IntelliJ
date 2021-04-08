package goldmansach;

import java.util.Arrays;

public class RemovingDuplicatesFromArray {

    public static void main(String[] args) {
        int[] a = new int[] { 1, 3, 7, 7, 100, 120, 100, 8, 10, 1, 2, 3, 8, 9, 9, 9, 10, 100, 120 };
        Arrays.sort(a);
        int current = a[0];
        boolean found = false;

        for (int i = 0; i < a.length; i++) {
            if (current == a[i] && !found) {
                found = true;
            } else if (current != a[i]) {
                System.out.print(" " + current);
                current = a[i];
                found = false;
            }
        }
    }
}
