package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms_Array {

    private static boolean eraseOverlappingInterval(int[][] intervals) {
        if (intervals.length == 0) {
            return false;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlappingInterval(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(eraseOverlappingInterval(new int[][]{{7, 10}, {2, 4}}));
    }
}
