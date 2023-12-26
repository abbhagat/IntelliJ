package leetcode;

import java.util.*;

public class MeetingRoomsII {

    private static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static int findMinRooms(List<Interval> intervalList) {
        intervalList.sort(Comparator.comparingInt(interval -> interval.start));
        intervalList.sort(Comparator.comparingInt(interval -> interval.end));
        LinkedList<Interval> mergedInterval = new LinkedList<>();
        int n = 1;
        for (Interval interval : intervalList) {
            if (mergedInterval.isEmpty() || mergedInterval.getLast().start < interval.start || mergedInterval.getLast().end <= interval.start) {
                mergedInterval.add(interval);
            } else {
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(findMinRooms(Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20))));
        System.out.println(findMinRooms(Arrays.asList(new Interval(7, 10), new Interval(2, 4))));
        System.out.println(findMinRooms(Arrays.asList(new Interval(0, 5), new Interval(1, 2), new Interval(6, 10))));
        System.out.println(findMinRooms(Arrays.asList(new Interval(0, 5), new Interval(1, 2), new Interval(1, 10))));
        System.out.println(findMinRooms(Arrays.asList(new Interval(0, 1), new Interval(0, 2), new Interval(2, 3), new Interval(1, 3), new Interval(2, 4), new Interval(3, 5))));
        System.out.println(findMinRooms(Arrays.asList(new Interval(1, 18), new Interval(18, 23), new Interval(15, 29), new Interval(4, 15), new Interval(2, 11), new Interval(5, 13))));
    }
}
