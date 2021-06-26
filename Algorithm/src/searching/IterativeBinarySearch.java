package searching;

import java.util.Arrays;

public class IterativeBinarySearch {

    public static void main(String[] args) {
        int[] a = new int[]{12, 15, 30, 35, 46, 55, 60, 72, 89, 92, 100};
        Arrays.sort(a);
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        int n = 60;
        boolean flag = false;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == n) {
                System.out.println("Present at index " + mid);
                flag = true;
                break;
            }
            if (n < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (!flag) {
            System.out.println("Not Present");
        }
    }
}
