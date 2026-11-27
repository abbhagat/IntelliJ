package lld;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LFUCache<K, V> {

  private static class Node<K, V> {
    K key;
    V value;
    int freq;

    public Node(K key, V value) {
      this.key   = key;
      this.value = value;
      this.freq  = 1;
    }
  }

  private final Map<K, Node<K, V>> map;
  private final Map<Integer, Deque<Node<K, V>>> freqMap;
  private final int cacheSize;
  private       int minFreq;

  public LFUCache(int cacheSize) {
    this.cacheSize = cacheSize;
    this.map       = new HashMap<>();
    this.freqMap   = new HashMap<>();
  }

  public V get(K key) {
    Node<K, V> node = map.get(key);
    if (node == null) {
      return null;
    }
    updateFrequency(node);
    return node.value;
  }

  public void put(K key, V value) {
    // Update existing key
    if (map.containsKey(key)) {
      Node<K, V> node = map.get(key);
      node.value = value;
      updateFrequency(node);
      return;
    }
    // Evict LFU + LRU node
    if (map.size() == cacheSize) {
      Deque<Node<K, V>> deque = freqMap.get(minFreq);
      Node<K, V> node = deque.pollLast();
      map.remove(node.key);
    }
    // Insert new node
    Node<K, V> node = new Node<>(key, value);
    map.put(key, node);
    freqMap.computeIfAbsent(1, k -> new LinkedList<>()).offerFirst(node);
    minFreq = 1;
  }

  private void updateFrequency(Node<K, V> node) {
    int oldFreq = node.freq;
    Deque<Node<K, V>> oldDeque = freqMap.get(oldFreq);
    oldDeque.remove(node);
    if (oldFreq == minFreq && oldDeque.isEmpty()) {
      minFreq++;
    }
    node.freq++;
    freqMap.computeIfAbsent(node.freq, k -> new LinkedList<>()).offerFirst(node);
  }

  public static void main(String[] args) {
    LFUCache<Integer, String> map = new LFUCache<>(2);
    map.put(1, "Apple");
    map.put(2, "Banana");
    System.out.println(map.get(1)); // Apple
    map.put(3, "Orange");
    System.out.println(map.get(2)); // null (evicted)
    System.out.println(map.get(3)); // Orange
    System.out.println(map.get(1)); // Apple
    map.put(4, "Mango");
    System.out.println(map.get(3)); // null (evicted)
    System.out.println(map.get(4)); // Mango
  }
}
