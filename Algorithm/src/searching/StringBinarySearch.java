package searching;

import java.util.Arrays;

public class StringBinarySearch {

    private static int binarySearch(String[] str, int low, int high, String s) {
        if (low <= high) {
            int mid = (low + high) / 2;
            int k = s.compareTo(str[mid]);
            if (k == 0) {
                return mid;
            }
            return k < 0 ? binarySearch(str, low, mid - 1, s) : binarySearch(str, mid + 1, high, s);
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] str = {"A", "B", "C", "F", "I", "S"};
        Arrays.sort(str);
        System.out.println(binarySearch(str, 0, str.length - 1, "F"));
    }

}
