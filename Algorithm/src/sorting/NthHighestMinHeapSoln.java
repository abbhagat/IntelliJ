package sorting;

public class NthHighestMinHeapSoln {
    private static int[] a = { 20, 3, 16, 6, 9, 30, 2, 1, 5, 8, 7, 15 };
    private static int n, left, right, smallest;
    private static int kth = 1;

    public static void buildheap() {
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            minHeap(i);
        }
    }

    public static void minHeap(int i) {
        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && a[left] < a[i]) {
            smallest = left;
        } else {
            smallest = i;
        }
        if (right <= n && a[right] < a[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            minHeap(smallest);
        }
    }

    public static void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort() {
        buildheap();
        for (int i = n; i >= 0; i--) {
            swap(0, i);
            n = n - 1;
            if (i == kth) {
                System.out.println(a[i]);
            }
            minHeap(0);
        }
    }

    public static void main(String[] args) {
        sort();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
