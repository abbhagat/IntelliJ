package geeksforgeeks;

import java.util.stream.IntStream;

public class RemoveAGivenRepeatedElementFromArray {
    private static void removeAGivenRepeatedElementFromArray(int[] a, int n) {
        int i = 0, j = 0;
        while (i < a.length) {
            if (a[i] == n) {
                i++;
            } else {
                a[j++] = a[i++];
            }
        }
        IntStream.range(j, a.length).forEach(k -> a[k] = 0);
        IntStream.range(0, a.length).forEach(k -> System.out.print(a[k] + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        removeAGivenRepeatedElementFromArray(new int[]{0, 1, 2, 2, 3, 2, 4, 2}, 2);
        removeAGivenRepeatedElementFromArray(new int[]{0, 1, 2, 2, 3, 2, 3, 2}, 3);
        removeAGivenRepeatedElementFromArray(new int[]{3, 2, 2, 3}, 3);
    }
}
