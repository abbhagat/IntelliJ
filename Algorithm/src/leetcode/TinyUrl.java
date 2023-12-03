package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {

    private int counter;
    private final Map<String, Integer> urlToIndex;
    private final Map<Integer, String> indexToUrl;
    private final String BASE_62;
    private final String URL;

    public TinyUrl() {
        counter = 1;
        urlToIndex = new HashMap<>();
        indexToUrl = new HashMap<>();
        BASE_62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        URL = "http://www.tinyurl.com/";
    }

    private String encode(String longURL) {
        if (!urlToIndex.containsKey(longURL)) {
            urlToIndex.put(longURL, counter);
            indexToUrl.put(counter, longURL);
            counter++;
        }
        return URL + base62Encode(urlToIndex.get(longURL));
    }

    private String base62Encode(int val) {
        StringBuilder url = new StringBuilder();
        while (val != 0) {
            int k = val % 62;
            url.append(BASE_62.charAt(k));
            val /= 62;
        }
        int l = 7 - url.length();
        for (int i = 1; i <= l; i++) {
            url.insert(0, 0);
        }
        return url.toString();
    }

    private String decode(String shortURL) {
        int index = 0;
        String url = shortURL.substring(shortURL.lastIndexOf("/") + 1);
        for (char x : url.toCharArray()) {
            index = index * 62 + BASE_62.indexOf(x);
        }
        return indexToUrl.get(index);
    }

    public static void main(String[] args) {
        TinyUrl tinyUrl = new TinyUrl();
        System.out.println(tinyUrl.encode("https://leetcode.com/problems/encode-and-decode-tinyurl/"));
        System.out.println(tinyUrl.decode("http://tinyurl.com/0000001"));
    }
}
