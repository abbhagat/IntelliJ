package sorting;

import java.util.stream.IntStream;

import static util.Swap.swap;

public class MoveAllPositiveToEndAndNegativeToBeginning {

    private static void move(int[] a) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            if (a[low] < 0) {
                low++;
            } else if (a[high] > 0) {
                high--;
            } else {
                if (a[low] > 0 && a[high] < 0) {
                    swap(a, low, high);
                }
                low++;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
        move(a);
        System.out.println();
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
