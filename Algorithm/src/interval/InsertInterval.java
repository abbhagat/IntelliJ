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
    List<Interval> list = new ArrayList<>();
    List<Interval> intervalList = List.of(new Interval(1, 5), new Interval(6, 10), new Interval(6, 15));
    intervalList.forEach(newInterval -> {
      insertInterval(list, newInterval);
      System.out.println(list);
    });
  }
}
