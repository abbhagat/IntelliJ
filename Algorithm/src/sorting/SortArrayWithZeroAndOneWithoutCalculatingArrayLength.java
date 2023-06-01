package sorting;

import java.util.stream.IntStream;

/*
 * This can be done in linear time, with no extra space.
 * We do a linear based insertion sort, but do it twice, once for 0, and once for 1
 */
public class SortArrayWithZeroAndOneWithoutCalculatingArrayLength {

    private static final int[] a = {0, 0, 1, 0, 1, 0, 0, 0, 1, 1};

    private static void swap(int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static void sort() {
        for (int i = 0, j = 0; true; i++) {
            try {
                if (a[i] == 0) {
                    swap(i, j);
                    j++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        sort();
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
