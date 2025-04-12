package vmware;

// Design a hit counter that counts the number of hits in the past 10 sec

// Time Complexity : O(n)
public class HitCounter {

    private final int[] hits, times;

    public HitCounter(int timeInSecs) {
        this.hits = new int[timeInSecs];
        this.times = new int[timeInSecs];
    }

    public void hit(int timestamp) {
        int i = timestamp % 10;
        if (times[i] != timestamp) {
            times[i] = timestamp;
            hits[i] = 1;
        }
        hits[i]++;
    }

    public int getHits(int timestamp) {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (timestamp - times[i] < 10) {
                result += hits[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter(10);
        counter.hit(1);
        counter.hit(2);
        counter.hit(2);
        counter.hit(3);
        counter.hit(3);
        System.out.println(counter.getHits(4));
        counter.hit(10);
        System.out.println(counter.getHits(10));
        System.out.println(counter.getHits(11));
    }
}
