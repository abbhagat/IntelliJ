package sorting;

import java.util.stream.IntStream;

import static util.Swap.swap;

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
    private static void sort(int[] a) {
        int low = 0, mid = 0, high = a.length - 1;
        while (mid <= high) {
            switch (a[mid]) {
                case 0: swap(a, low, mid);
                        low++;
                        mid++;
                        break;
                case 1: mid++;
                        break;
                case 2: swap(a, mid, high);
                        high--;
                        break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort(a);
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
