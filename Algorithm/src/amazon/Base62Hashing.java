package amazon;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Base62Hashing {

    private volatile int counter = 1;
    private Map<Integer, String> indexToUrl = new ConcurrentHashMap<>();
    private Map<String, Integer> urlToIndex = new ConcurrentHashMap<>();
    private final String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encode(String longUrl) {
        if (!urlToIndex.containsKey(longUrl)) {
            indexToUrl.put(counter, longUrl);
            urlToIndex.put(longUrl, counter);
            counter++;
        }
        return "http://tinyurl.com/" + base62Encode(urlToIndex.get(longUrl));
    }

    public String decode(String shortUrl) {
        String base62Encoded = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
        int decode = 0;
        for (int i = 0; i < base62Encoded.length(); i++) {
            decode = decode * 62 + base62.indexOf("" + base62Encoded.charAt(i));
        }
        return indexToUrl.get(decode);
    }

    private String base62Encode(int value) {
        StringBuilder hashVal = new StringBuilder();
        while (value != 0) {
            hashVal.append(base62.charAt(value % 62));
            value /= 62;
        }
        int l = hashVal.length();
        for (int i = 1; i < 7 - l; i++) {
            hashVal.insert(0,0);
        }
        return hashVal.toString();
    }

    public static void main(String[] args) {
        Base62Hashing base62Hashing = new Base62Hashing();
        System.out.println(base62Hashing.encode("https://leetcode.com/problems/encode-and-decode-tinyurl/"));
        System.out.println(base62Hashing.decode("http://tinyurl.com/000001"));
    }
}
