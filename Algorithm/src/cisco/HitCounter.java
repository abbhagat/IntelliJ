package cisco;

// Design a hit counter that counts the number of hits in the past 5 mins
// Time Complexity : O(n)
public class HitCounter {
    
    private static int[] times, hits;
    
    public HitCounter(int timeInSec){
        this.times = new int[timeInSec];
        this.hits  = new int[timeInSec];
    }

    private static void hit(int timestamp){
       int index = timestamp % 300;
       if(times[index] != timestamp){
           times[index] = timestamp;
           hits[index] = 1;
       }else{
           hits[index]++;
       }
    }
    
    private static int getHits(int timestamp){
        int total = 0;
        for(int i = 0; i < 300; i++){
            if(timestamp - times[i] < 300){
                total += hits[i];
            }
        }
        return total;
    }
    
    public static void main(String[] args) {
        HitCounter counter = new HitCounter(300);
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));
        counter.hit(300);
        System.out.println(counter.getHits(300));
        System.out.println(counter.getHits(301));
    }
}
