package geeksforgeeks;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaxAreaOrContainerWithMaxWater {

    public static int maxArea(int[] a) {
        int low = 0, high = a.length - 1, max = 0;
        while (low <= high) {
            max = max(max, min(a[low], a[high]) * (high - low));
            int i = a[low] < a[high] ? low++ : high--;
        }
        return max;
    }

    public static int minArea(int[] a) {
        int low = 0, high = a.length - 1, min = 0;
        while (low < high) {
            min = min(min, min(a[low], a[high]) * (high - low));
            int i = a[low] > a[high] ? low++ : high--;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(minArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 2, 3, 4}));
        System.out.println(minArea(new int[]{1, 2, 3, 4}));
        System.out.println(maxArea(new int[]{2, 4}));
        System.out.println(minArea(new int[]{2, 4}));
    }
}
