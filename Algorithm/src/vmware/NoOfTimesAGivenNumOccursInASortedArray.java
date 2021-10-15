package vmware;

public class NoOfTimesAGivenNumOccursInASortedArray {

    private static int binarySearchStartIndex(int[] a, int low, int high, int n) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || a[mid - 1] != n) && a[mid] == n) {
                return mid;
            }
            return a[mid] < n ? binarySearchStartIndex(a, mid + 1, high, n) : binarySearchStartIndex(a, low, mid - 1, n);
        }
        return a.length - 1;
    }

    private static int binarySearchEndIndex(int[] a, int low, int high, int n) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || a[mid - 1] == n) && a[mid] != n) {
                return mid - 1;
            }
            return a[mid] <= n ? binarySearchEndIndex(a, mid + 1, high, n) : binarySearchEndIndex(a, low, mid - 1, n);
        }
        return a.length - 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5};
        int n = 4;
        int startIndex = binarySearchStartIndex(a, 0, a.length - 1, n);
        int endIndex   = binarySearchEndIndex(a, startIndex + 1, a.length - 1, n);
        System.out.println(startIndex == endIndex ? 1 : endIndex - startIndex + 1);
    }
}
