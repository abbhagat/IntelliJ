package geeksforgeeks;

// Time Complexity : O(log n + log m)
// median = (i < a.length && j < b.length) ? a[i] < b[j]  ? a[i++] : b[j++] : i < a.length ? a[i++] : b[j++];
public class MedianOfTwoArrays {

    private static float findMedian(int[] a, int[] b) {
        float median = 0, prev_median = 0;
        int l = a.length + b.length;
        for (int i = 0, j = 0, k = 0; k <= l / 2; k++) {
            prev_median = median;
            if (i < a.length && j < b.length) {
                median = a[i] < b[j]  ? a[i++] : b[j++];
            } else {
                median = i < a.length ? a[i++] : b[j++];
            }
        }
        return l % 2 == 0 ? (median + prev_median) / 2 : median;
    }

    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{1, 2},   new int[]{3}));
        System.out.println(findMedian(new int[]{1, 2},   new int[]{3, 4}));
        System.out.println(findMedian(new int[]{10, 20}, new int[]{30, 40}));
    }
}
