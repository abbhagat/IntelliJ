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
1. Page is present in the cache - If the page is already present in the cache, we move the page to the start of the list.
2. Page is not present in the cache - If the page is not present in the cache, we add the page to the list.
How to add a page to the list:
a. If the cache is not full, add the new page to the start of the list.
b. If the cache is full, remove the last node of the linked list and move the new page to the start of the list.
 */

public class LRUCache {

    private DoublyLinkedList pageList;
    private Map<Integer, Node> pageMap;
    private final int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        pageList = new DoublyLinkedList(cacheSize);
        pageMap = new HashMap<>();
    }

    public Node getPage(int pageNum) {
        Node pageNode = null;
        if (pageMap.containsKey(pageNum)) {
            pageNode = pageMap.get(pageNum);
            pageList.movePageToHead(pageNode);
        }
        return pageNode;
    }

    public void addPage(int num) {
        Node pageNode;
        if (pageList.currSize == cacheSize) {
            pageMap.remove(pageList.tail.num);
        }
        pageNode = pageList.addPageToList(num);
        pageMap.put(num, pageNode);
    }

    public void accessPage(int num) {
        Node pageNode;
        if (pageMap.containsKey(num)) {
            pageNode = pageMap.get(num);
            pageList.movePageToHead(pageNode);
        } else {
            if (pageList.currSize == pageList.size) {
                pageMap.remove(pageList.tail.num);
            }
            pageNode = pageList.addPageToList(num);
            pageMap.put(num, pageNode);
        }
    }

    public void printCacheState() {
        pageList.printList();
        System.out.println();
    }

    public static void main(String[] args) {
        int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);
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

class Node {
    int num;
    Node prev, next;

    public Node(int num) {
        this.num = num;
    }
}

class DoublyLinkedList {

    final int size;
    int currSize;
    Node head, tail;

    public DoublyLinkedList(int size) {
        this.size = size;
        currSize = 0;
    }

    public void printList() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.num + " ");
        }
    }

    public Node addPageToList(int num) {
        Node node = new Node(num);
        if (head == null) {
            head = node;
            tail = node;
            currSize = 1;
            return node;
        } else if (currSize < size) {
            currSize++;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        node.next = head;
        head.prev = node;
        head = node;
        return node;
    }

    public void movePageToHead(Node pageNode) {
        if (pageNode == null || pageNode == head) {
            return;
        }
        if (pageNode == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        Node prev = pageNode.prev;
        Node next = pageNode.next;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
        pageNode.prev = null;
        pageNode.next = head;
        head.prev = pageNode;
        head = pageNode;
    }
}
