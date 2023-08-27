package searching;

// Time Complexity: O(log n)
// Space Complexity:O(1), No extra space is required.

public class SearchAnElementInSortedAndRotatedArray {

    private static int pivotedBinarySearch(int[] a, int key) {
        int low = 0, high = a.length - 1;
        int pivot = findPivot(a, low, high);
        if (pivot == high) {
            return binarySearch(a, low, high, key);
        }
        if (a[pivot] == key) {
            return pivot;
        }
        return a[low] > key ? binarySearch(a, pivot + 1, high, key) : binarySearch(a, low, pivot - 1, key);
    }

    private static int findPivot(int[] a, int low, int high) {
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == a[high]) {
                high--;
            } else if (a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[low] > a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return mid;
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
        int[] a = {4, 5, 1, 2, 3};
        System.out.println(pivotedBinarySearch(a, 3));
        System.out.println(pivotedBinarySearch(a, 5));
        System.out.println(pivotedBinarySearch(a, 1));
        System.out.println(pivotedBinarySearch(a, 9));
    }
}
