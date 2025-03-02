package sorting;

import java.util.stream.IntStream;
import static util.CommonUtils.swap;

/*
 * This can be done in linear time, with no extra space.
 * We do a linear based insertion sort, but do it twice, once for 0, and once for 1
 */
public class SortArrayWithZeroAndOneWithoutCalculatingArrayLength {
    private static void sort(int[] a) {
        int i = 0, j = 0;
        while (true) {
            try {
                if (a[i] == 0) {
                    swap(a, i, j);
                    j++;
                }
                i++;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        final int[] a = {0, 0, 1, 0, 1, 0, 0, 0, 1, 1};
        sort(a);
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
