package lld.tinyurl;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {

  private final Map<String, Integer> urlToIndex;
  private final Map<Integer, String> indexToUrl;
  private final String BASE_62;
  private final String BASE_URL;
  private int counter;

  public TinyUrl() {
    counter = 1;
    urlToIndex = new HashMap<>();
    indexToUrl = new HashMap<>();
    BASE_62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    BASE_URL = "http://www.tinyurl.com/";
  }

  public static void main(String[] args) {
    TinyUrl tinyUrl = new TinyUrl();
    String url = "https://leetcode.com/problems/encode-and-decode-tinyurl/";
    String shortURL = tinyUrl.encode(url);   // http://www.tinyurl.com/0000001
    String longURL = tinyUrl.decode(shortURL);
    System.out.println(shortURL);
    System.out.println(longURL);
    System.out.println(url.equals(longURL));
  }

  private String encode(String longURL) {
    if (!urlToIndex.containsKey(longURL)) {
      urlToIndex.put(longURL, counter);
      indexToUrl.put(counter, longURL);
      counter++;
    }
    return BASE_URL + base62Encode(urlToIndex.get(longURL));
  }

  private String base62Encode(int val) {
    char[] c = new char[7];
    int i = 6;
    // Base-62 encoding (in reverse)
    while (val > 0 && i >= 0) {
      c[i] = BASE_62.charAt(val % 62);
      i--;
      val /= 62;
    }
    // Fill remaining positions with '0'
    while (i >= 0) {
      c[i--] = '0';
    }
    return new String(c);
  }

  private String decode(String shortURL) {
    int counter = 0;
    String base62EncodedCounterVal = shortURL.substring(shortURL.lastIndexOf("/") + 1);
    for (char x : base62EncodedCounterVal.toCharArray()) {
      counter = counter * 62 + BASE_62.indexOf(x);
    }
    return indexToUrl.get(counter);
  }
}
