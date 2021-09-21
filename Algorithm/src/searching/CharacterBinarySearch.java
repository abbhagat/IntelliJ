package searching;

import java.util.Arrays;

public class CharacterBinarySearch {

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'd', 'e', 'f'};
        Arrays.sort(a);
        System.out.println(binarySearch(a, 0, a.length - 1, 'c') ? "Present" : "Not Present");
    }

    private static boolean binarySearch(char[] a, int low, int high, char x) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (x == a[mid]) {
                return true;
            }
            return x < a[mid] ? binarySearch(a, low, mid - 1, x) : binarySearch(a, mid + 1, high, x);
        }
        return false;
    }
}
