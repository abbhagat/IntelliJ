import java.util.*;


/**
 * Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.
 * <p>
 * In a store, a colleague can work for multiple departments. Here are shifts of a colleague in various departments:
 * <p>
 * In Bakery department: From 8 to 10
 * In Checkout department: From 10 to 12
 * In Diary department: From 14 to 19
 * <p>
 * Given the above split of shifts, provide an API/method to return the different shifts of a colleague for the day after merging contiguous shifts.
 * <p>
 * This will be exposed to the colleague in different UI and help them plan their day accordingly.
 * <p>
 * His shift timings in this case are 8 to 12 and 14 to 19.
 */
class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return this.start + "," + this.end;
    }
}

public class MergeInterval {

    public static List<Interval> merge(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            i++;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            Interval interval = intervals.remove(i);
            newInterval.start = Integer.min(newInterval.start, interval.start);
            newInterval.end = Integer.max(newInterval.end, interval.end);
        }
        intervals.add(i, newInterval);
        return intervals;
    }

    public static LinkedList<Interval> mergeInterval(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        LinkedList<Interval> list = new LinkedList<>();
        for (Interval interval : intervals) {
            if (list.isEmpty() || list.getLast().end < interval.start) { // 8,12   14 19
                list.add(interval);
            } else {
                list.getLast().end = Integer.max(list.getLast().end, interval.end);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(10, 12));
        intervals.add(new Interval(14, 19));
        for (Interval interval : mergeInterval(intervals)) {
            System.out.println(interval);
        }
        System.out.println();
        intervals = new ArrayList<>();
        intervals.add(new Interval(8, 10));

        List<Interval> result = merge(intervals, new Interval(16, 18));
        System.out.println();
        for (Interval interval : result) {
            System.out.println(interval);
        }
        System.out.println();

        for (Interval interval : merge(intervals, new Interval(7, 9))) {
            System.out.println(interval);
        }
        System.out.println();
        for (Interval interval : merge(intervals, new Interval(0, 3))) {
            System.out.println(interval);
        }
        System.out.println();
        for (Interval interval : merge(intervals, new Interval(15, 19))) {
            System.out.println(interval);
        }
    }
}
