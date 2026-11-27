package interview;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

class LFU<K, V> {

  @Getter
  @Setter
  @AllArgsConstructor
  private static class FreqObj<V> {
    V v;
    int count;

  }

  private final Deque deque;
  private final Map<K,FreqObj> map;
  private final int cacheSize;
  private PriorityQueue<K> pq;

  public LFU(int cacheSize) {
    this.deque = new LinkedList<>();
    this.map = new HashMap<>();
    this.cacheSize = cacheSize;
  }

  public V get(K k) {
    FreqObj v = null;
    if(map.containsKey(k)) {
      v = map.get(k);
      int prevCount = v.getCount();
      v.setCount(prevCount + 1);
    }
    return v == null ? null : (V) v.getV();
  }
  // 3 1 2 4 5  -> 5
  // 6

  public void put(K k, V v) {
    if(map.containsKey(k)) {
      if(v.equals(map.get(k))){
        return;
      }
    } else if (map.size() == cacheSize) {
      pq = new PriorityQueue<>((k1, k2) -> {
        FreqObj countA = map.get(k1);
        FreqObj countB = map.get(k2);
        int c = Integer.compare(countA.getCount(), countB.getCount());
        if(c > 1) {
          pq.remove(k2);
        }else {
          pq.remove(k1);
        }
        return c;
      });
    }
    map.put(k, new FreqObj(v, 1));
  }
}


public class Main {

  public static void main(String[] args) {

  }
}
