package interval;

import util.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.max;

public class IntervalMerging {
    private static LinkedList<Interval> mergeInterval(List<Interval> intervalList) {
        intervalList.sort(Comparator.comparingInt(interval -> interval.start));      // Collections.sort(intervalList, (interval1, interval2) -> interval1.start - interval2.start);
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
        intervalList.add(new Interval(6, 9));
        intervalList.add(new Interval(2, 5));
        intervalList.add(new Interval(-2, 10));
        mergeInterval(intervalList).forEach(interval -> System.out.println(interval.start + "," + interval.end));
    }
}
