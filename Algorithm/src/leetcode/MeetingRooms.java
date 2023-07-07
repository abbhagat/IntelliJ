package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MeetingRooms {

    private static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

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

    public static void main(String[] args) {
        System.out.println(canAttendAllMeeting(Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20))));
        System.out.println(canAttendAllMeeting(Arrays.asList(new Interval(7, 10), new Interval(2, 4))));

    }
}
