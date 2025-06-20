package sorting;

import java.util.Arrays;
import static util.CommonUtils.swap;

// Time Complexity O(n^2)
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {20, 3, 15, 6, 9, 8, 2, 1, 6, 8, 7, 15};
        for (int i = 1; i < a.length; i++) {
             int j = i - 1;
             while (j >= 0 && a[j] > a[j + 1]) {
                swap(a, j, j + 1);
                j--;
             }
         }
        System.out.println(Arrays.toString(a));
    }
}
