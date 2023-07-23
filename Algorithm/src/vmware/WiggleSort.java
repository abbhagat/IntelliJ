package vmware;

import java.util.stream.IntStream;

import static util.Swap.swap;

public class WiggleSort {

    private static void wiggleSort(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            if ((i % 2 == 0) == (a[i] > a[i + 1])) {
                swap(a, i, i + 1);
            }
        }
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }

    public static void main(String[] args) {
        wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
    }
}
