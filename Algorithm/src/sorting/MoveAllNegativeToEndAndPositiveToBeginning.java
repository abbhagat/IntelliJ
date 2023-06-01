package sorting;

import java.util.stream.IntStream;

public class MoveAllNegativeToEndAndPositiveToBeginning {

    private static final int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

    private static void move(int low, int high) {
        while (low < high) {
            if (a[low] > 0) {
                low++;
            } else if (a[high] < 0) {
                high--;
            } else if (a[low] < 0 && a[high] > 0) {
                swap(low, high);
                low++;
                high--;
            } else {
                low++;
                high--;
            }
        }
    }

    private static void swap(int x, int y) {
        a[x] = a[x] ^ a[y];
        a[y] = a[x] ^ a[y];
        a[x] = a[x] ^ a[y];
    }

    public static void main(String[] args) {
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
        move(0, a.length - 1);
        System.out.println();
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
