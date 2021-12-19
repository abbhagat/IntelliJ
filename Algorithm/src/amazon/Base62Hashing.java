package amazon;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Base62Hashing {

    private static volatile Long counter = 1L;
    private static Map<Long, String> indexToUrl = new ConcurrentHashMap<>();
    private static Map<String, Long> urlToIndex = new ConcurrentHashMap<>();
    private static String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(String longUrl) {       // Encodes a URL to a shortened URL.
        if (!urlToIndex.containsKey(longUrl)) {
            indexToUrl.put(counter, longUrl);
            urlToIndex.put(longUrl, counter);
            counter++;
        }
        return "http://tinyurl.com/" + base62Encode(urlToIndex.get(longUrl));
    }

    public static String decode(String shortUrl) {  // Decodes a shortened URL to its original URL.
        String base62Encoded = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
        long decode = 0;
        for (int i = 0; i < base62Encoded.length(); i++) {
            decode = decode * 62 + base62.indexOf("" + base62Encoded.charAt(i));
        }
        return indexToUrl.get(decode);
    }

    private static String base62Encode(long value) {
        String s = "";
        while (value != 0) {
            s = base62.charAt((int) (value % 62)) + s;
            value /= 62;
        }
        int l = s.length();
        for (int i = 1; i < 7 - l; i++) {
            s = 0 + s;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(encode("https://leetcode.com/problems/encode-and-decode-tinyurl/"));
        System.out.println(decode("http://tinyurl.com/000001"));
    }
}
