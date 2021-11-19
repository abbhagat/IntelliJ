package vmware;

import java.util.stream.IntStream;

public class ReArrangeArrayToOddEvenPlace {

    private static void reArrangeArrayToOddEvenPlace(int[] a) {
        int i = 0, j = 1;
        while (i < a.length - 1 && j < a.length) {
            if (a[i] % 2 == 1) {
                i += 2;
            } else {
                if (a[j] % 2 == 1) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                } else {
                    j += 2;
                }
            }
        }
        IntStream.range(0, a.length).forEach(k -> System.out.print(a[k] + " "));
    }

    public static void main(String[] args) {
        reArrangeArrayToOddEvenPlace(new int[]{2, 1, 3, 4, 7, 9, 24, 98});
        System.out.println();
        reArrangeArrayToOddEvenPlace(new int[]{2, 1, 5, 6});
    }
}
