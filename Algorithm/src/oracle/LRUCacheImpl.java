package oracle;

import java.util.HashMap;
import java.util.Map;

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

public class LRUCacheImpl {

    private final DoublyLinkedList pageList;
    private final Map<Integer, Node> pageMap;
    private final int cacheSize;

    public LRUCacheImpl(int cacheSize) {
        this.cacheSize = cacheSize;
        pageList = new DoublyLinkedList(cacheSize);
        pageMap = new HashMap<>();
    }

    public Node getPageFromCache(int pageNum) {
        Node pageNode = null;
        if (pageMap.containsKey(pageNum)) {
            pageNode = pageMap.get(pageNum);
            pageList.movePageToHead(pageNode);
        }
        return pageNode;
    }

    public void addPageToCache(int pageNum) {
        if (pageList.currSize == cacheSize) {
            pageMap.remove(pageList.tail.num);
        }
        Node pageNode = pageList.addPageToList(pageNum);
        pageMap.put(pageNum, pageNode);
    }

    public void accessPage(int pageNum) {
        Node pageNode;
        if (pageMap.containsKey(pageNum)) {
            pageNode = pageMap.get(pageNum);
            pageList.movePageToHead(pageNode);
        } else {
            if (pageList.currSize == pageList.size) {
                pageMap.remove(pageList.tail.num);
            }
            pageNode = pageList.addPageToList(pageNum);
            pageMap.put(pageNum, pageNode);
        }
    }

    public void printCacheState() {
        pageList.printList();
        System.out.println();
    }

    public static void main(String[] args) {
        int cacheSize = 4;
        LRUCacheImpl cache = new LRUCacheImpl(cacheSize);
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
    }
}
