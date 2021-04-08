package core;

public class TMHashMap {

    private final static int SIZE = 128;
    private Entry[] table = new Entry[SIZE];

    class Entry {
        private final String key;
        private Integer value;
        private Entry next;

        public Entry(String key, Integer value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public String getKey() {
            return key;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    public Integer get(String key) {
        int hash = key == null ? 0 : key.hashCode() % SIZE;
        Entry e = table[hash];
        while (e != null) {
            if (null == e.getKey() || e.getKey().equals(key)) {
                return e.getValue();
            }
            e = e.next;
        }
        return null;
    }

    public Integer put(String key, int value) {
        int hash = (null == key) ? 0 : key.hashCode() % SIZE;
        Entry e = table[hash];
        if (null != e) {
            if (null == e.getKey() || key.equals(e.getKey())) {
                Entry prev = null;
                while (null != e) {
                    prev = e;
                    e = e.next;
                }
                table[hash] = new Entry(key, value);
                prev.next = table[hash];
                return prev.getValue();
            }
        }
        table[hash] = new Entry(key, value);
        return null;
    }

    public boolean remove(String key) {
        int hash = (null == key) ? 0 : key.hashCode() % SIZE;
        Entry e = table[hash];
        while (e != null) {
            if (e.getKey() == null || e.getKey().equals(key)) {
                table[hash] = null;
                return true;
            }
            e = e.next;
        }
        return false;
    }

    public void traverseHashMap() {
        for (int i = 0; i < SIZE; i++) {
            if (null != table[i]) {
                System.out.println("Key :" + table[i].getKey() + "\tValue" + table[i].getValue());
            }
        }
    }

    public static void main(String[] args) {
        TMHashMap map = new TMHashMap();
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
