package lld.ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements IRateLimiter {

  private final int capacity;
  private final int refillRate;
  private final Map<String, TokenBucket> tokenBucketMap;

  public TokenBucketRateLimiter(int capacity, int refillRate) {
    this.capacity       = capacity;
    this.refillRate     = refillRate;
    this.tokenBucketMap = new ConcurrentHashMap<>();
  }

  @Override
  public boolean allowRequest(String userId) {
     return tokenBucketMap
            .computeIfAbsent(userId, value -> new TokenBucket(capacity, refillRate))
            .consumeTokens();
  }
}
