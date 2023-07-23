package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;

import static java.lang.Integer.max;

public class IntervalMergingWith2DArray {

    private static LinkedList<int[]> mergeInterval(int[][] a) {
        if (a.length == 0) {
            return null;
        }
        Arrays.sort(a, Comparator.comparingInt(i -> i[0]));
        LinkedList<int[]> interval = new LinkedList<>();
        interval.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (interval.getLast()[1] < a[i][0]) {
                interval.add(a[i]);
            } else {
                interval.getLast()[1] = max(interval.getLast()[1], a[i][1]);
            }
        }
        return interval;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{ {1, 3},
                                 {2, 6},
                                 {8, 10},
                                 {15, 18}
                               };
        for (int[] x : Objects.requireNonNull(mergeInterval(a))) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
