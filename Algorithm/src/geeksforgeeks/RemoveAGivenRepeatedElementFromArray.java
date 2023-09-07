package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RemoveAGivenRepeatedElementFromArray {
    private static void removeAGivenRepeatedElementFromArray(int[] a, int val) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) {
                list.add(i);
            }
        }
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (!list.contains(i)) {
                a[j++] = a[i];
            }
        }
        while (j < a.length) {
            a[j++] = 0;
        }
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        removeAGivenRepeatedElementFromArray(new int[] {0, 1, 2, 2, 3, 2, 4, 2}, 2);
        removeAGivenRepeatedElementFromArray(new int[] {0, 1, 2, 2, 3, 2, 3, 2}, 3);
    }
}
