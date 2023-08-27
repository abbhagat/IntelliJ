package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {

    private static int eraseOverlappingInterval(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        int min = 0, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                end = intervals[i][1];
            } else {
                min++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlappingInterval(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 4} }));
        System.out.println(eraseOverlappingInterval(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(eraseOverlappingInterval(new int[][]{{1, 2}, {2, 3}}));
    }
}
