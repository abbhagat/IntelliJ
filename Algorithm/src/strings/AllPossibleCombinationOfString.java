package strings;

/*
Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a permutation.
 */
public class AllPossibleCombinationOfString {
    private static void permute(char[] c, int start, int end) {
        if (start == end) {
            System.out.println(c);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(c, i, start);
            permute(c, start + 1, end);
            swap(c, i, start);
        }
    }

    private static void swap(char[] c, int x, int y) {
        char t = c[x];
        c[x] = c[y];
        c[y] = t;
    }

    public static void main(String[] args) {
        char[] c = {'A', 'B', 'C'};
        permute(c, 0, c.length - 1);
    }
}
