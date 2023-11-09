package sorting;

import java.util.stream.IntStream;

import static util.Swap.swap;

public class SortArrayWithZeroOneTwoWithoutCalculatingArrayLength {

    private static void sort(int[] a, int startIdx, int value) {
        int i = startIdx, j = startIdx;
        while (true) {
            try {
                if (a[i] == value) {
                    swap(a, i, j);
                    j++;
                }
                i++;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
    }

    private static void sort(int[] a) {
        int c0, c1, c2, i;
        c0 = c1 = c2 = i = 0;
        while (true) {
            try {
                switch (a[i]) {
                    case 0:
                        c0++;
                        break;
                    case 1:
                        c1++;
                        break;
                    case 2:
                        c2++;
                        break;
                }
                i++;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        int n = c0 + c1 + c2;
        for (i = 0; i < n; i++) {
            if (i < c0) {
                a[i] = 0;
            } else if (i < c0 + c1) {
                a[i] = 1;
            } else {
                a[i] = 2;
            }
        }
        IntStream.range(0, n).forEach(j -> System.out.print(a[j] + " "));
    }

    public static void main(String[] args) {
        sort(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1});
        /*sort(0, 0);
        int k = 0;
        for (int x : a) {
            if (x == 0) {
                k++;
            } else {
                break;
            }
        }
        sort(k, 1);
        for (int x : a) {
            System.out.print(x + " ");
        }*/
    }
}
