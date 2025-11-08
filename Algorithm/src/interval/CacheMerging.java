package interval;

import util.Interval;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time complexity O(n), where n is the number of intervals in the intervalList.
public class CacheMerging {

    private static void insertInterval(List<Interval> intervalList, Interval newInterval) {
        int i = 0;
        while (i < intervalList.size() && (intervalList.get(i).start + intervalList.get(i).end) < newInterval.start) {
            i++;
        }
        while (i < intervalList.size() && intervalList.get(i).start <= newInterval.start + newInterval.end) {
            Interval interval = intervalList.remove(i);
            newInterval.start = min(interval.start, newInterval.start);
            int end = max(interval.end, newInterval.end);
            if (newInterval.start + newInterval.end <= interval.start + interval.end) {
                newInterval.end = interval.start + interval.end;
            } else {
                newInterval.end = end;
            }
        }
        intervalList.add(i, newInterval);
    }

    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        insertInterval(intervalList, new Interval(50, 2));
        System.out.println(intervalList);
        insertInterval(intervalList, new Interval(60, 5));
        System.out.println(intervalList);
        insertInterval(intervalList, new Interval(51, 7));
        System.out.println(intervalList);
        insertInterval(intervalList, new Interval(61, 10));
        System.out.println(intervalList);
        insertInterval(intervalList, new Interval(1, 60));
        System.out.println(intervalList);
        insertInterval(intervalList, new Interval(-1, 70));
        System.out.println(intervalList);
    }
}
