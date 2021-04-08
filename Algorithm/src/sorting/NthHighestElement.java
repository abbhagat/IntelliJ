package sorting;

import java.util.stream.IntStream;

public class NthHighestElement {

    private static int[] a = {20, 3, 16, 6, 9, 30, 2, 1, 5, 8, 7, 15};
    private static int n = a.length -1;
    private static int kth = 4;

    public static void buildheap() {
        for (int i = n / 2; i >= 0; i--) {
            maxheap(i);
        }
    }

    public static void maxheap(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = (left <= n && a[left] > a[i]) ? left : i;
        if (right <= n && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            maxheap(largest);
        }
    }

    public static void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort() {
        buildheap();
        int c = 0;
        for (int i = n; i >= 0; i--) {
            swap(0, i);
            n = n - 1;
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
