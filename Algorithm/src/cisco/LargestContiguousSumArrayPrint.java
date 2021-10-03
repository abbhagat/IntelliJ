package cisco;

import java.util.stream.IntStream;

import static java.lang.Math.max;

public class LargestContiguousSumArrayPrint {

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int cur_sum, max_sum, start, end, s;
        cur_sum = max_sum = a[0];
        start = end = s = 0;
        for (int i = 1; i < a.length; i++) {
            cur_sum = max(a[i], cur_sum + a[i]);
            max_sum = max(cur_sum, max_sum);
            if (cur_sum < max_sum) {
                start = s;
                end = i;
            }
            if (max_sum < 0) {
                s = i + 1;
            }
        }
        System.out.println(max_sum);
        IntStream.range(start, end).forEach(i -> System.out.print(a[i] + " "));
    }
}
