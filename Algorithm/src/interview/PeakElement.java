package interview;

// A peak element is an element that is greater than it's neighbour
// a[i] != a[i+1]
public class PeakElement {

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
        return low;
    }

    private static int findPeakElements(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[i + 1]) {
                return i;
            }
        }
        return a.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
