package amazon;

public class Search {

    private static int pivotedBinarySearch(int[] a, int key) {
        int low = 0, high = a.length - 1;
        int pivot = findPivot(a, low, high, key);
        if (pivot == -1) {
            return binarySearch(a, low, high, key);
        }
        if (a[pivot] == key) {
            return pivot;
        }
        return a[0] > key ? binarySearch(a, pivot + 1, high, key) : binarySearch(a, low, pivot - 1, key);
    }

    private static int findPivot(int[] a, int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (mid < high && a[mid] > a[mid + 1]) {
                return mid;
            }
            if (low < mid && a[mid - 1] > a[mid]) {
                return mid - 1;
            }
            return a[low] > a[mid] ? findPivot(a, mid + 1, high, key) : findPivot(a, low, mid - 1, key);
        }
        return -1;
    }

    private static int binarySearch(int[] a, int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key) {
                return mid;
            }
            return key < a[mid] ? binarySearch(a, low, mid - 1, key) : binarySearch(a, mid + 1, high, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotedBinarySearch(new int[]{4, 5, 6, 7, 1, 2, 3}, 1));
    }
}
