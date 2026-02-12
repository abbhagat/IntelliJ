package lld.apigateway;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {

  private final int MAX_REQUEST_PER_USER = 5;

  private final Map<String, Integer> requestCount = new HashMap<>();

  public boolean allowRequest(String clientId) {
    requestCount.put(clientId, requestCount.getOrDefault(clientId, 0) + 1);
    return requestCount.get(clientId) <= MAX_REQUEST_PER_USER;
  }
}
