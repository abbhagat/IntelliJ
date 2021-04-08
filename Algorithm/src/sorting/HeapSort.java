package sorting;

import java.util.stream.IntStream;

public class HeapSort {

    private static int[] a = {3, 8, 1, 9, 4, 2, 6, 7, 10, 5};
    private static int n = a.length - 1;

    private static void buildHeap() {
        for (int i = n / 2; i >= 0; i--) {
            maxHeap(i);
        }
    }

    private static void maxHeap(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = (left <= n && a[left] > a[i]) ? left : i;
        largest = (right <= n && a[right] > a[largest]) ? right : largest;
        if (i != largest) {
            swap(i, largest);
            maxHeap(largest);
        }
    }

    private static void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void heapSort() {
        buildHeap();
        for (int i = n; i >= 0; i--) {
            swap(0, i);
            n--;
            maxHeap(0);
        }
    }

    public static void main(String[] args) {
        heapSort();
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
