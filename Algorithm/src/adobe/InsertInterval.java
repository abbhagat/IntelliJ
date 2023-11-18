package adobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class InsertInterval {

    private static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static void insertInterval(List<Interval> intervalList, Interval newInterval) {
        int i = 0;
        while (i < intervalList.size() && intervalList.get(i).end < newInterval.start) {
            i++;
        }
        while (i < intervalList.size() && intervalList.get(i).start <= newInterval.end) {
            Interval interval = intervalList.remove(i);
            newInterval.start = min(interval.start, newInterval.start);
            newInterval.end   = max(interval.end, newInterval.end);
        }
        intervalList.add(i, newInterval);
    }

    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(6, 9)));
        insertInterval(intervalList, new Interval(2, 5));
        intervalList.forEach(interval -> System.out.println(interval.start + " " + interval.end));
        insertInterval(intervalList, new Interval(-2, 10));
        intervalList.forEach(interval -> System.out.println(interval.start + " " + interval.end));
    }
}
