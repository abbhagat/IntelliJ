package vmware;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.max;

public class IntervalMerging {

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static LinkedList<Interval> mergeInterval(List<Interval> intervalList) {
//        Collections.sort(intervalList, (interval1, interval2) -> interval1.start - interval2.start);
        intervalList.sort(Comparator.comparingInt(interval -> interval.start));
        LinkedList<Interval> mergedInterval = new LinkedList<>();
        for (Interval interval : intervalList) {
            if (mergedInterval.isEmpty() || mergedInterval.getLast().end < interval.start) {
                mergedInterval.add(interval);
            } else {
                mergedInterval.getLast().end = max(mergedInterval.getLast().end, interval.end);
            }
        }
        return mergedInterval;
    }

    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(1, 3));
        intervalList.add(new Interval(2, 6));
        intervalList.add(new Interval(8, 10));
        intervalList.add(new Interval(15, 18));
        mergeInterval(intervalList).forEach(interval -> System.out.println(interval.start + "," + interval.end));
    }
}
