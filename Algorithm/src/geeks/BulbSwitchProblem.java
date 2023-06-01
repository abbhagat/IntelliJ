package geeks;

public class BulbSwitchProblem {

    private static final int[] a = {1, 1, 0, 0, 1, 0, 0};
    private static final int[] q = {2, 2, 6};

    private static int solve() {
        int countOne = 0;
        for (int x : a) {
            if (x == 1) {
                countOne++;
            }
        }
        boolean glows = countOne >= (double) (a.length / 2);
        int count = 0;
        for (int x : q) {
            boolean prev = glows;
            countOne += (a[x - 1] == 0) ? 1 : -1;
            a[x - 1] ^= 1;
            glows = countOne >= (double) (a.length / 2);
            if (prev != glows) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}
