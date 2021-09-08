package geeksforgeeks;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaxArea {

    public static int maxArea(int[] a) {
        int low = 0, high = a.length - 1, area = 0;
        while (low < high) {
            area = max(area, min(a[low], a[high]) * (high - low));
            int i = a[low] < a[high] ? low++ : high--;
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
