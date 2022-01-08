package vmware;

import java.util.Arrays;

public class MissingNumber_1_to_25 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 5};
        int n = a.length;
        Arrays.sort(a);
        int y = 0, sum1 = 0;
        for (int x : a) {
            sum1 += x;
        }
        for (int i = 1; i < n; i++) {
            if (a[i - 1] == a[i]) {
                y = a[i];
                break;
            }
        }
        sum1 -= y;
        int sum2 = ((a[0] + a[n - 1]) * n) / 2;
        System.out.println(sum2 - sum1);
    }
}
