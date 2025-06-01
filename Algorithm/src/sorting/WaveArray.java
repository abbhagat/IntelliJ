package sorting;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// This function sorts a[0..n-1] a[0] >= a[1] <= a[2] >= a[3] <= a[4]
// Time Complexity: O(N)
// Auxiliary Space: O(1)
public class WaveArray {
    private static void sortInWave(int[] a) {
        for (int i = 0; i < a.length - 1; i += 2) {
            if (i > 0 && a[i - 1] > a[i]) {          // swap odd and even positions
                swap(a, i - 1, i);
            }
            if (i < a.length - 1 && a[i + 1] > a[i]) {
                swap(a, i + 1, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        sortInWave(a);
        printArray(a);
    }
}
