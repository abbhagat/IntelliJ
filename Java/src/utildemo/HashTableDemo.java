package utildemo;

import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        // hashtable.put(null, null);  // --> does not allow null key or null value
        System.out.println(hashtable.size());
    }
}
