package geeks;

public class BulbSwitchProblem {

    private static int solve(int[] a, int[] q) {
        int countOne = 0;
        for (int x : a) {
            countOne += (x == 1) ? 1 : 0;
        }
        boolean glows = countOne >= (double) (a.length / 2);
        int count = 0;
        for (int i : q) {
             boolean prev = glows;
             countOne += (a[i] == 0) ? 1 : -1;
             a[i]  ^= 1;
             glows  = countOne >= (double) (a.length / 2);
             count += prev != glows ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 1, 0, 0, 1, 0, 0}, new int[]{1, 2, 5}));
    }
}
