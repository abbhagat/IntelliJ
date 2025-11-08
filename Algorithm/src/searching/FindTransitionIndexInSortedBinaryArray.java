package searching;

public class FindTransitionIndexInSortedBinaryArray {

    private static int binarySearch(int[] a, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == 0 && mid + 1 < a.length && a[mid + 1] == 1) {
                return mid;
            }
            return a[mid] == 0 ? binarySearch(a, mid + 1, high) : binarySearch(a, low, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Transition Index : " + binarySearch(new int[]{0, 0, 0, 1, 1, 1, 1}, 0, 6));
        System.out.println("Transition Index : " + binarySearch(new int[]{0, 0, 0, 0, 0, 0, 1}, 0, 6));
        System.out.println("Transition Index : " + binarySearch(new int[]{0, 0, 0, 0, 0, 0, 0}, 0, 6));
        System.out.println("Transition Index : " + binarySearch(new int[]{1, 1, 1, 1, 1, 1, 1}, 0, 6));
    }
}
