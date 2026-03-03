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
      times[i] = timestamp;
       hits[i] = 1;
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
    counter.hit(1);
    counter.hit(2);
    counter.hit(3);
    counter.hit(4);
    counter.hit(300);
    counter.hit(301);
    System.out.println(counter.getHits(4));
    counter.hit(10);
    System.out.println(counter.getHits(1));
    System.out.println(counter.getHits(2));
    System.out.println(counter.getHits(3));
    System.out.println(counter.getHits(4));
    System.out.println(counter.getHits(300));
    System.out.println(counter.getHits(301));
  }
}
