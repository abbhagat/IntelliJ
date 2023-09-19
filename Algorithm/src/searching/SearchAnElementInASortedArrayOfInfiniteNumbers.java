package searching;

// Time Complexity: O(logN)
// Auxiliary Space: O(1)
public class SearchAnElementInASortedArrayOfInfiniteNumbers {

    private static int search(int[] a, int n) {
        int low = 0, high = 1;
        while (n > a[high]) {
            int t = high + 1;
            high += (high - low + 1) * 2;
            low = t;
        }
        return binarySearch(a, low, high, n);
    }

    private static int binarySearch(int[] a, int low, int high, int n) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (n == a[mid]) {
                return mid;
            }
            return n < a[mid] ? binarySearch(a, low, mid - 1, n) : binarySearch(a, mid + 1, high, n);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}, 10));
        System.out.println(search(new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}, 11));
    }
}
