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
      int end           = max(interval.end, newInterval.end);
      newInterval.end   = newInterval.start + newInterval.end <= interval.start + interval.end
                         ? interval.start + interval.end
                         : end;
    }
    intervalList.add(i, newInterval);
  }

  public static void main(String[] args) {
    List<Interval> list = new ArrayList<>();
    List<Interval> intervalList = List.of(new Interval(50, 2), new Interval(60, 5), new Interval(51, 7), new Interval(61, 10), new Interval(1, 60), new Interval(-1, 70));
    intervalList.forEach(interval -> {
      insertInterval(list, interval);
      System.out.println(list);
    });
  }
}
