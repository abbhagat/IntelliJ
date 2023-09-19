package oracle;

/*
LRU cache is implemented using a doubly linked list and a hash map.
Doubly Linked List is used to store list of pages with most recently used page at the start of the list.
So, as more pages are added to the list, least recently used pages are moved to the end of the list with
page at tail being the least recently used page in the list.
Hash Map (key: page number, value: page) is used for O(1) access to pages in cache

When a page is accessed, there can be 2 cases:
1. Page is present in the cache     - If the page is already present in the cache, we move the page to the start of the list.
2. Page is not present in the cache - If the page is not present in the cache, we add the page to the list.
How to add a page to the list:
1. If the cache is not full, add the new page to the start of the list.
2. If the cache is full, remove the last node of the linked list and move the new page to the start of the list.
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    private final LinkedList<Integer> list;
    private final Map<Integer, Integer> map;

    private final int cacheSize;

    public LRUCache(int cacheSize) {
        list = new LinkedList<>();
        map  = new HashMap<>();
        this.cacheSize = cacheSize;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key);
        list.remove(key);
        list.addFirst(key);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(key);
        } else if (map.size() >= cacheSize) {
            int lruKey = list.removeLast();
            map.remove(lruKey);
        }
        map.put(key, value);
        list.addFirst(key);
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
