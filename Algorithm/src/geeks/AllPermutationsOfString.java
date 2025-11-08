package geeks;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time Complexity O(n) * n!
public class AllPermutationsOfString {

    private static int count;

    private static void permute(char[] c, int start, int end) {
        if (start == end) {
            count++;
            printArray(c);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(c, i, start);
            permute(c, start + 1, end);
            swap(c, i, start);
        }
    }

    public static void main(String[] args) {
        final char[] c = {'A', 'B', 'C'};
        permute(c, 0, c.length - 1);
        System.out.println(count);
    }
}
