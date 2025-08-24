package interval;

import util.Interval;

import java.util.*;

import static java.lang.Integer.max;
import static util.CommonUtils.printMatrix;

// Time Complexity  : O(n log n)
// Space Complexity : O(1)
public class IntervalMerging {

    private static LinkedList<Interval> mergeInterval(List<Interval> intervalList) {
        intervalList.sort((interval1, interval2) -> interval1.start - interval2.start); // Comparator.comparingInt(interval -> interval.start)
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

    private static int[][] mergeInterval(int[][] a) {
        Arrays.sort(a, (x, y) -> x[0] - y[0]); // Arrays.sort(Comparator.comparingInt(x -> x[0]));
        LinkedList<int[]> interval = new LinkedList<>();
        interval.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (interval.getLast()[1] < a[i][0]) {
                interval.add(a[i]);
            } else {
                interval.getLast()[1] = max(interval.getLast()[1], a[i][1]);
            }
        }
        return interval.toArray(new int[interval.size()][2]);
    }

    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(1, 3));
        intervalList.add(new Interval(6, 9));
        intervalList.add(new Interval(2, 5));
        mergeInterval(intervalList).forEach(interval -> System.out.println(interval.start + "," + interval.end));
        System.out.println();
        printMatrix(mergeInterval(new int[][]{ {1, 3},
                                               {6, 9},
                                               {2, 5}
                                             }));
    }
}
