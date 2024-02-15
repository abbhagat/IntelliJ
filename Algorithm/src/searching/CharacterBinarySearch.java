package searching;

import java.util.Arrays;

// Time Complexity O(log n)
public class CharacterBinarySearch {

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'd', 'e', 'f'};
        Arrays.sort(a);
        System.out.println(binarySearch(a, 0, a.length - 1, 'c') ? "Present" : "Not Present");
    }

    private static boolean binarySearch(char[] a, int low, int high, char c) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (c == a[mid]) {
                return true;
            }
            return c < a[mid] ? binarySearch(a, low, mid - 1, c) : binarySearch(a, mid + 1, high, c);
        }
        return false;
    }
}
