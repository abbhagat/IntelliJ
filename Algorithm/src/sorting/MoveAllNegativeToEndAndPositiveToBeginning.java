package sorting;

import java.util.stream.IntStream;
import static util.CommonUtils.swap;

public class MoveAllNegativeToEndAndPositiveToBeginning {

    private static void move(int[] a) {
        int i = 0, j = a.length - 1;
        while (i < j) {
            if (a[i] > 0) {
                i++;
            } else if (a[j] < 0) {
                j--;
            } else {
                swap(a, i, j);
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        move(a);
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
