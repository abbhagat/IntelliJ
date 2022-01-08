package searching;

// Time Complexity: O(log n)
// Space Complexity:O(1), No extra space is required.

public class SearchAnElementInSortedAndRotatedArray {

    private static int pivotedBinarySearch(int[] a, int low, int high, int key) {
        int pivot = findPivot(a, low, high);
        if (pivot == -1) {
            return binarySearch(a, low, high, key);
        }
        if (a[pivot] == key) {
            return pivot;
        }
        return key < a[0] ? binarySearch(a, pivot + 1, high, key) : binarySearch(a, low, pivot - 1, key);
    }

    private static int findPivot(int[] a, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > a[mid + 1]) {
                return mid;
            }
            return a[mid] >= a[mid + 1] ? findPivot(a, low, mid - 1) : findPivot(a, mid + 1, high);
        }
        return -1;
    }

    private static int binarySearch(int[] a, int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (key == a[mid]) {
                return mid;
            }
            return key < a[mid] ? binarySearch(a, low, mid - 1, key) : binarySearch(a, mid + 1, high, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(pivotedBinarySearch(a, 0, a.length - 1, 3));
        System.out.println(pivotedBinarySearch(a, 0, a.length - 1, 5));
        System.out.println(pivotedBinarySearch(a, 0, a.length - 1, 9));
    }
}
