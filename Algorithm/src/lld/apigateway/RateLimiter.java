package lld.apigateway;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {

  private final Map<String, Integer> requestCount = new HashMap<>();

  public boolean allowRequest(String clientId) {
    requestCount.put(clientId, requestCount.getOrDefault(clientId, 0) + 1);
    return requestCount.get(clientId) <= 5;
  }
}
