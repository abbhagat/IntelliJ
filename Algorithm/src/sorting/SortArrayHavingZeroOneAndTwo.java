package sorting;

import java.util.stream.IntStream;

/**
 * Dutch National Flag Algorithm OR 3-way Partitioning:
 * At first,the full array is unknown.
 * There are three indices – low, mid and high. Initially, the value of low = mid = 0 and high = a.length -1.
 * If the ith element is 0 then swap the element to the low range, thus shrinking the unknown range.
 * Similarly, if the element is 1 then keep it as it is but shrink the unknown range.
 * If the element is 2 then swap it with an element in high range.
 * <p>
 * Time Complexity: O(n)
 */
public class SortArrayHavingZeroOneAndTwo {

    private static int[] a = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

    private static void sort(int low, int mid, int high) {
        while (mid <= high) {
            if (a[mid] == 0) {
                swap(low, mid);
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else if (a[mid] == 2) {
                swap(mid, high);
                high--;
            }
        }
    }

    private static void swap(int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        sort(0, 0, a.length - 1);
        IntStream.range(0, a.length - 1).forEach(i -> System.out.print(a[i] + " "));
    }
}
