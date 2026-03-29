package lld;

// Design a hit counter that counts the number of hits in the past 5 mins or 10 secs

// Time Complexity : O(n)
public class HitCounter {

  private final int[] hits, times;
  private final int time;

  public HitCounter(int timeInSecs) {
    this.hits  = new int[timeInSecs];
    this.times = new int[timeInSecs];
    this.time  = timeInSecs;
  }

  public void hit(int timestamp) {
    int i = timestamp % time;
    if (times[i] != timestamp) {
        times[i]  = timestamp;
         hits[i]  = 1;
    } else {
      hits[i]++;
    }
  }

  public int getHits(int timestamp) {
    int count = 0;
    for (int i = 0; i < time; i++) {
      if (timestamp - times[i] < time) {
        count += hits[i];
      }
    }
    return count;
  }

  public static void main(String[] args) {
    HitCounter counter = new HitCounter(10);  // If 5 mins then we pass 300 as argument as 5 min = 300 secs
    counter.hit(1);
    counter.hit(2);
    counter.hit(2);
    counter.hit(3);
    counter.hit(3);
    counter.hit(4);
    System.out.println(counter.getHits(1));
    System.out.println(counter.getHits(2));
    System.out.println(counter.getHits(3));
    System.out.println(counter.getHits(4));
  }
}
