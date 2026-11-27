package lld;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LFUCache {

  private static class Node {
    int key, value, freq = 1;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int capacity;
  private int minFreq;
  private final Map<Integer, Node> cache = new HashMap<>();
  private final Map<Integer, Deque<Node>> freqMap = new HashMap<>();

  public LFUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    Node node = cache.get(key);
    if (node == null) {
      return -1;
    }
    updateFrequency(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    // Update existing key
    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      node.value = value;
      updateFrequency(node);
      return;
    }

    // Evict LFU + LRU node
    if (cache.size() == capacity) {
      Deque<Node> deque = freqMap.get(minFreq);
      Node node = deque.pollLast();
      cache.remove(node.key);
    }
    // Insert new node
    Node node = new Node(key, value);
    cache.put(key, node);
    freqMap.computeIfAbsent(1, k -> new LinkedList<>()).offerFirst(node);
    minFreq = 1;
  }

  private void updateFrequency(Node node) {
    int oldFreq = node.freq;
    Deque<Node> oldDeque = freqMap.get(oldFreq);
    oldDeque.remove(node);
    if (oldFreq == minFreq && oldDeque.isEmpty()) {
      minFreq++;
    }
    node.freq++;
    freqMap.computeIfAbsent(node.freq, k -> new LinkedList<>()).offerFirst(node);
  }

  public static void main(String[] args) {

  }
}
