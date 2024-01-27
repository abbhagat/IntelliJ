package oracle;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveDuplicateElementsInAnArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 7, 1, 6, 8, 9, 10, 3000, 6, 3, 5, 10, 2000, 4, 9, 10};
        Arrays.sort(a);
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
        System.out.println();
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] != a[i]) {
                System.out.print(a[i - 1] + " ");
            }
        }
        System.out.println(a[a.length - 1]);
    }
}
