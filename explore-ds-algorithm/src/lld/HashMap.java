package lld;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@SuppressWarnings("unchecked")
class HashMap<K, V> {

  private final static int SIZE = 128;
  private final Entry<K, V>[] table = new Entry[SIZE];

  private static final class Entry<K, V> {
    @Getter
    private final K key;

    @Getter
    @Setter
    private V value;

    private Entry<K, V> next;

    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }

  public V get(K key) {
    int hash = (key == null) ? 0 : Math.abs(key.hashCode() % SIZE);
    for (Entry<K, V> e = table[hash]; e != null; e = e.next) {
      if (Objects.equals(e.getKey(), key)) {
        return e.getValue();
      }
    }
    return null;
  }

  public V put(K key, V value) {
    int hash = (key == null) ? 0 : Math.abs(key.hashCode() % SIZE);
    Entry<K, V> prev = null;
    for (Entry<K, V> e = table[hash]; e != null; e = e.next) {
      if (Objects.equals(e.getKey(), key)) {
        e.setValue(value);
        return null;
      }
      prev = e;
    }
    Entry<K, V> entry = new Entry<>(key, value);
    if (prev == null) {
      table[hash] = entry;
    } else {
      prev.next   = entry;
    }
    return null;
  }

  public V remove(K key) {
    int hash = (key == null) ? 0 : Math.abs(key.hashCode() % SIZE);
    Entry<K, V> prev = null;
    for (Entry<K, V> e = table[hash]; e != null; e = e.next) {
      if (Objects.equals(e.getKey(), key)) {
        if (prev == null) {
          table[hash] = e.next;
        } else {
          prev.next   = e.next;
        }
        return e.getValue();
      }
      prev = e;
    }
    return null;
  }

  public void traverseHashMap() {
    for (int i = 0; i < SIZE; i++) {
      for (Entry<K, V> e = table[i]; e != null; e = e.next) {
        System.out.println("Key : " + e.getKey() + "\tValue : " + e.getValue());
      }
    }
  }

  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("Bhagat", 66);
    map.put("D", 68);
    map.put("D", 70);
    map.put(null, 1);
    map.put(null, 2);
    map.put("A", 100);
    map.put("Kumar", 66);
    map.put("Z", 90);
    map.put("D", 100);
    map.put("Abhinaw", 100);
    map.put("Z", 1);
    map.traverseHashMap();
    System.out.println("*********");
    System.out.println(map.remove("D"));
    System.out.println(map.remove("D1"));
    System.out.println(map.remove(null));
    map.traverseHashMap();
  }

}
