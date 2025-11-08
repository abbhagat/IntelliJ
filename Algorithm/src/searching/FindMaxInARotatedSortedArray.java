package searching;

// Time Complexity O(log n)
public class FindMaxInARotatedSortedArray {

    private static int findMax(int[] a) {
        int low = 0, mid = 0, high = a.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == a[high]) {
                high--;
            } else if (a[mid] > a[mid + 1]) {
                return a[mid];
            } else if (a[low] > a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return a[mid];
    }

    private static int findMaximum(int[] a, int low, int mid, int high) {
        if (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == a[high]) {
                return findMaximum(a, low, mid, high - 1);
            }
            if (a[mid] > a[mid + 1]) {
                return a[mid];
            }
            return a[low] > a[mid] ? findMaximum(a, low, mid, mid - 1) : findMaximum(a, mid + 1, mid, high);
        }
        return a[mid];
    }

    public static void main(String[] args) {
        int[] a;
        a = new int[]{5, 6, 1, 1, 1, 2, 3, 4, 4, 5};
        System.out.println("Max :" + findMax(a));
        System.out.println("Max :" + findMaximum(a, 0, 0, a.length - 1));
        System.out.println("****************");
        a = new int[]{1, 2, 3, 4};
        System.out.println("Max :" + findMax(a));
        System.out.println("Max :" + findMaximum(a, 0, 0, a.length - 1));
        System.out.println("****************");
        a = new int[]{1};
        System.out.println("Max :" + findMax(a));
        System.out.println("Max :" + findMaximum(a, 0, 0, a.length - 1));
        System.out.println("****************");
        a = new int[]{1, 2};
        System.out.println("Max :" + findMax(a));
        System.out.println("Max :" + findMaximum(a, 0, 0, a.length - 1));
        System.out.println("****************");
        a = new int[]{2, 1};
        System.out.println("Max :" + findMax(a));
        System.out.println("Max :" + findMaximum(a, 0, 0, a.length - 1));
        System.out.println("****************");
        a = new int[]{5, 6, 7, 1, 2, 3, 4};
        System.out.println("Max :" + findMax(a));
        System.out.println("Max :" + findMaximum(a, 0, 0, a.length - 1));
        System.out.println("****************");
        a = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Max :" + findMax(a));
        System.out.println("Max :" + findMaximum(a, 0, 0, a.length - 1));
        System.out.println("****************");
        a = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
        System.out.println("Max :" + findMax(a));
        System.out.println("Max :" + findMaximum(a, 0, 0, a.length - 1));
        System.out.println("****************");
        a = new int[]{3, 4, 5, 1, 2};
        System.out.println("Max :" + findMax(a));
        System.out.println("Max :" + findMaximum(a, 0, 0, a.length - 1));
    }
}
