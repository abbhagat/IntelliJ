package vmware;

public class NoOfTimesAGivenNumOccursInASortedArray {

    private static int binarySearch(int[] a, int low, int high, int n) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || a[mid - 1] != n) && a[mid] == n) {
                return mid;
            }
            return a[mid] < n ? binarySearch(a, mid + 1, high, n) : binarySearch(a, low, mid - 1, n);
        }
        return a.length - 1;
    }

    private static int binarySearch1(int[] a, int low, int high, int n) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || a[mid - 1] == n) && a[mid] != n) {
                return mid;
            }
            return a[mid] < n ? binarySearch1(a, mid + 1, high, n) : binarySearch1(a, low, mid - 1, n);
        }
        return a.length - 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 2, 2, 2, 2, 3};
        int n = 2;
        int startIndex = binarySearch(a, 0, a.length - 1, n);
        int endIndex   = binarySearch1(a, startIndex, a.length - 1, n);
        System.out.println(endIndex - startIndex);
    }
}
