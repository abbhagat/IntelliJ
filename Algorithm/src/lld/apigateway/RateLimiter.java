package lld.apigateway;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class RateLimiter {

  private final Map<String, Integer> rateLimitMap;

  public boolean allowRequest(Request request) {
    String clientId = request.headers().get("client-id");
    rateLimitMap.put(clientId, rateLimitMap.getOrDefault(clientId, 0) + 1);
    return rateLimitMap.get(clientId) <= 5;
  }
}
