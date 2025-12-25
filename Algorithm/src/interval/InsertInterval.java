package interval;

import util.Interval;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class InsertInterval {

  private static void insertInterval(List<Interval> list, Interval interval) {
    int i = 0;
    while (i < list.size() && list.get(i).end < interval.start) {
      i++;
    }
    while (i < list.size() && list.get(i).start <= interval.end) {
      Interval newInterval = list.remove(i);
      interval.start = min(interval.start, newInterval.start);
      interval.end   = max(interval.end,   newInterval.end);
    }
    list.add(i, interval);
  }

  public static void main(String[] args) {
    List<Interval> list = new ArrayList<>();
    Stream<Interval> intervalList = Stream.of(new Interval(1, 3), new Interval(6, 9), new Interval(2, 5));
    intervalList.forEach(newInterval -> {
      insertInterval(list, newInterval);
      System.out.println(list);
    });
  }
}
