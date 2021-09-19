package geeksforgeeks;

/**
 * Given two sorted arrays, a[] and b[], the task is to find the median of these sorted arrays, in O(log n + log m) time complexity,
 * when n is the number of elements in the first array, and m is the number of elements in the second array.
 * <p>
 * Input: a[] = {-5, 3, 6, 12, 15}
 * b[] = {-12, -10, -6, -3, 4, 10}
 * Output : The median is 3.
 * Explanation : The merged array is : ar3[] = {-12, -10, -6, -5 , -3, 3, 4, 6, 10, 12, 15},
 * So the median of the merged array is 3
 * <p>
 * Input: a[] = {2, 3, 5, 8}
 * b[] = {10, 12, 14, 16, 18, 20}
 * Output : The median is 11.
 * Explanation : The merged array is :
 * ar3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
 * if the number of the elements are even,  so there are two middle elements, take the average between the two :
 * (10 + 12) / 2 = 11.
 */
public class MedianOfTwoArrays {

    private static int findMedian(int[] a, int[] b) {
        int median = 0, prev_median = 0;
        int l = a.length + b.length;
        for (int i = 0, j = 0, k = 0; k <= l / 2; k++) {
            prev_median = median;
            if (i != a.length && j != b.length) {
                median = a[i] < b[j] ? a[i++] : b[j++];
            } else {
                median = i < a.length ? a[i++] : b[j++];
            }
        }
        return l % 2 == 0 ? (median + prev_median) / 2 : median;
    }

    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{10, 20}, new int[]{30, 40}));
    }
}
