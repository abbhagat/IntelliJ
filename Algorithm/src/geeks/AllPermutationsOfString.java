package geeks;

import static util.Swap.swap;

// Time Complexity O(n) * n!
public class AllPermutationsOfString {

    private static final char[] a = {'A', 'B', 'C'};
    private static int count;

    private static void permute(int start, int end) {
        if (start == end) {
            count++;
            System.out.println(a);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(a, i, start);
            permute(start + 1, end);
            swap(a, i, start);
        }
    }

    public static void main(String[] args) {
        permute(0, a.length - 1);
        System.out.println(count);
    }
}
