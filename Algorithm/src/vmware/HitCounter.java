package vmware;

// Design a hit counter that counts the number of hits in the past 5 mins

// Time Complexity : O(n)
public class HitCounter {

  private final int[] hits, times;
  private final int time;

  public HitCounter(int timeInSecs, int time) {
    this.hits  = new int[timeInSecs];
    this.times = new int[timeInSecs];
    this.time  = time;
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
    HitCounter counter = new HitCounter(300, 300);
    for (int i = 1; i <= 500; i++) {
      counter.hit(i);
      if (i == 4) {
        System.out.println(counter.getHits(i));
      }
      if (i == 300) {
        System.out.println(counter.getHits(i));
      }
      if (i == 301) {
        System.out.println(counter.getHits(i));
      }
    }
  }
}
