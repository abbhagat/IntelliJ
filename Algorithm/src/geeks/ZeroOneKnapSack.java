package geeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZeroOneKnapSack {

    private static List<Integer> al = new ArrayList<>();

    private static void zeroOneKnapSack(int index, int currSum, int W, int[] wt, int[] value) {
        if (currSum == W) {
            System.out.println(Collections.max(al));
        }

        if (currSum > W) {
            return;
        }

        for (int i = index; i < wt.length; i++) {
            currSum += wt[i];
            al.add(value[i]);
            zeroOneKnapSack(i + 1, currSum, W, wt, value);
            al.remove(al.size() - 1);
            currSum -= wt[i];
        }
    }

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        zeroOneKnapSack(0, 0, W, wt, val);
    }
}
