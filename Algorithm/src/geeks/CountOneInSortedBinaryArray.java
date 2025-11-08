package geeks;

// Time  Complexity: O(log n)
// Space Complexity: O(log n)
public class CountOneInSortedBinaryArray {

    private static int countOnes(int[] a, int low, int high) {
        if (a[low] == 1) {
            return high - low + 1;
        }
        if (a[high] == 0) {
            return 0;
        }
        int mid = (low + high) / 2;
        return countOnes(a, low, mid) + countOnes(a, mid + 1, high);
    }

    private static int countZero(int[] a, int low, int high) {
        if (a[low] == 1) {
            return 0;
        }
        if (a[high] == 0) {
            return high - low + 1;
        }
        int mid = (low + high) / 2;
        return countZero(a, low, mid) + countZero(a, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 1, 1, 1, 1, 1, 1};
        System.out.println(countOnes(a, 0, a.length - 1));
        System.out.println(countZero(a, 0, a.length - 1));
    }
}
