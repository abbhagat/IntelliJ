package lld.apigateway;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class RateLimiter {

  private final Map<String, Integer> requestMap;

  public boolean allowRequest(String clientId) {
    requestMap.put(clientId, requestMap.getOrDefault(clientId, 0) + 1);
    return requestMap.get(clientId) <= 5;
  }
}
