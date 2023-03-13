package oracle;

public class TMHashMap<K, V> {

    private final static int SIZE = 128;
    private Entry[] table = new Entry[SIZE];

    private final class Entry<K, V> {
        private final K key;
        private V value;
        private Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public V get(K key) {
        int hash = key == null ? 0 : key.hashCode() % SIZE;
        for (Entry e = table[hash]; e != null; e = e.next) {
            if (null == e.getKey() || e.getKey().equals(key)) {
                return (V) e.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        int hash = (null == key) ? 0 : key.hashCode() % SIZE;
        Entry e = table[hash], prev = e;
        while (e != null) {
            if (e.next == null) {
                table[hash] = null;
            } else {
                if (null == e.getKey() || e.getKey().equals(key)) {
                    prev.next = e.next;
                }
            }
            e = e.next;
        }
        return (V) prev.getValue();
    }

    public V put(K key, V value) {
        int hash = (null == key) ? 0 : key.hashCode() % SIZE;
        Entry e = table[hash];
        if (null != e) {
            if (null == e.getKey() || key.equals(e.getKey())) {
                e.setValue(value);
            } else {
                while (e.next != null) {
                    e = e.next;
                }
                table[hash] = new Entry(key, value);
                e.next = table[hash];
                return (V) e.getValue();
            }
        }
        table[hash] = new Entry(key, value);
        return null;
    }

    public void traverseHashMap() {
        for (int i = 0; i < SIZE; i++) {
            for (Entry e = table[i]; e != null; e = e.next) {
                System.out.println("Key : " + table[i].getKey() + "\tValue : " + table[i].getValue());
            }
        }
    }

    public static void main(String[] args) {
        TMHashMap<String, Integer> map = new TMHashMap<>();
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
        System.out.println(map.remove(null));
        map.traverseHashMap();
    }
}
