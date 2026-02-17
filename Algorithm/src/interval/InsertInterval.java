package interval;

import util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

  private static void insertInterval(List<int[]> intervalList, int[] newInterval) {
    int i = 0;
    while (i < intervalList.size() && intervalList.get(i)[1] < newInterval[0]) {
      i++;
    }
    while (i < intervalList.size() && intervalList.get(i)[0] <= newInterval[1]) {
      int[] interval = intervalList.remove(i);
      newInterval[0] = min(newInterval[0], interval[0]);
      newInterval[1] = max(newInterval[1], interval[1]);
    }
    intervalList.add(i, newInterval);
  }

  public static void main(String[] args) {
    List<Interval> list = new ArrayList<>();
    List<Interval> intervalList = List.of(new Interval(1, 5), new Interval(6, 10), new Interval(6, 15));
    intervalList.forEach(newInterval -> {
      insertInterval(list, newInterval);
      System.out.println(list);
    });

    System.out.println("----------------------");
    List<int[]> list1 = new LinkedList<>();
    int[][] intervalList1 = new int[][]{{1, 5},
                                        {6, 10},
                                        {6, 15}
                                       };
    Arrays.stream(intervalList1).forEach(newInterval -> {
      insertInterval(list1, newInterval);
    });
    list1.forEach(a -> System.out.println(Arrays.toString(a)));
  }
}
