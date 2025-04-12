package geeks;

public class BulbSwitchProblem {

    private static int solve(int[] a, int[] q) {
        int countOne = 0;
        for (int x : a) {
            countOne += (x == 1) ? 1 : 0;
        }
        boolean glows = countOne >= (double) (a.length / 2);
        int count = 0;
        for (int x : q) {
            boolean prev = glows;
            countOne += (a[x] == 0) ? 1 : -1;
            a[x] ^= 1;
            glows = countOne >= (double) (a.length / 2);
            if (prev != glows) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 1, 0, 0, 1, 0, 0}, new int[]{2, 2, 6}));
    }
}
