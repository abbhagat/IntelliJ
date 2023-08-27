package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import static java.lang.Integer.max;

public class IntervalMergingWith2DArray {

    private static int[][] mergeInterval(int[][] a) {
        Arrays.sort(a, Comparator.comparingInt(x -> x[0])); // Arrays.sort(a, (x, y) -> x[0] - y[0]);
        LinkedList<int[]> interval = new LinkedList<>();
        interval.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (interval.getLast()[1] < a[i][0]) {
                interval.add(a[i]);
            } else {
                interval.getLast()[1] = max(interval.getLast()[1], a[i][1]);
            }
        }
        int[][] result = new int[interval.size()][2];
        for(int i = 0 ; i < interval.size(); i++) {
            result[i] = interval.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{ {1, 3},
                                 {2, 6},
                                 {8, 10},
                                 {15, 18}
                               };
        for (int[] x : mergeInterval(a)) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
