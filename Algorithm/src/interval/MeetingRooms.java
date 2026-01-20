package interval;

import util.Interval;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Time  Complexity : O(n log n)
// Space Complexity : O(n)
public class MeetingRooms {

  private static boolean canAttendAllMeeting(List<Interval> intervalList) {
    intervalList.sort((interval1, interval2) -> interval1.start - interval2.start); // Comparator.comparingInt(interval -> interval.start)
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

  private static boolean canAttendAllMeeting(int[][] a) {
    Arrays.sort(a, (x, y) -> x[0] - y[0]);  // Comparator.comparingInt(x -> x[0])
    LinkedList<int[]> mergeInterval = new LinkedList<>();
    for (int[] b : a) {
      if (mergeInterval.isEmpty() || mergeInterval.getLast()[1] < b[0]) {
        mergeInterval.add(b);
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
    intervals = new int[][]{{0, 30}, {15, 20}, {5, 10}};
    System.out.println(canAttendAllMeeting(intervalList) + "\t" + canAttendAllMeeting(intervals));

    intervalList = Arrays.asList(new Interval(7, 10), new Interval(2, 4));
    intervals = new int[][]{{7, 10}, {2, 4}};
    System.out.println(canAttendAllMeeting(intervalList) + "\t" + canAttendAllMeeting(intervals));
  }
}
