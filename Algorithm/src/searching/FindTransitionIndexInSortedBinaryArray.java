package searching;

public class FindTransitionIndexInSortedBinaryArray {

    private static int binarySearch(int[] a, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || a[mid - 1] == 0) && a[mid] == 1) {
                return mid;
            }
            return a[mid] == 0 ? binarySearch(a, mid + 1, high) : binarySearch(a, low, mid - 1);
        }
        return a.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0, 0, 0, 1, 1, 1, 1}, 0, 6));
        System.out.println(binarySearch(new int[]{0, 0, 0, 0, 0, 0, 0}, 0, 6));
        System.out.println(binarySearch(new int[]{1, 1, 1, 1, 1, 1, 1}, 0, 6));
    }
}
