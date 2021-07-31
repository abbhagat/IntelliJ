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

    private static int getMedian(int[] a, int[] b) {
        int i = 0, j = 0, m = -1, n = -1;
        if ((a.length + b.length) % 2 == 1) {
            for (int k = 0; k <= (a.length + b.length) / 2; k++) {
                if (i != a.length && j != b.length) {
                    m = (a[i] > b[j]) ? b[j++] : a[i++];
                } else {
                    m = i < a.length ? a[i++] : b[j++];
                }
            }
            return m;
        } else {
            for (int k = 0; k <= (a.length + b.length) / 2; k++) {
                n = m;
                if (i != a.length && j != b.length) {
                    m = (a[i] > b[j]) ? b[j++] : a[i++];
                } else {
                    m = i < a.length ? a[i++] : b[j++];
                }
            }
            return (m + n) / 2;
        }
    }

    private static int findMedian(int[] a, int[] b) {
        int i = 0, j = 0, median = 0;
        for (int k = 0; k <= (a.length + b.length) / 2; k++) {
            if (i != a.length && j != b.length) {
                median = (a[i] > b[j]) ? b[j++] : a[i++];
            } else {
                median = i < a.length ? a[i++] : b[j++];
            }
        }
        return median;
    }

    public static void main(String[] args) {
        System.out.println(getMedian(new int[]{900}, new int[]{5, 8, 10, 20}));
        System.out.println(getMedian(new int[]{-5, 3, 6, 12, 15}, new int[]{-12, -10, -6, -3, 4, 10}));
        System.out.println(getMedian(new int[]{2, 3, 5, 8}, new int[]{10, 12, 14, 16, 18, 20}));
    }
}
