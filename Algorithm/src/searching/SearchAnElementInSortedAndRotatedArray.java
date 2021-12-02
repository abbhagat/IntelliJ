package searching;

// Time Complexity: O(log n)
// Space Complexity:O(1), No extra space is required.

public class SearchAnElementInSortedAndRotatedArray {

    private static int pivotedBinarySearch(int[] a, int n, int key) {
        int pivot = findPivot(a, 0, n - 1);
        if (pivot == -1) {
            return binarySearch(a, 0, n - 1, key);
        }
        if (a[pivot] == key) {
            return pivot;
        }
        return a[0] <= key ? binarySearch(a, 0, pivot - 1, key) : binarySearch(a, pivot + 1, n - 1, key);
    }

    private static int findPivot(int[] a, int low, int high) {
        if(low <= high) {
            int mid = (low + high) / 2;
            if (mid < high && a[mid] > a[mid + 1]) {
                return mid;
            }
            if (mid > low && a[mid] < a[mid - 1]) {
                return mid - 1;
            }
            return a[mid] <= a[low] ? findPivot(a, low, mid - 1) : findPivot(a, mid + 1, high);
        }
        return -1;
    }

    private static int binarySearch(int[] a, int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (key == a[mid]) {
                return mid;
            }
            return key > a[mid] ? binarySearch(a, (mid + 1), high, key) : binarySearch(a, low, (mid - 1), key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(pivotedBinarySearch(a, a.length, 3));
        System.out.println(pivotedBinarySearch(a, a.length, 5));
        System.out.println(pivotedBinarySearch(a, a.length, 9));
    }
}
