package sorting;

import java.util.stream.IntStream;

import static util.CommonUtils.swap;

public class NthHighestElement {

    private static final int[] a = {20, 3, 16, 6, 9, 30, 2, 1, 5, 8, 7, 15};
    private static int n = a.length - 1;
    private static final int kth = 4;

    public static void buildHeap() {
        for (int i = n / 2; i >= 0; i--) {
            maxheap(i);
        }
    }

    public static void maxheap(int i) {
        int left    = 2 * i;
        int right   = 2 * i + 1;
        int largest = left  <= n && a[left]  > a[i]       ? left : i;
            largest = right <= n && a[right] > a[largest] ? right : largest;
        if (largest != i) {
            swap(a, i, largest);
            maxheap(largest);
        }
    }

    public static void sort() {
        buildHeap();
        int c = 0;
        for (int i = n; i >= 0; i--) {
            swap(a, 0, i);
            n--;
            c++;
            if (c == kth) {
                System.out.println(a[i]);
            }
            maxheap(0);
        }
    }

    public static void main(String[] args) {
        sort();
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
