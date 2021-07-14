package leetcode;

import java.util.List;

public class PrisonBreak {

    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        boolean[] x = new boolean[n + 1];
        boolean[] y = new boolean[m + 1];
        for (int i = 0; i < x.length; i++) {
            x[i] = true;
        }
        for (int i = 0; i < y.length; i++) {
            y[i] = true;
        }

        int cx = 0, ox = Integer.MIN_VALUE, cy = 0, oy = Integer.MIN_VALUE;

        for (int i = 0; i < h.size(); i++) {
            x[h.get(i)] = false;
        }

        for (int i = 0; i < v.size(); i++) {
            y[v.get(i)] = false;
        }

        for (int i = 1; i <= n; i++) {
            if (x[i]) {
                cx = 0;
            } else {
                cx++;
                ox = Math.max(ox, cx);
            }
        }
        for (int i = 1; i <= m; i++) {
            if (y[i]) {
                cy = 0;
            } else {
                cy++;
                oy = Math.max(oy, cy);
            }
        }
        return (ox + 1) * (oy + 1);

    }

    public static void main(String[] args) {

    }
}
