package geeks;

import java.util.stream.IntStream;

public class SortArrayWithZeroOneTwoWithoutCalculatingArrayLength2 {

    private static int[] a = {0, 1, 1, 0, 1, 0, 0, 0, 0, 1};

    private static void swap(int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static void sort(int low, int high) {
        while (low <= high) {
            if (a[low] == 0 && a[high] == 0) {
                low++;
            } else if (a[low] == 1 && a[high] == 1) {
                high--;
            } else if (a[low] == 0 && a[high] == 1) {
                low++;
                high--;
            } else if (a[low] == 1 && a[high] == 0) {
                swap(low, high);
                low++;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        sort(0, a.length - 1);
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
