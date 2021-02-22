package sorting;

public class NthHighestElement {

    private static int[] a = {1, 3, 6, 5, 2, 7, 8, 9, 10, 4};
    private static int n = a.length - 1;

    private static void buildMaxHeap() {
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

    private static void swap(int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    private static int maxHeapSort(int nth) {
        buildMaxHeap();
        int c = 0;
        for (int i = n; i >= 0; i--) {
            swap(0, i);
            c++;
            if (c == nth) {
                return a[c];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(maxHeapSort(3));
    }
}
