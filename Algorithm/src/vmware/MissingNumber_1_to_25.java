package vmware;

import java.util.Arrays;

public class MissingNumber_1_to_25 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 5};
        Arrays.sort(a);
        int y = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] == a[i]) {
                y = a[i];
                break;
            }
        }
        int sum1 = 0;
        for (int x : a) {
            sum1 += x;
        }
        sum1 -= y;
        int sum2 = ((a[0] + a[a.length - 1]) * (a.length)) / 2;
        System.out.println(sum2 - sum1);
    }
}
