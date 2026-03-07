package lld;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TinyUrl {

  private final Map<String, Integer> urlToIndexMap;
  private final Map<Integer, String> indexToUrlMap;
  private final String BASE_62;
  private final String BASE_URL;
  private int index;

  public TinyUrl() {
    index = 1;
    urlToIndexMap = new HashMap<>();
    indexToUrlMap = new HashMap<>();
    BASE_62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    BASE_URL = "http://www.tinyurl.com/";
  }

  private String encode(String longURL) {
    if (!urlToIndexMap.containsKey(longURL)) {
      urlToIndexMap.put(longURL, index);
      indexToUrlMap.put(index, longURL);
      index++;
    }
    return BASE_URL + base62Encode(urlToIndexMap.get(longURL));
  }

  private String base62Encode(int index) {
    char[] c = new char[7];
    int i;
    for (i = 6; i >= 0; i--) {
      c[i] = BASE_62.charAt(index % 62);     // Base-62 encoding (in reverse)
      index /= 62;
    }
    Arrays.fill(c, 0, i + 1, '0'); // Fill remaining positions with '0'
    return new String(c);
  }

  private String decode(String shortURL) {
    int index = 0;
    String base62EncodedCounterVal = shortURL.substring(shortURL.lastIndexOf("/") + 1);
    for (char c : base62EncodedCounterVal.toCharArray()) {
      index = index * 62 + BASE_62.indexOf(c);
    }
    return indexToUrlMap.get(index);
  }

  public static void main(String[] args) {
    TinyUrl tinyUrl = new TinyUrl();
    String url = "https://leetcode.com/problems/encode-and-decode-tinyurl";
    String shortURL = tinyUrl.encode(url);   // http://www.tinyurl.com/0000001
    String longURL = tinyUrl.decode(shortURL);
    System.out.println(shortURL);
    System.out.println(longURL);
    System.out.println(url.equals(longURL));
  }
}
