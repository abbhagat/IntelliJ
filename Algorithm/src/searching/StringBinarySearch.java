package searching;

import java.util.Arrays;

public class StringBinarySearch {

    public static void main(String[] args) {
        String[] str = {"A", "B", "C", "F", "I", "S"};
        Arrays.sort(str);
        binarySearch(str, 0, str.length - 1, "A");
    }

    private static void binarySearch(String[] str, int low, int high, String s) {
        if (low <= high) {
            int mid = (low + high) / 2;
            int k = s.compareTo(str[mid]);
            if (k == 0) {
                System.out.println(str[mid] + " present at position " + (mid));
                return;
            } else if (k < 0) {
                binarySearch(str, low, mid - 1, s);
            } else if (k > 0) {
                binarySearch(str, mid + 1, high, s);
            }
        } else {
            System.out.println(s + " not present");
        }
    }
}
