package adobe;

// Time Complexity :- log(n)
public class FindPeakElement {

    private static int findPeakElement(int[] a) {
        int low = 0, high = a.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] > a[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return a[low];
    }

    private static int findPeak(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return a[i];
            }
        }
        return a[a.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}) + "\t" + findPeak(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 3, 4}) + "\t" + findPeak(new int[]{1, 2, 3, 4}));
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}) + "\t" + findPeak(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
