package paypal;

public class HurrySoln {

    private static int solve(int n, int t, int[][] task) {
        int result = 0, timeConsumed = 0;
        timeConsumed = task[0][0] + task[0][1];
        t = t - timeConsumed;
        if (t > 0) {
            result++;
        }
        for (int i = 1, j = 1; i < n; i++) {
            timeConsumed = task[i][0] - task[j - 1][0] + task[i][1];
            if (timeConsumed > t) {
                continue;
            }
            t = t - timeConsumed;
            j = i;
            result++;

        }
        return result;
    }

    public static void main(String[] args) {

    }
}
