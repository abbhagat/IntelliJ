package interval;

import util.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MeetingRooms {

    private static boolean canAttendAllMeeting(List<Interval> intervalList) {
        intervalList.sort(Comparator.comparingInt(interval -> interval.start));
        LinkedList<Interval> mergedInterval = new LinkedList<>();
        for (Interval interval : intervalList) {
            if (mergedInterval.isEmpty() || mergedInterval.getLast().end < interval.start) {
                mergedInterval.add(interval);
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean canAttendAllMeeting(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                end = intervals[i][1];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervalList;
        int[][] intervals;

        intervalList = Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20));
        intervals    = new int[][]{{0, 30}, {15, 20}, {5, 10}};
        System.out.println(canAttendAllMeeting(intervalList) + "\t" + canAttendAllMeeting(intervals));

        intervalList = Arrays.asList(new Interval(7, 10), new Interval(2, 4));
        intervals    = new int[][]{{7, 10}, {2, 4}};
        System.out.println(canAttendAllMeeting(intervalList) + "\t" + canAttendAllMeeting(intervals));
    }
}
