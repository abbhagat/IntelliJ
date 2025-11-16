package interval;

import util.Interval;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class InsertInterval {

    private static void insertInterval(List<Interval> intervalList, Interval newInterval) {
        int i = 0;
        while (i < intervalList.size() && intervalList.get(i).end < newInterval.start) {
            i++;
        }
        while (i < intervalList.size() && intervalList.get(i).start <= newInterval.end) {
            Interval interval = intervalList.remove(i);
            newInterval.start = min(newInterval.start, interval.start);
            newInterval.end   = max(newInterval.end, interval.end);
        }
        intervalList.add(i, newInterval);
    }

    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        insertInterval(intervalList, new Interval(8, 10));
        insertInterval(intervalList, new Interval(8, 12));
        insertInterval(intervalList, new Interval(16, 18));
        insertInterval(intervalList, new Interval(7, 9));
        insertInterval(intervalList, new Interval(0, 3));
        insertInterval(intervalList, new Interval(15, 19));
        System.out.println(intervalList);
    }
}
