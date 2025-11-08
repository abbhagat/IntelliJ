package geeksforgeeks;

import java.util.stream.IntStream;

import static util.CommonUtils.printArray;

public class RemoveAGivenRepeatedElementFromArray {

    private static void removeAGivenRepeatedElementFromArray(int[] a, int n) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != n) {
                a[j] = a[i];
                j++;
            }
        }
        IntStream.range(j, a.length).forEach(i -> a[i] = 0);
        printArray(a);
    }

    public static void main(String[] args) {
        removeAGivenRepeatedElementFromArray(new int[]{0, 1, 2, 2, 3, 2, 4, 2}, 2);
        removeAGivenRepeatedElementFromArray(new int[]{0, 1, 2, 2, 3, 2, 3, 2}, 3);
        removeAGivenRepeatedElementFromArray(new int[]{3, 2, 2, 3}, 3);
    }
}
