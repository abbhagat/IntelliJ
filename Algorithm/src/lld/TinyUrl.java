package lld;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TinyUrl {

  private final Map<String, Integer> urlToIndexMap;
  private final Map<Integer, String> indexToUrlMap;
  private final String BASE_62;
  private final String BASE_URL;
  private final AtomicInteger counter;

  public TinyUrl() {
    counter       = new AtomicInteger(1);
    urlToIndexMap = new ConcurrentHashMap<>();
    indexToUrlMap = new ConcurrentHashMap<>();
    BASE_62       = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    BASE_URL      = "http://www.tinyurl.com/";
  }

  private String encode(String longURL) {
    if (!urlToIndexMap.containsKey(longURL)) {
      urlToIndexMap.put(longURL, counter.get());
      indexToUrlMap.put(counter.get(), longURL);
      counter.addAndGet(1);
    }
    return BASE_URL + base62Encode(urlToIndexMap.get(longURL));
  }

  private String base62Encode(int n) {
    char[] c = new char[7];
    int i = c.length - 1;
    while (n != 0) {
      c[i] = BASE_62.charAt(n % 62);  // Base-62 encoding (in reverse)
      n /= 62;
      i--;
    }
    Arrays.fill(c, 0, i + 1, '0'); // Fill remaining positions with '0'
    return new String(c);
  }

  private String decode(String shortURL) {
    int n = 0;
    int index = shortURL.lastIndexOf("/");
    String encodedString = shortURL.substring( index + 1);
    for (char c : encodedString.toCharArray()) {
      n = n * 62 + BASE_62.indexOf(c);
    }
    return indexToUrlMap.get(n);
  }

  public static void main(String[] args) {
    TinyUrl tinyUrl = new TinyUrl();
    String url      = "https://leetcode.com/problems/encode-and-decode-tinyurl";
    String shortURL = tinyUrl.encode(url);   // http://www.tinyurl.com/0000001
    String longURL  = tinyUrl.decode(shortURL);
    System.out.println(shortURL);
    System.out.println(longURL);
    System.out.println(url.equals(longURL));
    url      = "https://leetcode.com/problems/encode-and-decode-tinyurls";
    shortURL = tinyUrl.encode(url);   // http://www.tinyurl.com/0000001
    longURL  = tinyUrl.decode(shortURL);
    System.out.println(shortURL);
    System.out.println(longURL);
    System.out.println(url.equals(longURL));
  }
}
