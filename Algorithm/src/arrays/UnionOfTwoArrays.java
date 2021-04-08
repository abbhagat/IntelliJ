package goldmansach;

import java.util.Arrays;

public class UnionOfTwoArrays {

    public static void main(String[] args) {
        int a[] = { 1, 3, 5, 12, 1, 12, 2 };
        int b[] = { 1, 2, 4, 1, 2, 12, };
        int i = 0, j = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else if (a[i] > b[j]) {
                System.out.print(b[j] + " ");
                j++;
            } else {
                //System.out.print(a[i] + " ");
                i++;
                j++;
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
