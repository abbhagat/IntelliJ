package oracle;

/*
LRU cache is implemented using a Deque q and a hash map.
Deque is used to store queue of pages with most recently used page at the start of the q.
So, as more pages are added to the q, least recently used pages are moved to the end of the q with
page at tail being the least recently used page in the q.
Hash Map (key: page number, value: page) is used for O(1) access to pages in cache

When a page is accessed, there can be 2 cases:
1. Page is present in the cache     - If the page is already present in the cache, we move the page to the start of the q.
2. Page is not present in the cache - If the page is not present in the cache, we add the page to the q.
How to add a page to the q:
1. If the cache is not full, add the new page to the start of the q.
2. If the cache is full, remove the last node of the linked q and move the new page to the start of the q.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final Deque<Integer> q;
    private final Map<Integer, Integer> map;

    private final int cacheSize;

    public LRUCache(int cacheSize) {
        this.q = new ArrayDeque<>();
        this.map  = new HashMap<>();
        this.cacheSize = cacheSize;
    }

    public synchronized int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            value = map.get(key);
            q.remove(key);
            q.addFirst(key);
        }
        return value;
    }

    public synchronized void put(int key, int value) {
        if (map.containsKey(key)) {
            q.remove(key);
        } else if (map.size() >= cacheSize) {
            int lruKey = q.removeLast();
            map.remove(lruKey);
        }
        map.put(key, value);
        q.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);
        cache.put(4, 400);
        System.out.println(cache.get(1));
        cache.put(1, 1000);
        cache.put(5, 500);
        System.out.println(cache.get(1));
    }
}
