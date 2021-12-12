package strings;

/*
Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a permutation.
 */
public class AllPossibleCombinationOfString {

    private static char[] c = {'A', 'B', 'C'};

    private static void permute(int start, int end) {
        if (start == end) {
            System.out.println(c);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(i, start);
            permute(start + 1, end);
            swap(i, start);
        }
    }

    private static void swap(int x, int y) {
        char t = c[x];
        c[x] = c[y];
        c[y] = t;
    }

    public static void main(String[] args) {
        permute(0, c.length - 1);
    }
}
