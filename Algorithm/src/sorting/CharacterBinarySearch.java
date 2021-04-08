package sorting;

import java.util.Arrays;

public class CharacterBinarySearch {

    private static char[] c = { 'a', 'b', 'c', 'd', 'e', 'f' };

    public static void main(String[] args) {
        Arrays.sort(c);
        binarySearch(0, c.length - 1, 'c');
    }

    private static void binarySearch(int low, int high, char ch) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (ch == c[mid]) {
                System.out.println("Present at index " + "\t" + mid);
            } else if (ch < c[mid]) {
                binarySearch(low, mid - 1, ch);
            } else {
                binarySearch(mid + 1, high, ch);
            }
        } else {
            System.out.println("Not Present");
        }
    }
}
