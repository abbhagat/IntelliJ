package adobe;

// Time Complexity O(n)
public class FirstAndLastPositionOfElementInSortedArray {

    private static int[] searchRange(int[] a, int n) {
        int[] result = {-1, -1};
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] == n) {
                result[0] = i;
                break;
            }
        }
        if (a[0] == -1) {
            return result;
        }
        for (int j = a.length - 1; j > i; j--) {
            if (a[j] == n) {
                result[1] = j;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (int x : searchRange(new int[]{1, 1, 2, 2, 2}, 2)) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (int x : searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (int x : searchRange(new int[]{5, 7, 7, 8, 8, 10}, 2)) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
