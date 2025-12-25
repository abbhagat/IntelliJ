package interval;

import util.Interval;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time complexity O(n), where n is the number of intervals in the intervalList.
public class CacheMerging {

  private static void insertInterval(List<Interval> list, Interval interval) {
    int i = 0;
    while (i < list.size() && (list.get(i).start + list.get(i).end) < interval.start) {
      i++;
    }
    while (i < list.size() && list.get(i).start <= interval.start + interval.end) {
      Interval newInterval = list.remove(i);
      interval.start = min(newInterval.start, interval.start);
      int end        = max(newInterval.end, interval.end);
      interval.end   = interval.start + interval.end <= newInterval.start + newInterval.end
                         ? newInterval.start + newInterval.end
                         : end;
    }
    list.add(i, interval);
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
