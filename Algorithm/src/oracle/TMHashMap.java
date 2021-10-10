package oracle;

public class TMHashMap<K,V> {

    private final static int SIZE = 128;
    private Entry[] table = new Entry[SIZE];

    private final class Entry<K,V> {
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

    public V get(String key) {
        int hash = key == null ? 0 : key.hashCode() % SIZE;
        for (Entry e = table[hash]; e != null; e = e.next) {
            if (null == e.getKey() || e.getKey().equals(key)) {
                return (V) e.getValue();
            }
        }
        return null;
    }

    public boolean remove(String key) {
        int hash = (null == key) ? 0 : key.hashCode() % SIZE;
        for (Entry e = table[hash]; e != null; e = e.next) {
            if (null == e.getKey() || e.getKey().equals(key)) {
                e.setValue(null);
                return true;
            }
        }
        return false;
    }

    public V put(String key, int value) {
        int hash = (null == key) ? 0 : key.hashCode() % SIZE;
        Entry e = table[hash];
        if (null != e) {
            if (null == e.getKey() || key.equals(e.getKey())) {
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
            if (null != table[i]) {
                System.out.println("Key : " + table[i].getKey() + "\tValue : " + table[i].getValue());
            }
        }
    }

    public static void main(String[] args) {
        TMHashMap<String,Integer> map = new TMHashMap<>();
        System.out.println(map.put("Abhinaw", 65));
        map.put("Bhagat", 66);
        map.put("D", 68);
        map.put("D", 70);
        map.put(null, 1);
        map.put(null, 2);
        map.put("A", 100);
        map.put("Kumar", 66);
        map.put("Z", 90);
        map.put("D", 100);
        System.out.println(map.put("Abhinaw", 100));
        map.put("Z", 1);
        map.remove("A");
        map.remove(null);
        // Entry e = map.get(null);
        // if(e==null){
        // System.out.println(table[0].getValue());
        // }else{
        // System.out.println(e.getValue());
        // }
        map.traverseHashMap();
        System.out.println(map.get(null));
    }
}
