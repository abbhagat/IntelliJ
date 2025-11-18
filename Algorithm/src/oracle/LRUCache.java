package oracle;

/*
 * LRU cache is implemented using a Deque and HashMap.
 * Deque is used to store queue of pages with the most recently used page at the start of the q.
 * So, as more pages are added to the q, least recently used pages are moved to the end of the q with
 * page at tail being the least recently used page in the q.
 * Hash Map (key: page number, value: page) is used for O(1) access to pages in cache
 * When a page is accessed, there can be 2 cases:
 * 1. The Page is     present in the cache - If the page is already present in the cache, we move the page to the start of the q.
 * 2. The Page is not present in the cache - If the page is not present in the cache, we add the page to the q.
 * How to add a page to the q:
 * 1. If the cache is not full, add the new page to the start of the q.
 * 2. If the cache is full, remove the last node of the linked q and move the new page to the start of the q.
 */

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {

  private final Deque<K> q;
  private final Map<K, V> map;
  private final int cacheSize;

  public LRUCache(int cacheSize) {
    this.q = new LinkedList<>();
    this.map = new HashMap<>();
    this.cacheSize = cacheSize;
  }

  public static void main(String[] args) {
    LRUCache<Integer, Integer> cache = new LRUCache<>(4);
    cache.put(1, 100);
    cache.put(2, 200);
    cache.put(3, 300);
    cache.put(4, 400);
    System.out.println(cache.get(1));
    cache.put(1, 1000);
    cache.put(5, 500);
    System.out.println(cache.get(1));
  }

  public synchronized V get(K key) {
    V value = null;
    if (map.containsKey(key)) {
      value = map.get(key);
      q.remove(key);
      q.addFirst(key);
    }
    return value;
  }

  public synchronized void put(K key, V value) {
    if (map.containsKey(key)) {
      q.remove(key);
    } else if (map.size() >= cacheSize) {
      K lruKey = q.removeLast();
      map.remove(lruKey);
    }
    map.put(key, value);
    q.addFirst(key);
  }
}
