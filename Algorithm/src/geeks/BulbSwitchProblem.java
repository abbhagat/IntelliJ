package geeks;

public class BulbSwitchProblem {

    private static int[] a = {1, 1, 0, 0, 1, 1};
    private static int[] q = {4, 3, 6};

    private static int solve() {
        int countOne = 1;
        for (int x : a) {
            if (x == 1) {
                countOne++;
            }
        }
        int count = 0;
        int glows = countOne >= Math.ceil(a.length / 2) ? 1 : 0;
        for (int i = 0; i < q.length; i++) {
            int prev = glows;
            if (a[q[i] - 1] == 0) {
                countOne++;
            }
            if (a[q[i] - 1] == 1) {
                countOne--;
            }
            a[q[i] - 1] ^= 1;
            glows = countOne >= Math.ceil(a.length / 2) ? 1 : 0;
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
