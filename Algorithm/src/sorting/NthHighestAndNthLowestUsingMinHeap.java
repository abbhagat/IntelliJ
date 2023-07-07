package sorting;

import java.util.stream.IntStream;

import static util.Swap.swap;

public class NthHighestAndNthLowestUsingMinHeap {
    private static final int[] a = {10, 4, 6, 9, 2, 1, 5, 8, 7, 3};
    private static int n = a.length - 1;
    private static final int kth = 1;

    public static void buildHeap() {
        for (int i = n / 2; i >= 0; i--) {
            minHeap(i);
        }
    }

    public static void minHeap(int i) {
        int left  = 2 * i;
        int right = 2 * i + 1;
        int smallest = left  <= n && a[left]  < a[i]        ? left  : i;
            smallest = right <= n && a[right] < a[smallest] ? right : smallest;
        if (smallest != i) {
            swap(a, i, smallest);
            minHeap(smallest);
        }
    }

    public static void heapSort() {
        buildHeap();
        for (int i = n; i >= 0; i--) {
            swap(a, 0, i);
            n--;
            if (n == (a.length - kth - 1)) {
                System.out.println(kth + "th Lowest Element " + a[i]);
            }
            if (n == kth - 2) {
                System.out.println(kth + "th Highest Element " + a[i]);
            }
            minHeap(0);
        }
    }

    public static void main(String[] args) {
        heapSort();
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
