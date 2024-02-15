package oracle;

import lombok.Getter;
import lombok.Setter;

public class HashMap<K, V> {

    private final static int SIZE = 128;
    private final Entry<K,V>[] table = new Entry[SIZE];

    private static final class Entry<K, V> {
        @Getter
        private final K key;
        @Getter
        @Setter
        private V value;
        private Entry<K,V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public V get(K key) {
        int hash = key == null ? 0 : key.hashCode() % SIZE;
        for (Entry<K,V> e = table[hash]; e != null; e = e.next) {
            if (null == e.getKey() || e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }

    public V put(K key, V value) {
        int hash = (null == key) ? 0 : key.hashCode() % SIZE;
        if (null != table[hash]) {
            Entry<K,V> prev = null;
            for (Entry<K,V> e = table[hash]; e != null; e = e.next) {
                prev = e;
                if (null == e.getKey() || e.getKey().equals(key)) {
                    e.setValue(value);
                    return null;
                }
            }
            table[hash] = new Entry<>(key, value);
            prev.next = table[hash];
            return prev.getValue();
        }
        table[hash] = new Entry<>(key, value);
        return null;
    }

    public V remove(K key) {
        int hash = (null == key) ? 0 : key.hashCode() % SIZE;
        Entry<K,V> e = table[hash], prev = e;
        if (e == null) {
            return null;
        }
        while (e != null) {
            if (e.next == null) {
                table[hash] = null;
            } else if (null == e.getKey() || e.getKey().equals(key)) {
                    prev.next = e.next;
              }
            e = e.next;
        }
        return prev.getValue();
    }

    public void traverseHashMap() {
        for (int i = 0; i < SIZE; i++) {
            for (Entry<K,V> e = table[i]; e != null; e = e.next) {
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
