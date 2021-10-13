package vmware;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 7, 1, 8, 9, 5, 10};
        int[] b = {1, 2, 6, 8, 4, 9, 3, 10, 7};
        int[] c = new int[a.length + b.length];
        Arrays.sort(a);
        Arrays.sort(b);
        int i, j, k;
        i = j = k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                c[k] = a[i];
                i++;
                j++;
                k++;
            } else {
                c[k] = a[i] < b[j] ? a[i++] : b[j++];
                k++;
            }
        }
        IntStream.range(0, k).forEach(l -> System.out.print(c[l] + " "));
    }
}