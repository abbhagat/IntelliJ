package cisco;

import static java.lang.Long.max;
import static java.lang.Long.min;

public class CountDigitOne {

    private static int countDigitOne(int n) {
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (n / divider) * i + min(max(n % divider - i + 1, 0), i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
        System.out.println(countDigitOne(21));
    }
}
