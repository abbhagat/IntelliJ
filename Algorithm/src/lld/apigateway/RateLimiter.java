package lld.apigateway;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {

  private final Map<String, Integer> requestMap = new HashMap<>();

  public boolean allowRequest(String clientId) {
    requestMap.put(clientId, requestMap.getOrDefault(clientId, 0) + 1);
    return requestMap.get(clientId) <= 5;
  }
}
