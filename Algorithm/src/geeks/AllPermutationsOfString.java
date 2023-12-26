package geeks;

import static util.CommonUtils.swap;

// Time Complexity O(n) * n!
public class AllPermutationsOfString {

    private static int count;

    private static void permute(char[] a, int start, int end) {
        if (start == end) {
            count++;
            System.out.println(a);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(a, i, start);
            permute(a,start + 1, end);
            swap(a, i, start);
        }
    }

    public static void main(String[] args) {
        final char[] a = {'A', 'B', 'C'};
        permute(a, 0, a.length - 1);
        System.out.println(count);
    }
}
