package geeks;

import java.util.stream.IntStream;

public class MoveAllNegativeToEndAndPositiveToBeginning {

    private static int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

    private static void move(int low, int high) {
        while (low <= high) {
            if (a[low] > 0 && a[high] > 0) {
                low++;
            } else if (a[low] < 0 && a[high] < 0) {
                high--;
            } else if (a[low] < 0 && a[high] > 0) {
                int t = a[low];
                a[low] = a[high];
                a[high] = t;
                low++;
                high--;
            } else {
                low++;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
        move(0, a.length - 1);
        System.out.println();
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
