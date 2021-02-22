package arrays;

public class MidPointOfAnArray {

    public static void main(String[] args) {
        int[] a = {10, 2, 30, 4, 5, 14, 13, 0, 10};
        int sum1 = 0, sum2 = 0;
        for (int x : a) {
            sum1 += x;
        }
        for (int i = 0; i < a.length; i++) {
            sum2 += a[i];
            if (sum1 == sum2) {
                System.out.println(a[i]);
                break;
            }
            sum1 -= a[i];
        }
    }
}
