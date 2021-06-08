package sorting;

public class MissNum {
    public static void main(String[] args) {

        int[] a = {9, 7, 3, 4, 10, 1, 2, 8, 6};
        int max = a[0], min = a[0];
        int n = a.length + 1;
        int sum1 = 0, sum2;
        for (int x : a) {
            max = max < x ? x : max;
            min = min > x ? x : min;
            sum1 += x;
        }
        sum2 = ((min + max) * n) / 2;
        System.out.println("Missing Num : " + (sum2 - sum1));
    }
}
