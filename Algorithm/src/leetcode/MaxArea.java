package leetcode;

public class MaxArea {

    public static int maxArea(int[] a) {
        int low = 0, high = a.length - 1;
        int area = 0;
        while (low < high) {
            area = Math.max(area, Math.min(a[low], a[high]) * (high - low));
            if (a[low] < a[high]) {
                low++;
            } else {
                high--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
