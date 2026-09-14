package lld.apigateway;

import lombok.AllArgsConstructor;
import java.util.Map;

@AllArgsConstructor
public class RateLimiter {

  private final Map<String, Integer> rateLimiter;

  public boolean allowRequest(Request request) {
    String clientId = request.headers().get("client-id");
    rateLimiter.put(clientId, rateLimiter.getOrDefault(clientId, 0) + 1);
    return rateLimiter.get(clientId) <= 5;
  }
}
