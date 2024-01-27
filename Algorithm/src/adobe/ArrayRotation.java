package adobe;

import java.util.stream.IntStream;

import static util.CommonUtils.swap;

public class ArrayRotation {

    private static void arrayRotate(int[] a, int k) {
        k = k % a.length;
        int n = a.length - k;
        rotate(a, 0, n - 1);
        rotate(a, n, a.length - 1);
        rotate(a, 0, a.length - 1);
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }

    private static void rotate(int[] a, int i, int j) {
        while (i <= j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        arrayRotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);  // 5 6 7 1 2 3 4
        System.out.println();
        arrayRotate(new int[]{1, 2, 3, 4, 5}, 2);       // 4 5 1 2 3
    }
}
