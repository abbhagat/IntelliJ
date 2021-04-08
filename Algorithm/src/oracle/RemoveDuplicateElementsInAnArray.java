package oracle;

import java.util.Arrays;

public class RemoveDuplicateElementsInAnArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 7, 1, 6, 8, 9, 10, 3000, 6, 3, 5, 10, 2000, 4, 9, 10};
        Arrays.sort(a);
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
        int i = 1;
        for (i = 1; i < a.length; i++) {
            if (a[i - 1] != a[i]) {
                System.out.print(a[i - 1] + " ");
            }
        }
        System.out.println(a[a.length - 1]);
    }
}
