package geeksforgeeks;

import java.util.stream.IntStream;

public class RemoveAGivenRepeatedElementFromArray {
    private static void removeAGivenRepeatedElementFromArray(int[] a, int val) {
        int i = 0, j = 0;
        while (i < a.length) {
            if (a[i] == val) {
                i++;
            } else {
                a[j++] = a[i++];
            }
        }
        while (j < a.length) {
            a[j++] = 0;
        }
        IntStream.range(0, a.length).forEach(k -> System.out.print(a[k] + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        removeAGivenRepeatedElementFromArray(new int[]{0, 1, 2, 2, 3, 2, 4, 2}, 2);
        removeAGivenRepeatedElementFromArray(new int[]{0, 1, 2, 2, 3, 2, 3, 2}, 3);
        removeAGivenRepeatedElementFromArray(new int[]{3, 2, 2, 3}, 3);
    }
}
