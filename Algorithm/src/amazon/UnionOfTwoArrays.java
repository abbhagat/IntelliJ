package amazon;

import java.util.Arrays;

public class UnionOfTwoArrays {

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 7, 1, 8, 9, 5, 10};
        int[] b = {1, 2, 6, 8, 4, 9, 3, 10, 7, 19, 20};
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println("Intersection ");
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                System.out.print(a[i] + " ");
            }
            i++;
            j++;
        }
        i = 0;
        j = 0;
        System.out.println();
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                System.out.print(a[i] + " ");
                i++;
                j++;
            } else {
                System.out.print(a[i] < b[j] ? a[i++] + " " : b[j++] + " ");
            }
        }
        while (i < a.length) {
            System.out.print(a[i++] + " ");
        }
        while (j < b.length) {
            System.out.print(b[j++] + " ");
        }
    }
}
